/**
 * Representa una orden de producción en masa (productos estándar).
 * Extiende de OrdenProduccion e implementa el método mostrarResumen().
 */
public class OrdenMasa extends OrdenProduccion {
    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🔧 OrdenMasa - Código: " + codigo + " - Cantidad: " + cantidad);
    }
}
