/**
 * Clase que representa a un operador que maneja la unidad de emergencia.
 * Contiene un atributo nombre y un método para reportarse.
 */
public class Operador {
    private String nombre;

    public Operador(String nombre) {
        this.nombre = nombre;
    }

    public void reportarse() {
        System.out.println("👷 Operador " + nombre + " reportándose.");
    }
}
