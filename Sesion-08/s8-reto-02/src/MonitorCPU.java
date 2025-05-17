/**
 * Programa que solicita 5 registros únicos de consumo de CPU (0-100) por sesión.
 * Valida entrada numérica, sin duplicados, lanza excepción si el consumo es crítico.
 * Al finalizar, muestra la lista y ofrece un menú para repetir el proceso completo.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MonitorCPU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            boolean repetir = true;

            while (repetir) {
                Set<Integer> consumos = new HashSet<>();
                int contador = 1;

                try {
                    while (contador <= 5) {
                        System.out.println("Ingrese el consumo de CPU del servidor " + contador + " (0-100):");
                        String entrada = scanner.nextLine();
                        int consumo;

                        try {
                            consumo = Integer.parseInt(entrada);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: El valor ingresado no es numérico.");
                            continue;
                        }

                        if (consumo < 0 || consumo > 100) {
                            System.out.println("Error: El valor debe estar entre 0 y 100.");
                            continue;
                        }

                        if (consumos.contains(consumo)) {
                            System.out.println("Error: Valor duplicado detectado.");
                            continue;
                        }

                        if (consumo > 95) {
                            throw new ConsumoCriticoException("Consumo crítico detectado: " + consumo + "%");
                        }

                        consumos.add(consumo);
                        contador++;
                    }

                    System.out.println("Registro completo. Lista de consumos registrados:");
                    for (int valor : consumos) {
                        System.out.println(valor + "%");
                    }

                } catch (ConsumoCriticoException e) {
                    System.out.println("Alerta: " + e.getMessage());
                }

                System.out.println("¿Desea registrar otra sesión? (s/n):");
                String opcion = scanner.nextLine();
                repetir = opcion.equalsIgnoreCase("s");
            }
        } finally {
            scanner.close();
            System.out.println("Finalizando monitoreo.");
        }
    }
}
