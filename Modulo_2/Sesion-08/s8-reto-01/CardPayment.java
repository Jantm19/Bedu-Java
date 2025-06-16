/**
 * Implementación del pago con tarjeta.
 */
public class CardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("💳 Procesando pago con tarjeta por $" + String.format("%,.2f", amount));
    }
}
