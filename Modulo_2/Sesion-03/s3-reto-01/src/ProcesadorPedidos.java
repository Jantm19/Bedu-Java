/**
 * Procesa pedidos ingresados por el usuario para confirmar entregas a domicilio usando Optional y Stream API.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProcesadorPedidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();

        System.out.print("¿Cuántos pedidos desea ingresar? ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Pedido #" + i);
            System.out.print("Nombre del cliente: ");
            String cliente = scanner.nextLine();

            System.out.print("Tipo de entrega (domicilio/local): ");
            String tipo = scanner.nextLine();

            System.out.print("Teléfono (Enter si no proporcionó): ");
            String telefono = scanner.nextLine();
            if (telefono.isBlank()) {
                telefono = null;
            }

            pedidos.add(new Pedido(cliente, tipo, telefono));
        }

        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream)
                .map(tel -> "Confirmación enviada al número: " + tel)
                .collect(Collectors.toList());

        mensajes.forEach(System.out::println);
    }
}
