/**
 * Excepción personalizada lanzada cuando el consumo supera el umbral crítico.
 */

public class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}
