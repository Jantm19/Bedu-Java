/**
 * Simula una aplicación de movilidad que calcula asincrónicamente
 * la ruta óptima y estima la tarifa para un viaje, combinando ambos resultados.
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    public CompletableFuture<String> calcularRuta(String origen, String destino) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("🚦 Calculando ruta...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4));
                return "Ruta: " + origen + " -> " + destino;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
        });
    }

    public CompletableFuture<Double> estimarTarifa(double distanciaKm, double demandaFactor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3));
                if (distanciaKm < 0) {
                    throw new IllegalArgumentException("Distancia inválida");
                }
                return 30.0 + distanciaKm * 5.0 * demandaFactor;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
        });
    }

    public void procesarSolicitud(String origen, String destino, double distanciaKm, double demandaFactor) {
        CompletableFuture<String> rutaFuture = calcularRuta(origen, destino);
        CompletableFuture<Double> tarifaFuture = estimarTarifa(distanciaKm, demandaFactor);

        rutaFuture
                .thenCombine(tarifaFuture, (ruta, tarifa) ->
                        "✅ 🚗 " + ruta + " | Tarifa estimada: $" + String.format("%.2f", tarifa)
                )
                .exceptionally(error -> "❌ Error en el proceso: " + error.getMessage())
                .thenAccept(System.out::println);
    }
}
