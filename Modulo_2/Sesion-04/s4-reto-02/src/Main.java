/**
 * Clase principal que ejecuta la simulación de la gestión asincrónica
 * para la autorización de aterrizajes en un aeropuerto internacional,
 * invocando los métodos de AeropuertoControl.
 */

public class Main {
    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        control.iniciarVerificacion();
    }
}
