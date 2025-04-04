import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Por favor, forneça dois números inteiros.");
            return;
        }

        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            if (num1 > num2) {
                throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
            }

            for (int i = num1; i <= num2; i++) {
                System.out.println("Imprimindo o número " + i);
            }
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, forneça números inteiros válidos.");
        }
    }
}
