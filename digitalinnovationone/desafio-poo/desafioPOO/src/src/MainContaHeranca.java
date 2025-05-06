
public class MainContaHeranca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipoConta = scanner.next(); 
        scanner.nextLine(); 
        scanner.nextLine(); 
        scanner.next(); 
        double saldoInicial = scanner.nextDouble(); 

        Conta conta;

        // TODO: Implemente a lógica para criar uma instância de ContaCorrente ou ContaPoupanca:
        // Dica: Use um if para verificar o tipo da conta.
        
            // TODO: Para Conta Corrente, leia também o limite de cheque especial e crie a instância.
            
        
  
            // TODO: Para Conta Poupança, apenas inicialize a conta com o saldo inicial:
        

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble(); 
            conta.sacar(valorSaque); 
        }

        scanner.close(); 
    }
}