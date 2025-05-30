/**
 * Simula el acceso concurrente de varios profesionales a un recurso médico usando nombres ingresados por el usuario.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecursoMedico recurso = new RecursoMedico("Sala de cirugía");

        System.out.print("¿Cuántos profesionales participarán en la simulación? ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        List<String> nombres = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa el nombre del profesional #" + (i + 1) + " (ej: Dra. Sánchez): ");
            nombres.add(scanner.nextLine());
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Iniciando acceso a la Sala de cirugía...");

        for (String nombre : nombres) {
            Runnable tarea = () -> recurso.usar(nombre);
            executor.execute(tarea);
        }

        executor.shutdown();
    }
}
