import java.util.Optional;

// Clase que representa una factura con monto, descripción y un RFC opcional
public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    // Constructor que recibe monto, descripción y RFC (opcional)
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc); // Si RFC es null, se usa Optional.empty()
    }

    // Método público para obtener el resumen de la factura
    public String getResumen() {
        // Si RFC está presente, se muestra, sino muestra "RFC: [No proporcionado]"
        String rfcInfo = rfc.isPresent() ? rfc.get() : "[No proporcionado]";
        return "📄 Factura generada:\nDescripción: " + descripcion + "\nMonto: $" + monto + "\nRFC: " + rfcInfo + "\n";
    }

    // Métodos getters para los atributos privados (si se necesitan en el futuro)
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
