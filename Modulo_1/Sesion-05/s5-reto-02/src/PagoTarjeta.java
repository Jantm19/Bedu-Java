/**
 * Clase que representa el pago con tarjeta.
 * Implementa la interfaz Autenticable y la clase abstracta MetodoPago.
 * La autenticación valida si hay fondos suficientes.
 */
public class PagoTarjeta extends MetodoPago implements Autenticable {

    public PagoTarjeta(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        // Simula la validación de fondos suficientes
        boolean fondosSuficientes = monto <= 500;  // Ejemplo simple
        if (fondosSuficientes) {
            System.out.println("✅ Autenticación exitosa.");
        } else {
            System.out.println("❌ Fallo de autenticación. Fondos insuficientes.");
        }
        return fondosSuficientes;
    }

    @Override
    public void procesarPago() {
        // Lógica para procesar el pago con tarjeta
        System.out.println("💳 Procesando pago con tarjeta por $" + monto);
    }
}
