/**
 * Este programa solicita los datos de un contribuyente para una declaración
 * de impuestos y los datos de una cuenta fiscal, validando si el RFC de la
 * declaración coincide con el RFC de la cuenta fiscal registrada.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el RFC del contribuyente: ");
        String rfcContribuyente = scanner.nextLine();

        System.out.print("Ingrese el monto declarado: ");
        double montoDeclarado = scanner.nextDouble();

        scanner.nextLine(); // Limpiar el buffer

        DeclaracionImpuestos declaracion = new DeclaracionImpuestos(rfcContribuyente, montoDeclarado);

        System.out.print("Ingrese el RFC de la cuenta fiscal: ");
        String rfcCuentaFiscal = scanner.nextLine();

        System.out.print("Ingrese el saldo disponible en la cuenta fiscal: ");
        double saldoDisponible = scanner.nextDouble();

        CuentaFiscal cuenta = new CuentaFiscal(rfcCuentaFiscal, saldoDisponible);

        System.out.println("\n📄 Declaración enviada por RFC: " + declaracion.rfcContribuyente() + " por $" + declaracion.montoDeclarado());
        System.out.println("🏦 Cuenta fiscal registrada con RFC: " + cuenta.getRfc() + ", saldo disponible: $" + cuenta.getSaldoDisponible());

        boolean rfcValido = cuenta.validarRFC(declaracion);
        System.out.println("✅ ¿RFC válido para esta cuenta?: " + rfcValido);

        scanner.close();
    }
}
