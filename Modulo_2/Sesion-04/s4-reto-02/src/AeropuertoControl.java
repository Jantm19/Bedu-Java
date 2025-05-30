/**
 * Simula la gestión asincrónica y concurrente de las verificaciones necesarias
 * para autorizar aterrizajes en un aeropuerto internacional.
 * Utiliza CompletableFuture para realizar consultas en paralelo,
 * combinando sus resultados y manejando posibles errores.
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = probabilidad(0.8);
            System.out.println("🛣️ Pista disponible: " + resultado);
            return resultado;
        });
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = probabilidad(0.85);
            System.out.println("🌦️ Clima favorable: " + resultado);
            return resultado;
        });
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = probabilidad(0.9);
            System.out.println("🚦 Tráfico aéreo despejado: " + resultado);
            return resultado;
        });
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = probabilidad(0.95);
            System.out.println("👷‍♂️ Personal disponible: " + resultado);
            return resultado;
        });
    }

    public void iniciarVerificacion() {
        System.out.println("🛫 Verificando condiciones para aterrizaje...");

        CompletableFuture<Boolean> pista = verificarPista()
                .exceptionally(e -> {
                    System.out.println("Error en verificación de pista: " + e.getMessage());
                    return false;
                });

        CompletableFuture<Boolean> clima = verificarClima()
                .exceptionally(e -> {
                    System.out.println("Error en verificación de clima: " + e.getMessage());
                    return false;
                });

        CompletableFuture<Boolean> trafico = verificarTraficoAereo()
                .exceptionally(e -> {
                    System.out.println("Error en verificación de tráfico aéreo: " + e.getMessage());
                    return false;
                });

        CompletableFuture<Boolean> personal = verificarPersonalTierra()
                .exceptionally(e -> {
                    System.out.println("Error en verificación de personal: " + e.getMessage());
                    return false;
                });

        CompletableFuture<Void> todas = CompletableFuture.allOf(pista, clima, trafico, personal);

        todas.thenRun(() -> {
            try {
                boolean pistaOk = pista.get();
                boolean climaOk = clima.get();
                boolean traficoOk = trafico.get();
                boolean personalOk = personal.get();

                if (pistaOk && climaOk && traficoOk && personalOk) {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.out.println("\n🚫 Error al obtener resultados: " + e.getMessage());
            }
        }).join();
    }

    private void simularLatencia(int minSegundos, int maxSegundos) {
        try {
            int delay = ThreadLocalRandom.current().nextInt(minSegundos, maxSegundos + 1);
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean probabilidad(double probabilidad) {
        return ThreadLocalRandom.current().nextDouble() < probabilidad;
    }
}
