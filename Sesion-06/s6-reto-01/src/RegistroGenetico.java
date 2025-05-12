/**
 * Programa que registra el orden de llegada de muestras genéticas,
 * identifica especies únicas y asocia cada muestra con un investigador responsable.
 * Utiliza ArrayList, HashSet y HashMap para el manejo de datos.
 * Incluye un menú para realizar múltiples búsquedas por ID de muestra.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class RegistroGenetico {

    public static void main(String[] args) {
        ArrayList<String> listaMuestras = new ArrayList<>();
        listaMuestras.add("Homo sapiens");
        listaMuestras.add("Mus musculus");
        listaMuestras.add("Arabidopsis thaliana");
        listaMuestras.add("Homo sapiens");

        HashSet<String> especiesUnicas = new HashSet<>(listaMuestras);

        HashMap<String, String> muestraInvestigador = new HashMap<>();
        muestraInvestigador.put("M-001", "Dra. López");
        muestraInvestigador.put("M-002", "Dr. Hernández");
        muestraInvestigador.put("M-003", "Dra. Gómez");
        muestraInvestigador.put("M-004", "Dr. Pérez");

        System.out.println("📥 Lista completa y ordenada de muestras:");
        for (String especie : listaMuestras) {
            System.out.println("- " + especie);
        }

        System.out.println("\n🧬 Especies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        System.out.println("\n🧑‍🔬 Relación de ID de muestra → Investigador:");
        for (String id : muestraInvestigador.keySet()) {
            System.out.println(id + " → " + muestraInvestigador.get(id));
        }

        Scanner scanner = new Scanner(System.in);
        int opcion = 1;

        while (opcion == 1) {
            System.out.print("\n🔍 Ingrese un ID de muestra para buscar: ");
            String idBusqueda = scanner.nextLine();

            if (muestraInvestigador.containsKey(idBusqueda)) {
                System.out.println("Resultado: " + idBusqueda + " → " + muestraInvestigador.get(idBusqueda));
            } else {
                System.out.println("ID de muestra no encontrado.");
            }

            System.out.print("\n¿Desea buscar otro ID? (1 = Sí / 2 = No): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 2;
            }
        }

        System.out.println("\nPrograma finalizado.");
        scanner.close();
    }
}
