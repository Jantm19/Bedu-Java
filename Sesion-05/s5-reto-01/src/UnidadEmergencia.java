/**
 * Clase abstracta base que representa una unidad de emergencia con un nombre.
 * Define un método abstracto responder() y un método concreto activarUnidad().
 */
public abstract class UnidadEmergencia {
    protected String nombre;

    public UnidadEmergencia(String nombre) {
        this.nombre = nombre;
    }

    public void activarUnidad() {
        System.out.println("🚨 Activando unidad: " + nombre);
    }

    public abstract void responder();
}
