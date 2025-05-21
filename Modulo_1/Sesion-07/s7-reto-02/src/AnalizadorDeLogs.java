/**
 * Programa: Analizador De Logs
 * Flujo general:
 * 1. Abre el archivo errores.log utilizando BufferedReader y try-with-resources.
 * 2. Recorre línea por línea, contabilizando:
 *    - Total de líneas leídas
 *    - Cantidad de líneas que contienen "ERROR"
 *    - Cantidad de líneas que contienen "WARNING"
 * 3. Imprime un resumen con los conteos y el porcentaje de líneas con errores o advertencias.
 * 4. Si ocurre un error al abrir o procesar el archivo, se guarda el mensaje de error
 *    en un archivo llamado registro_fallos.txt.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AnalizadorDeLogs {

    public static void main(String[] args) {
        int totalLineas = 0;
        int errores = 0;
        int advertencias = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader("errores.log"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                if (linea.contains("ERROR")) {
                    errores++;
                }
                if (linea.contains("WARNING")) {
                    advertencias++;
                }
            }

            double porcentaje = 0;
            if (totalLineas > 0) {
                porcentaje = ((double)(errores + advertencias) / totalLineas) * 100;
            }

            System.out.println("Resumen del análisis de logs:");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + errores);
            System.out.println("Cantidad de advertencias: " + advertencias);
            System.out.printf("Porcentaje de líneas con errores y advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter("registro_fallos.txt"))) {
                escritor.write(e.getMessage());
            } catch (IOException ex) {
            }
        }
    }
}
