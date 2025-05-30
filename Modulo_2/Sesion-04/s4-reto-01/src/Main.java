/**
 * Clase principal que solicita datos al usuario para simular
 * una solicitud de viaje en la app de movilidad y muestra el resultado asincrónico.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        MovilidadApp app = new MovilidadApp();

        System.out.print("Ingrese origen: ");
        String origen = scanner.nextLine();

        System.out.print("Ingrese destino: ");
        String destino = scanner.nextLine();

        System.out.print("Ingrese distancia en km (ejemplo 7.5): ");
        double distancia = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingrese factor de demanda (ejemplo 1.2): ");
        double demanda = Double.parseDouble(scanner.nextLine());

        app.procesarSolicitud(origen, destino, distancia, demanda);

        Thread.sleep(6000);
        scanner.close();
    }
}
