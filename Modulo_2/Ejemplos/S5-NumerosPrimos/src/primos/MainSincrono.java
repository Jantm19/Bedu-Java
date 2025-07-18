/**
 * MainSincrono.java
 *
 * Este programa permite al usuario calcular una cantidad determinada de números primos
 * de manera secuencial (sincrónica). Funciona en un ciclo interactivo donde:
 *
 * 1. El usuario introduce cuántos números primos desea calcular.
 * 2. Se calculan los primeros n números primos utilizando la clase CalculadoraPrimos.
 * 3. Los números primos calculados se escriben en un archivo mediante la clase ManejoArchivos.
 * 4. Se pregunta al usuario si desea continuar o finalizar el programa.
 *
 * El programa se ejecuta hasta que el usuario indique que no desea continuar.
 * Está diseñado para ser simple y didáctico, adecuado para ejercicios de introducción
 * al manejo de listas, entrada/salida y procesamiento secuencial en Java.
 *
 * Requiere:
 * - CalculadoraPrimos.java: para calcular números primos.
 * - ManejoArchivos.java: para escribir los resultados en un archivo.
 */

package primos;
import java.util.List;
import java.util.Scanner;

public class MainSincrono {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n🤖 ¿Cuántos números primos quieres calcular?");

            int cantidad = sc.nextInt();
            sc.nextLine();

            System.out.println("\n⌛ Calculando " + cantidad + " primos...");

            try {
                // Paso 1. Calculamos los primeros n primos
                List<Long> primos = CalculadoraPrimos.calcularPrimerosPrimos(cantidad);

                // Paso 2. Escribir archivo
                ManejoArchivos.escribir(primos);
            } catch (Exception ex) {
                System.out.println("\n❌ Ocurrió un error inesperado");
            }

            System.out.println("\n✅ Cálculo de " + cantidad + " primos terminado");

            System.out.println("\n🤖 ¿Quieres seguir calculando? (Y/N)");

            String continuar = sc.nextLine();

            if (!continuar.toLowerCase().equals("y")) {
                break;
            }
        }

        sc.close();
        System.out.println("\nTerminando programa...");
    }
}