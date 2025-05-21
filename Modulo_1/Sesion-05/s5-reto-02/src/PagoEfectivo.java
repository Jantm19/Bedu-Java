/**
 * Clase que representa el pago en efectivo.
 * Implementa la interfaz Autenticable y la clase abstracta MetodoPago.
 * La autenticación siempre es exitosa (no requiere validación).
 */
public class PagoEfectivo extends MetodoPago implements Autenticable {

    public PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        // Autenticación siempre exitosa
        System.out.println("✅ Autenticación exitosa.");
        return true;
    }

    @Override
    public void procesarPago() {
        // Lógica para procesar el pago en efectivo
        System.out.println("💵 Procesando pago en efectivo por $" + monto);
    }
}
