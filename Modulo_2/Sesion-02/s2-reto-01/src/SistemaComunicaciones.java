/**
 * Sistema de comunicaciones que simula el enlace con estación terrestre con duración personalizada.
 */
import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    private int duracion;

    public SistemaComunicaciones(int duracion) {
        this.duracion = duracion;
    }

    public String call() throws Exception {
        Thread.sleep(duracion);
        return "Comunicaciones: enlace establecido tras " + duracion + " ms.";
    }
}
