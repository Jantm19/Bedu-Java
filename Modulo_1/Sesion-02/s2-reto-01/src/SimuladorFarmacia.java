import java.util.Scanner;

public class SimuladorFarmacia {
    public static void main(String[] args) {
        // Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el nombre del medicamento: ");
        String medicamento = scanner.nextLine();
        System.out.print("Ingrese el precio unitario: ");
        double precioUnitario = scanner.nextDouble();
        System.out.print("Ingrese la cantidad de piezas: ");
        int cantidad = scanner.nextInt();

        // Calcular el total sin descuento
        double totalSinDescuento = precioUnitario * cantidad;

        // Determinar si aplica descuento
        var descuento = totalSinDescuento > 500 ? totalSinDescuento * 0.15 : 0;
        var totalPagar = totalSinDescuento - descuento;

        // Resumen de la compra
        System.out.println("\nResumen de la compra:");
        System.out.println("Medicamento: " + medicamento);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("¿Aplica descuento?: " + (descuento > 0));
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + totalPagar);

        // Cerrar el scanner
        scanner.close();
    }
}
