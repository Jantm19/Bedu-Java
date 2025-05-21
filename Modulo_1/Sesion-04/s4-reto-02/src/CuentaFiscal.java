import java.util.Objects;

/**
 * Clase que representa una cuenta fiscal con un RFC y saldo disponible.
 * Incluye métodos para obtener el RFC y el saldo, y para validar si el RFC
 * de la cuenta coincide con el RFC de una declaración de impuestos.
 */
public class CuentaFiscal {
    private final String rfc;
    private double saldoDisponible;

    public CuentaFiscal(String rfc, double saldoDisponible) {
        if (saldoDisponible < 0) {
            throw new IllegalArgumentException("El saldo disponible no puede ser negativo");
        }
        this.rfc = rfc;
        this.saldoDisponible = saldoDisponible;
    }

    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public boolean validarRFC(DeclaracionImpuestos d) {
        return Objects.equals(this.rfc, d.rfcContribuyente());
    }
}
