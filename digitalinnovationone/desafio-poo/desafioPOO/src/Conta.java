
public class Conta {
    private String nome;
    private int numeroConta;
    private double saldo;

    //construtor para inicializar os atributos da conta
    public Conta (String titular, int numeroConta, double saldoInicial){
        this.nome = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    //método público para consultar o saldo
    public double consultarSaldo (){
        return saldo;
    }   
    
    //método público para realizar saque
    public Boolean sacar (double valorSaque){
        if (saldo >= valorSaque){
            saldo = saldo - valorSaque;
            return true;
        }
        return false;
    }

    //método público para realizar depósito
    public void depositar(double valorDeposito){
        if (valorDeposito >=0)
            saldo = saldo + valorDeposito;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

}
