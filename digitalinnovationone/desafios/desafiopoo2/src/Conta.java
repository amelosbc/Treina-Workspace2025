abstract class Conta {
    protected double saldo; 

    
    public Conta(double saldo) {
        this.saldo = saldo;
    }

    
    public abstract void sacar(double valor);

    
    public void exibirSaldo() {
        System.out.printf("Saldo Atual: %.2f%n", saldo);
    }
}


class ContaCorrente extends Conta {
    private double limite; 
        
    public ContaCorrente(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando o saldo e o limite:
        // Dica: Se saldo - valor >= -limite, o saque é permitido.
         // diminui o saldo com o valor do saque somente se o saldo - valor for maior ou igual ao limite negativo
        if (saldo - valor < -limite) {
            System.out.println("Saque invalido: Excede limite");
        }
        else{
          saldo -= valor; // Atualiza o saldo com o valor do saque   
        
          System.out.printf("Saque realizado: %.2f%n", valor);
        }


        exibirSaldo(); // Exibe o saldo atualizado
        return;
    }
}


class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    // Implementação do método sacar para Conta Poupança
    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando apenas o saldo:
        // Dica: Se saldo >= valor, o saque é permitido.
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando apenas o saldo:
        // Dica: Se saldo >= valor, o saque é permitido.
        if (saldo < valor) {
            System.out.println("Saque invalido: Saldo insuficiente");
        }
        else{
          saldo -= valor; // Atualiza o saldo com o valor do saque
        
          System.out.printf("Saque realizado: %.2f%n", valor);
        }

        exibirSaldo(); // Exibe o saldo atualizado
        return;
    }
}