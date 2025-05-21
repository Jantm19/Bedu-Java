// Menú interactivo para reservar, consultar o cancelar una reserva de vuelo
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vuelo vuelo = null;

        Pasajero pasajero = null;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ DE RESERVAS ---");
            System.out.println("1. Reservar");
            System.out.println("2. Consultar Itinerario");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del pasajero: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el número de pasaporte: ");
                    String pasaporte = scanner.nextLine();

                    System.out.print("Ingrese el código del vuelo: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Ingrese el destino del vuelo: ");
                    String destino = scanner.nextLine();

                    System.out.print("Ingrese la hora de salida (formato 24h): ");
                    String hora = scanner.nextLine();

                    vuelo = new Vuelo(codigo, destino, hora);
                    pasajero = new Pasajero(nombre, pasaporte);

                    boolean reservado = vuelo.reservarAsiento(pasajero);
                    System.out.println(reservado ? "Reserva exitosa." : "Ya existe una reserva para este vuelo.");
                    break;

                case 2:
                    if (vuelo != null) {
                        System.out.println("\n" + vuelo.obtenerItinerario());
                    } else {
                        System.out.println("No hay vuelo registrado.");
                    }
                    break;

                case 3:
                    if (vuelo != null) {
                        vuelo.cancelarReserva();
                        System.out.println("Reserva cancelada.");
                    } else {
                        System.out.println("No hay vuelo para cancelar.");
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
