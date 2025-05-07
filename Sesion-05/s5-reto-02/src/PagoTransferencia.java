/**
 * Clase que representa el pago mediante transferencia bancaria.
 * Implementa la interfaz Autenticable y la clase abstracta MetodoPago.
 * La autenticación simula una validación externa (bancaria).
 */
public class PagoTransferencia extends MetodoPago implements Autenticable {

    public PagoTransferencia(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        // Simula la validación bancaria externa
        boolean transferenciaValida = monto <= 1000;  // Ejemplo simple
        if (transferenciaValida) {
            System.out.println("✅ Autenticación exitosa.");
        } else {
            System.out.println("❌ Fallo de autenticación. Transferencia no válida.");
        }
        return transferenciaValida;
    }

    @Override
    public void procesarPago() {
        // Lógica para procesar el pago por transferencia
        System.out.println("🏦 Procesando pago por transferencia bancaria por $" + monto);
    }
}
