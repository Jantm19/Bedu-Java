import java.util.Scanner;

/**
 * Clase que simula el funcionamiento de una caja registradora.
 * Crea un arreglo de diferentes métodos de pago y procesa cada uno.
 * Solicita datos al usuario para ingresar el monto y el tipo de pago, con un menú de opciones.
 * Pregunta si desea realizar otro pago utilizando opciones numéricas.
 */
public class CajaRegistradora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione el tipo de pago:");
            System.out.println("1. Efectivo");
            System.out.println("2. Tarjeta");
            System.out.println("3. Transferencia");

            int opcion = scanner.nextInt();

            System.out.println("Ingrese el monto: ");
            double monto = scanner.nextDouble();

            MetodoPago pago = null;

            switch (opcion) {
                case 1:
                    pago = new PagoEfectivo(monto);
                    break;
                case 2:
                    pago = new PagoTarjeta(monto);
                    break;
                case 3:
                    pago = new PagoTransferencia(monto);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (pago instanceof Autenticable) {
                Autenticable autenticable = (Autenticable) pago;
                if (autenticable.autenticar()) {
                    pago.procesarPago();
                    pago.mostrarResumen();
                }
            }

            System.out.println("\n¿Desea realizar otro pago?");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int respuesta = scanner.nextInt();
            if (respuesta == 2) {
                continuar = false;
            }
        }

        System.out.println("¡Gracias por su compra!");
        scanner.close();
    }
}
