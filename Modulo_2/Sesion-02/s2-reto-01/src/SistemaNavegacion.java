/**
 * Sistema de navegación que simula la corrección de trayectoria orbital con tiempo personalizado.
 */
import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    private int tiempo;

    public SistemaNavegacion(int tiempo) {
        this.tiempo = tiempo;
    }

    public String call() throws Exception {
        Thread.sleep(tiempo);
        return "Navegación: trayectoria corregida tras " + tiempo + " ms.";
    }
}
