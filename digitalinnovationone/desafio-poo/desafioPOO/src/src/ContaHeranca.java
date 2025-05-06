import java.util.Scanner;

abstract class ContaHeranca {
    protected double saldo; 

    
    public ContaHeranca(double saldo) {
        this.saldo = saldo;
    }

    
    public abstract void sacar(double valor);

    
    public void exibirSaldo() {
        System.out.printf("Saldo Atual: %.2f%n", saldo);
    }
}
