/**
 * Este programa simula una escena narrativa en un videojuego.
 * Se utilizan interfaces para separar responsabilidades:
 * transición de historia, gestión de diálogos y lógica de decisión.
 * La clase principal recibe las dependencias mediante inyección.
 */

public class MainNarrativa {
    public static void main(String[] args) {
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria();

        boolean eleccion = decision.tomarDecision();
        String escena = transicion.transicionar(eleccion);
        dialogo.mostrarDialogo(escena);
    }
}
