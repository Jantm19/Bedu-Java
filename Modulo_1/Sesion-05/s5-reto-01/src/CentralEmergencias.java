/**
 * Clase principal que simula el centro de control de emergencias.
 * Crea instancias de cada unidad de emergencia y lanza su operación.
 */
public class CentralEmergencias {
    public static void main(String[] args) {
        Ambulancia ambulancia = new Ambulancia("Ambulancia", "Juan");
        Patrulla patrulla = new Patrulla("Patrulla", "Laura");
        UnidadBomberos bomberos = new UnidadBomberos("UnidadBomberos", "Marco");

        ambulancia.iniciarOperacion();
        System.out.println();
        patrulla.iniciarOperacion();
        System.out.println();
        bomberos.iniciarOperacion();
    }
}
