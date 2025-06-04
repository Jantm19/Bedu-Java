import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;

/**
 * Clase principal que simula un monitor de Unidad de Cuidados Intensivos (UCI).
 * Genera signos vitales para múltiples pacientes, filtra aquellos que son críticos
 * y emite alertas en la consola, gestionando la contrapresión para evitar desbordamientos.
 */
public class MonitorUCI {

    public static void main(String[] args) {
        Flux<SignoVital> paciente1 = generarSignosVitales(1);
        Flux<SignoVital> paciente2 = generarSignosVitales(2);
        Flux<SignoVital> paciente3 = generarSignosVitales(3);

        Flux.merge(paciente1, paciente2, paciente3)
            .filter(SignoVital::esCritico)
            .map(sv -> "🔴 Paciente " + sv.pacienteId + " alerta:\n" + sv.alerta())
            .onBackpressureDrop()
            .delayElements(Duration.ofSeconds(1))
            .subscribe(
                System.out::println,
                error -> System.err.println("Error en el flujo de alertas: " + error.getMessage())
            );

        try {
            Thread.sleep(10000);
            //Thread.sleep(60000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El monitor UCI fue interrumpido.");
        }
    }

    /**
     * Genera un flujo continuo de signos vitales simulados para un paciente dado.
     * Los signos vitales se emiten cada 300 milisegundos en un hilo paralelo.
     * @param idPaciente El ID del paciente para el cual se generan los signos vitales.
     * @return Un Flux de SignoVital.
     */
    private static Flux<SignoVital> generarSignosVitales(int idPaciente) {
        Random random = new Random();
        return Flux.interval(Duration.ofMillis(300))
            .map(tick -> {
                int fc = 40 + random.nextInt(100);
                int ps = 80 + random.nextInt(80);
                int pd = 50 + random.nextInt(50);
                int spo2 = 85 + random.nextInt(15);
                return new SignoVital(idPaciente, fc, ps, pd, spo2);
            })
            .subscribeOn(Schedulers.parallel());
    }
}