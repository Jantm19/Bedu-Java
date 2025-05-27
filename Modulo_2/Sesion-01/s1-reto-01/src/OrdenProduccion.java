/**
 * Clase abstracta base para todas las órdenes de producción.
 * Contiene los atributos comunes: código y cantidad.
 * Define un método abstracto mostrarResumen() que cada subclase debe implementar.
 */
public abstract class OrdenProduccion {
    protected String codigo;
    protected int cantidad;

    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public abstract void mostrarResumen();
}
