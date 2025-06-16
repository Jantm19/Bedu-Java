/**
 * Implementación del pago con criptomonedas.
 */
public class CryptoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("🪙 Procesando pago con criptomonedas por $" + String.format("%,.2f", amount));
    }
}
