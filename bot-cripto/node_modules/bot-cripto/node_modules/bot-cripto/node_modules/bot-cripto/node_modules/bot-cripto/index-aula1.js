const axios = require("axios");

const SYMBOL = "BTCUSDT";
const BYE_PRICE = 96300;
const SELL_PRICE = 96501;

const API_URL = "https://testnet.binance.vision";

let isOpened = false;

async function start() {
    const { data } = await axios.get(API_URL + "/api/v3/klines?limit=100&interval=15m&symbol=" + SYMBOL);
    const candle = data[data.length - 1];
    const price = parseFloat(candle[4]);

    console.clear();
    console.log("Price: " + price);

    if (price < BYE_PRICE && isOpened === false) {
        console.log("sobrevendido, hora de comprar");
        isOpened = true;
    }
    else if (price > SELL_PRICE && isOpened === true) {
        console.log("sobrecomprado, hora de vender");
        isOpened = false;
    }
    else
        console.log("aguardar");
}

setInterval(start, 3000);

start();