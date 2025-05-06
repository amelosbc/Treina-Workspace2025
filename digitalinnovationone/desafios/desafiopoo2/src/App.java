import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // DESAFIO 1 

        // msg para o usuário
        System.out.println("Digite o tipo de conta (Corrente ou Poupanca): ");
        String tipoConta = scanner.next(); 

        System.out.println("Digite o Titular da conta: ");
        String nome = scanner.next();

        System.out.println("Digite o numero da conta: ");
        int numeroConta = Integer.parseInt(scanner.next());

        System.out.println("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        

        Conta conta = null;

        if (tipoConta.equals("Corrente")) {
            double limiteChequeEspecial = scanner.nextDouble(); 
            conta = new ContaCorrente(saldoInicial, limiteChequeEspecial); // Cria uma instância de ContaCorrente
        } else if (tipoConta.equals("Poupanca")) {
            conta = new ContaPoupanca(saldoInicial); // Cria uma instância de ContaPoupanca
        } else {
            System.out.println("Tipo de conta inválido.");
            scanner.close(); 
        }        

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble(); 
            conta.sacar(valorSaque); 
        }

        scanner.close(); 

        // DESAFIO 2

        double valorTotal = scanner.nextDouble();
        int numeroParcelas = scanner.nextInt();
        
        // TODO: Crie a lógica para verificar se o parcelamento é possível:

        // A condição deve garantir que o valor de cada parcela seja maior ou igual a 1. 
        // Se o valor total dividido pelo número de parcelas for menor que 1, imprima "Parcelamento não permitido".
        if (valorTotal / numeroParcelas < 1) {
            System.out.println("Parcelamento não permitido.");
        } else {
            System.out.println("Parcelamento permitido.");
        }
        
        // TODO: Implemente o código para  ler as 3 transações:
        // Esses valores representam as transações realizadas.
        // Armazene cada valor no array `transacoes` para processá-los depois.
        double[] transacoes = new double[3]; // Array para armazenar as transações
        for (int i = 0; i < transacoes.length; i++) {
            transacoes[i] = scanner.nextDouble(); // Lê o valor da transação e armazena no array
        }
        

        // DESAFIO 3

        // TODO: Realize a leitura do valor mínimo (4ª entrada):

        // Esse valor representa o limite mínimo para contar as transações.
        // Armazene o valor lido na variável `valorMinimo`.     

         double valorMinimo = scanner.nextDouble(); // Lê o valor mínimo para contar as transações
        // Caso o valor seja maior que o `valorMinimo`, incrementem o contador.


       // Este valor será usado como o critério para contar as transações maiores que ele.

       int contador = 0;

        for (int i = 0; i < transacoes.length; i++) {
            if (transacoes[i] > valorMinimo) {
                contador++; // Increment
            }
        }
  
       System.out.println(contador);

       scanner.close(); // Fecha o scanner após o uso

}
