const axios = require("axios");
const crypto = require("crypto");

const SYMBOL = "BTCUSDT";
const QUANTITY = "0.001";
const PERIOD = 14;

// para gerar uma SECRET KEY, acesse a sua conta na Binance, vá em API Management e crie uma nova API Key
// https://testnet.binance.vision/ e conecte sua conta github para obter uma API Key de teste
const API_URL = "https://testnet.binance.vision";//"https://api.binance.com"
const API_KEY = "ZkcmxzEdNRDTSv7Z2Z2NIgmrE5hV71MmDEapfojHrrVZ2ANm6RxkQ20VwnS3oZQQ";
const SECRET_KEY = "o1R3ILzmWcb9M8xNcnhNS23uM7rYJVTsT8fkepvMubB4gHLtbU97UZGIXxP9Qg5w";

function averages(prices, period, startIndex) {
    let gains = 0, losses = 0;

    for (let i = 0; i < period && (i + startIndex) < prices.length; i++) {
        const diff = prices[i + startIndex] - prices[i + startIndex - 1];
        if (diff >= 0)
            gains += diff;
        else
            losses += Math.abs(diff);
    }

    let avgGains = gains / period;
    let avgLosses = losses / period;
    return { avgGains, avgLosses };
}

function RSI(prices, period){
    let avgGains = 0, avgLosses = 0;

    for(let i=1; i < prices.length; i++){
        let newAverages = averages(prices, period, i);

        if(i === 1){
            avgGains = newAverages.avgGains;
            avgLosses = newAverages.avgLosses;
            continue;
        }

        avgGains = (avgGains * (period -1) + newAverages.avgGains) / period;
        avgLosses = (avgLosses * (period -1) + newAverages.avgLosses) / period;
    }

    const rs = avgGains / avgLosses;
    return 100 - (100 / (1 + rs));
}

async function newOrder(symbol, quantity, side){
    const order = { symbol, quantity, side };
    order.type = "MARKET";
    order.timestamp = Date.now();

    const signature = crypto
        .createHmac("sha256", SECRET_KEY)
        .update(new URLSearchParams(order).toString())
        .digest("hex");

    order.signature = signature;

    try{
        const {data} = await axios.post(
            API_URL + "/api/v3/order", 
            new URLSearchParams(order).toString(), 
            {
                headers: { "X-MBX-APIKEY": API_KEY }
            }
        )

        console.log(data);
    }
    catch(err){
        console.error(err.response.data);
    }
}

let isOpened = false;
let highs = [];
let lows = [];

function checkDivergenceConvergence() {
    if (highs.length >= 2) {
        const [prevHigh, currHigh] = highs.slice(-2);
        if (currHigh.price > prevHigh.price && currHigh.rsi < prevHigh.rsi) {
            console.log(`Bearish Divergence Detected! Price: ${currHigh.price} (prev: ${prevHigh.price}), RSI: ${currHigh.rsi} (prev: ${prevHigh.rsi})`);
        } else if (currHigh.price < prevHigh.price && currHigh.rsi > prevHigh.rsi) {
            console.log(`Bullish Divergence Detected! Price: ${currHigh.price} (prev: ${prevHigh.price}), RSI: ${currHigh.rsi} (prev: ${prevHigh.rsi})`);
        }

    }

    if (lows.length >= 2) {
        const [prevLow, currLow] = lows.slice(-2);
        if (currLow.price < prevLow.price && currLow.rsi > prevLow.rsi) {
            console.log(`Bullish Convergence Detected! Price: ${currLow.price} (prev: ${prevLow.price}), RSI: ${currLow.rsi} (prev: ${prevLow.rsi})`);
        } else if (currLow.price > prevLow.price && currLow.rsi < prevLow.rsi) {
            console.log(`Bearish Convergence Detected! Price: ${currLow.price} (prev: ${prevLow.price}), RSI: ${currLow.rsi} (prev: ${prevLow.rsi})`);
        }

    }
}

async function start() {

    const { data } = await axios.get(API_URL + "/api/v3/klines?limit=100&interval=15m&symbol=" + SYMBOL);
    const candle = data[data.length - 1];
    const lastPrice = parseFloat(candle[4]);

    //console.clear();
    console.log("Price: " + lastPrice);

    const prices = data.map(k => parseFloat(k[4]));
    const rsi = RSI(prices, PERIOD);
    console.log("RSI: " + rsi);
    console.log("Já comprei? " + isOpened);

    // Track highs and lows
    const currentPrice = prices[prices.length - 1];
    
    if (highs.length === 0 || currentPrice > highs[highs.length - 1].price) {
        highs.push({ price: currentPrice, rsi: rsi });
    }
    
    if (lows.length === 0 || currentPrice < lows[lows.length - 1].price) {
        lows.push({ price: currentPrice, rsi: rsi });
    }

    // Check for divergences/convergences
    checkDivergenceConvergence();


    if (rsi < 30 && isOpened === false) {
        console.log("sobrevendido, hora de comprar");
        isOpened = true;
        newOrder(SYMBOL, QUANTITY, "BUY");
    }
    else if (rsi > 70 && isOpened === true) {
        console.log("sobrecomprado, hora de vender");
        newOrder(SYMBOL, QUANTITY, "SELL");
        isOpened = false;
    }
    else
        console.log("aguardar");
}

setInterval(start, 3000);

start();
