/**
 * Representa una encuesta de satisfacción realizada por un paciente en la clínica.
 */
import java.util.Optional;

public class Encuesta {
    private String paciente;
    private String comentario;
    private int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}
