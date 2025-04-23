import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Crear el Scanner
        Scanner scanner = new Scanner(System.in);

        // Crear un objeto de tipo Paciente
        Paciente paciente = new Paciente();

        // Solicitar los datos al usuario
        System.out.print("Ingrese el nombre del paciente: ");
        paciente.nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del paciente: ");
        paciente.edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el número de expediente: ");
        paciente.numeroExpediente = scanner.nextLine();

        // Mostrar la información del paciente
        paciente.mostrarInformacion();

        // Cerrar el Scanner
        scanner.close();
    }
}
