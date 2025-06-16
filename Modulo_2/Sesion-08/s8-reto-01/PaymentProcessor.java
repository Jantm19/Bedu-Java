/**
 * Procesador de pagos desacoplado de implementaciones concretas.
 */
public class PaymentProcessor {
    public void process(PaymentMethod method, double amount) {
        method.pay(amount);
    }
}
