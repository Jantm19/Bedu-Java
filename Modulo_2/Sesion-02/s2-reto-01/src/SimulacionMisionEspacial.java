/**
 * Ejecuta todos los sistemas de la misión espacial solicitando al usuario datos personalizados y mostrando resultados concurrentes.
 */
import java.util.Scanner;
import java.util.concurrent.*;

public class SimulacionMisionEspacial {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Ingrese datos para todos los sistemas:");

        System.out.print("Tiempo estimado de cálculo en milisegundos para navegación (ej: 1000): ");
        int tNav = Integer.parseInt(scanner.nextLine());

        System.out.print("Nivel de oxígeno en porcentaje para soporte vital (ej: 98): ");
        int oxi = Integer.parseInt(scanner.nextLine());

        System.out.print("Temperatura interna en °C para control térmico (ej: 22): ");
        int temp = Integer.parseInt(scanner.nextLine());

        System.out.print("Duración de conexión en milisegundos para comunicaciones (ej: 700): ");
        int dur = Integer.parseInt(scanner.nextLine());

        Future<String> commAll = executor.submit(new SistemaComunicaciones(dur));
        Future<String> suppAll = executor.submit(new SistemaSoporteVital(oxi));
        Future<String> termAll = executor.submit(new SistemaControlTermico(temp));
        Future<String> navAll = executor.submit(new SistemaNavegacion(tNav));

        System.out.println("\nSimulación de misión espacial iniciada...");
        System.out.println(commAll.get());
        System.out.println(suppAll.get());
        System.out.println(termAll.get());
        System.out.println(navAll.get());
        System.out.println("Todos los sistemas reportan estado operativo.");

        executor.shutdown();
        System.out.println("Simulación finalizada.");
    }
}
