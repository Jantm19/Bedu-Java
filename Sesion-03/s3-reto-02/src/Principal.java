import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir los datos para la primera factura (con RFC)
        System.out.println("Ingrese los datos para la factura 1:");

        System.out.print("Monto: ");
        double monto1 = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Descripción: ");
        String descripcion1 = scanner.nextLine();

        System.out.print("RFC (puede dejarlo vacío si no tiene): ");
        String rfc1 = scanner.nextLine();
        rfc1 = rfc1.isEmpty() ? null : rfc1; // Si no se ingresa RFC, se usa null

        Factura facturaConRfc = new Factura(monto1, descripcion1, rfc1);

        // Pedir los datos para la segunda factura (sin RFC)
        System.out.println("\nIngrese los datos para la factura 2:");

        System.out.print("Monto: ");
        double monto2 = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Descripción: ");
        String descripcion2 = scanner.nextLine();

        System.out.print("RFC (puede dejarlo vacío si no tiene): ");
        String rfc2 = scanner.nextLine();
        rfc2 = rfc2.isEmpty() ? null : rfc2; // Si no se ingresa RFC, se usa null

        Factura facturaSinRfc = new Factura(monto2, descripcion2, rfc2);

        // Imprimir los resúmenes de ambas facturas
        System.out.println("\n" + facturaConRfc.getResumen());
        System.out.println(facturaSinRfc.getResumen());

        scanner.close();
    }
}
