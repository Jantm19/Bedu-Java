/**
 * Clase que representa una factura con monto, descripción y un RFC opcional.
 */

import java.util.Optional;

public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc);
    }

    public String getResumen() {
        String rfcInfo = rfc.isPresent() ? rfc.get() : "[No proporcionado]";
        return "📄 Factura generada:\nDescripción: " + descripcion + "\nMonto: $" + monto + "\nRFC: " + rfcInfo + "\n";
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Optional<String> getRfc() {
        return rfc;
    }
}
