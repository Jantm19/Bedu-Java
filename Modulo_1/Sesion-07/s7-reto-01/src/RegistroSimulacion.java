/**
 * Programa: RegistroSimulacion
 * Flujo general:
 * 1. Se define una ruta a un archivo llamado parametros.txt dentro de la carpeta config/.
 * 2. Se crea la carpeta config/ si no existe.
 * 3. Se escriben en el archivo tres parámetros de simulación:
 *    - Tiempo de ciclo
 *    - Velocidad de línea
 *    - Número de estaciones
 * 4. Se valida si el archivo fue creado correctamente.
 * 5. Se lee el contenido del archivo y se muestra en consola.
 */

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class RegistroSimulacion {

    public static void main(String[] args) {
        Path rutaArchivo = Paths.get("config/parametros.txt");
        guardarParametros(rutaArchivo);
        if (Files.exists(rutaArchivo)) {
            leerParametros(rutaArchivo);
        }
    }

    public static void guardarParametros(Path ruta) {
        try {
            Files.createDirectories(ruta.getParent());
            String contenido = "Tiempo de ciclo: 55.8 segundos\nVelocidad de línea: 1.2 m/s\nNúmero de estaciones: 8";
            Files.write(ruta, contenido.getBytes());
        } catch (IOException e) {
        }
    }

    public static void leerParametros(Path ruta) {
        try {
            String contenido = Files.readString(ruta);
            System.out.println(contenido);
        } catch (IOException e) {
        }
    }
}
