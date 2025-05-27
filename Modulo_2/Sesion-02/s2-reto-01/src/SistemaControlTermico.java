/**
 * Sistema de control térmico que simula la supervisión de temperatura con entrada personalizada.
 */
import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    private int temperatura;

    public SistemaControlTermico(int temperatura) {
        this.temperatura = temperatura;
    }

    public String call() throws Exception {
        Thread.sleep(900);
        return "Control térmico: temperatura estable en " + temperatura + "°C.";
    }
}
