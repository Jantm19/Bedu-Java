/**
 * Clase principal que muestra un menú para seleccionar el método de pago e ingresar el monto desde consola.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Tarjeta");
        System.out.println("2. PayPal");
        System.out.println("3. Criptomonedas");
        System.out.println("4. Transferencia bancaria");
        System.out.print("Opción (1-4): ");
        int option = scanner.nextInt();

        System.out.print("Ingrese el monto a pagar: ");
        double amount = scanner.nextDouble();

        PaymentMethod paymentMethod;

        switch (option) {
            case 1:
                paymentMethod = new CardPayment();
                break;
            case 2:
                paymentMethod = new PayPalPayment();
                break;
            case 3:
                paymentMethod = new CryptoPayment();
                break;
            case 4:
                paymentMethod = new BankTransferPayment();
                break;
            default:
                System.out.println("Opción no válida. Finalizando programa.");
                scanner.close();
                return;
        }

        processor.process(paymentMethod, amount);
        scanner.close();
    }
}
