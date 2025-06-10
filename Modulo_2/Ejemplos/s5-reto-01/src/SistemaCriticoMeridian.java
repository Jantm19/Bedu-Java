/**
 * Simula flujos reactivos no bloqueantes para monitorear eventos críticos en tiempo real
 * en cinco sistemas de la ciudad inteligente Meridian Prime.
 */
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple5;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SistemaCriticoMeridian {
    public static void main(String[] args) {
        Flux<String> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> (int) (Math.random() * 100))
                .filter(nivel -> nivel > 70)
                .map(nivel -> "🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar")
                .onBackpressureBuffer()
                .publishOn(Schedulers.parallel());

        Flux<String> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> (int) (Math.random() * 100))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)")
                .publishOn(Schedulers.parallel());

        List<String> prioridades = Arrays.asList("Baja", "Media", "Alta");
        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> prioridades.get((int) (Math.random() * prioridades.size())))
                .filter(p -> p.equals("Alta"))
                .map(p -> "🚑 Emergencia vial: Accidente con prioridad " + p)
                .publishOn(Schedulers.parallel());

        Flux<String> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> (int) (Math.random() * 11))
                .filter(min -> min > 5)
                .map(min -> "🚝 Tren maglev con retraso crítico: " + min + " minutos")
                .delayElements(Duration.ofMillis(300))
                .publishOn(Schedulers.parallel());

        List<String> estados = Arrays.asList("Verde", "Amarillo", "Rojo");
        AtomicInteger rojoConsecutivos = new AtomicInteger(0);
        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> estados.get((int) (Math.random() * estados.size())))
                .filter(estado -> {
                    if (estado.equals("Rojo")) {
                        return rojoConsecutivos.incrementAndGet() >= 3;
                    } else {
                        rojoConsecutivos.set(0);
                        return false;
                    }
                })
                .map(r -> "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte")
                .publishOn(Schedulers.parallel());

        Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
                .buffer(Duration.ofMillis(1000))
                .filter(lista -> lista.size() >= 3)
                .map(lista -> "🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime\n" + String.join("\n", lista))
                .subscribe(System.out::println);

        trafico.subscribe(System.out::println);
        contaminacion.subscribe(System.out::println);
        accidentes.subscribe(System.out::println);
        trenes.subscribe(System.out::println);
        semaforos.subscribe(System.out::println);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
