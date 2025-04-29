import java.util.Scanner;

/**
 * Este programa solicita los datos de dos facturas, las almacena en objetos
 * de la clase Factura y muestra su información. Además, compara si las facturas
 * son iguales utilizando el método equals().
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el folio de la primera factura: ");
        String folio1 = scanner.nextLine();

        System.out.print("Ingrese el nombre del cliente de la primera factura: ");
        String cliente1 = scanner.nextLine();

        System.out.print("Ingrese el total de la primera factura: ");
        double total1 = scanner.nextDouble();

        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Ingrese el folio de la segunda factura: ");
        String folio2 = scanner.nextLine();

        System.out.print("Ingrese el nombre del cliente de la segunda factura: ");
        String cliente2 = scanner.nextLine();

        System.out.print("Ingrese el total de la segunda factura: ");
        double total2 = scanner.nextDouble();

        Factura factura1 = new Factura(folio1, cliente1, total1);
        Factura factura2 = new Factura(folio2, cliente2, total2);

        System.out.println(factura1.toString());
        System.out.println(factura2.toString());

        System.out.println("¿Las facturas son iguales?: " + factura1.equals(factura2));

        scanner.close();
    }
}
