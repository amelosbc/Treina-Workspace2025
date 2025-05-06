
class ContaCorrenteHeranca extends ContaHeranca {
    private double limite; 
        
    public ContaCorrenteHeranca(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando o saldo e o limite:
        // Dica: Se saldo - valor >= -limite, o saque é permitido.
       


        exibirSaldo(); // Exibe o saldo atualizado
    }
}