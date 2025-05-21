/**
 * Este programa solicita al usuario los datos para dos facturas (monto, descripción y RFC),
 * crea objetos de tipo Factura y muestra sus resúmenes.
 */

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos para la factura 1:");
        System.out.print("Monto: ");
        double monto1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion1 = scanner.nextLine();

        System.out.print("RFC (puede dejarlo vacío si no tiene): ");
        String rfc1 = scanner.nextLine();
        rfc1 = rfc1.isEmpty() ? null : rfc1;

        Factura facturaConRfc = new Factura(monto1, descripcion1, rfc1);

        System.out.println("\nIngrese los datos para la factura 2:");
        System.out.print("Monto: ");
        double monto2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion2 = scanner.nextLine();

        System.out.print("RFC (puede dejarlo vacío si no tiene): ");
        String rfc2 = scanner.nextLine();
        rfc2 = rfc2.isEmpty() ? null : rfc2;

        Factura facturaSinRfc = new Factura(monto2, descripcion2, rfc2);

        System.out.println("\n" + facturaConRfc.getResumen());
        System.out.println(facturaSinRfc.getResumen());

        scanner.close();
    }
}
