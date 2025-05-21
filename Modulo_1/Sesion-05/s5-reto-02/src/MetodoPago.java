/**
 * Clase abstracta que representa un método de pago.
 * Contiene un atributo monto y un método concreto para mostrar el resumen del pago.
 * Además, define un método abstracto procesarPago() que debe ser implementado por las subclases.
 */
public abstract class MetodoPago {
    protected double monto;

    public MetodoPago(double monto) {
        this.monto = monto;
    }

    // Método abstracto que debe ser implementado por las subclases para procesar el pago
    public abstract void procesarPago();

    // Método concreto que muestra un resumen del pago
    public void mostrarResumen() {
        System.out.println("📄 Tipo: " + this.getClass().getSimpleName() + " - Monto: $" + monto);
    }
}
