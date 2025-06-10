package sesion06.s6reto01.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * Clase entidad que representa un producto en el inventario.
 * Incluye validaciones de nombre, descripción y precio.
 */
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @Min(1)
    private double precio;

    public Producto() {}

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto[id=" + id + ", nombre='" + nombre + "', precio=" + String.format("%.2f", precio) + "]";
    }
}
