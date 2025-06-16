/**
 * Implementación del pago con PayPal.
 */
public class PayPalPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("💻 Procesando pago con PayPal por $" + String.format("%,.2f", amount));
    }
}
