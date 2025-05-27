/**
 * Clase principal con menú interactivo para gestionar órdenes desde consola.
 * Incluye limpieza de pantalla y pausas entre operaciones, con íconos.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();

        boolean salir = false;

        while (!salir) {
            limpiarPantalla();
            System.out.println("📋 Menú de Gestión de Órdenes:");
            System.out.println("1. Agregar orden de producción en masa");
            System.out.println("2. Agregar orden personalizada");
            System.out.println("3. Agregar orden prototipo");
            System.out.println("4. Mostrar todas las órdenes");
            System.out.println("5. Procesar órdenes personalizadas");
            System.out.println("6. Mostrar resumen total");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    System.out.print("Código: ");
                    String codMasa = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantMasa = scanner.nextInt();
                    scanner.nextLine();
                    ordenesMasa.add(new OrdenMasa(codMasa, cantMasa));
                    System.out.println("✅ Orden de masa agregada.");
                    pausar(scanner);
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.print("Código: ");
                    String codPers = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantPers = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Cliente: ");
                    String cliente = scanner.nextLine();
                    ordenesPersonalizadas.add(new OrdenPersonalizada(codPers, cantPers, cliente));
                    System.out.println("✅ Orden personalizada agregada.");
                    pausar(scanner);
                    break;

                case 3:
                    limpiarPantalla();
                    System.out.print("Código: ");
                    String codProt = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantProt = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Fase de desarrollo: ");
                    String fase = scanner.nextLine();
                    ordenesPrototipo.add(new OrdenPrototipo(codProt, cantProt, fase));
                    System.out.println("✅ Orden prototipo agregada.");
                    pausar(scanner);
                    break;

                case 4:
                    limpiarPantalla();
                    System.out.println("🔧 Producción en masa:");
                    GestorOrdenes.mostrarOrdenes(ordenesMasa);

                    System.out.println("\n🛠️ Órdenes personalizadas:");
                    GestorOrdenes.mostrarOrdenes(ordenesPersonalizadas);

                    System.out.println("\n🧪 Prototipos:");
                    GestorOrdenes.mostrarOrdenes(ordenesPrototipo);
                    pausar(scanner);
                    break;

                case 5:
                    limpiarPantalla();
                    System.out.print("Ingrese el costo adicional por orden personalizada: ");
                    int costo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("💰 Procesando órdenes personalizadas...");
                    GestorOrdenes.procesarPersonalizadas(new ArrayList<>(ordenesPersonalizadas), costo);
                    pausar(scanner);
                    break;

                case 6:
                    limpiarPantalla();
                    System.out.println("📊 Resumen total de órdenes:");
                    System.out.println("🔧 Producción en masa: " + ordenesMasa.size());
                    System.out.println("🛠️ Personalizadas: " + ordenesPersonalizadas.size());
                    System.out.println("🧪 Prototipos: " + ordenesPrototipo.size());
                    pausar(scanner);
                    break;

                case 7:
                    salir = true;
                    limpiarPantalla();
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    limpiarPantalla();
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
                    pausar(scanner);
            }
        }

        scanner.close();
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void pausar(Scanner scanner) {
        System.out.println("\nPresiona ENTER para continuar...");
        scanner.nextLine();
    }
}
