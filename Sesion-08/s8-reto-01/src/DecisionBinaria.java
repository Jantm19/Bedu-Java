/**
 * Solicita al usuario que tome una decisión de tipo sí o no.
 */

import java.util.Scanner;

public class DecisionBinaria implements LogicaDecision {
    public boolean tomarDecision() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Quieres ayudar al anciano? (s/n): ");
        String entrada = scanner.nextLine();
        return entrada.equalsIgnoreCase("s");
    }
}
