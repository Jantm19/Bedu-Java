/**
 * Implementa una transición básica entre escenas según una decisión binaria.
 */

public class TransicionSimple implements TransicionHistoria {
    public String transicionar(boolean decision) {
        if (decision) {
            return "Has elegido ayudar al anciano. La historia continúa en el bosque.";
        } else {
            return "Has ignorado al anciano. La historia toma un rumbo oscuro en la ciudad.";
        }
    }
}
