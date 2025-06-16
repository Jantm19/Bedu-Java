/**
 * Implementación del pago por transferencia bancaria.
 */
public class BankTransferPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("🏦 Procesando pago con transferencia bancaria por $" + String.format("%,.2f", amount));
    }
}
