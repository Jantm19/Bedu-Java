/**
 * Clase utilitaria con métodos genéricos para trabajar con listas de órdenes.
 * - mostrarOrdenes(): muestra cualquier tipo de orden (usa ? extends).
 * - procesarPersonalizadas(): procesa órdenes personalizadas (usa ? super).
 */
import java.util.List;

public class GestorOrdenes {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).ajustarCosto(costoAdicional);
            }
        }
    }
}
