/**
 * Representa los signos vitales de un paciente, incluyendo la lógica
 * para determinar si son críticos y generar mensajes de alerta.
 * Los objetos de esta clase son inmutables.
 */
public class SignoVital {
    public final int pacienteId;
    public final int frecuenciaCardiaca;
    public final int presionSistolica;
    public final int presionDiastolica;
    public final int spo2;

    public SignoVital(int pacienteId, int fc, int ps, int pd, int spo2) {
        this.pacienteId = pacienteId;
        this.frecuenciaCardiaca = fc;
        this.presionSistolica = ps;
        this.presionDiastolica = pd;
        this.spo2 = spo2;
    }

    public boolean esCritico() {
        return frecuenciaCardiaca < 50 || frecuenciaCardiaca > 120
            || presionSistolica < 90 || presionDiastolica < 60
            || presionSistolica > 140 || presionDiastolica > 90
            || spo2 < 90;
    }

    public String alerta() {
        StringBuilder sb = new StringBuilder();

        if (frecuenciaCardiaca < 50) {
            sb.append("FC baja: ").append(frecuenciaCardiaca).append(" bpm; ");
        } else if (frecuenciaCardiaca > 120) {
            sb.append("FC alta: ").append(frecuenciaCardiaca).append(" bpm; ");
        }

        if (presionSistolica < 90 || presionDiastolica < 60) {
            sb.append("PA baja: ").append(presionSistolica).append("/").append(presionDiastolica).append(" mmHg; ");
        } else if (presionSistolica > 140 || presionDiastolica > 90) {
            sb.append("PA alta: ").append(presionSistolica).append("/").append(presionDiastolica).append(" mmHg; ");
        }

        if (spo2 < 90) {
            sb.append("SpO2 baja: ").append(spo2).append("%; ");
        }

        if (sb.length() > 0) {
            return sb.toString().trim();
        }
        return "Sin alerta crítica";
    }

    @Override
    public String toString() {
        return "SignoVital{" +
               "pacienteId=" + pacienteId +
               ", frecuenciaCardiaca=" + frecuenciaCardiaca +
               ", presionSistolica=" + presionSistolica +
               ", presionDiastolica=" + presionDiastolica +
               ", spo2=" + spo2 +
               '}';
    }
}