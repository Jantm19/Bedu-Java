/**
 * Clase que representa una factura con un folio, cliente y total.
 * Incluye métodos para representar la factura como cadena, comparar facturas
 * por el folio y generar un código hash basado en el folio.
 */
public class Factura {
    private String folio;
    private String cliente;
    private double total;

    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    @Override
    public String toString() {
        return "🧾 Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Factura other = (Factura) obj;
        return folio != null && folio.equals(other.folio);
    }

    @Override
    public int hashCode() {
        return folio != null ? folio.hashCode() : 0;
    }
}
