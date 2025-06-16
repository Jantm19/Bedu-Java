/**
 * Interfaz que define la verificación de disponibilidad de mesas.
 */
package service;
 public interface DisponibilidadService {
    boolean hayDisponibilidad(String fecha, int personas);
}
