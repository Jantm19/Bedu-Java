/**
 * Representa un material tipo Ejercicio con indicador de revisión.
 */
public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    public void marcarRevisado() {
        this.revisado = true;
    }

    public boolean isRevisado() {
        return revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📝 Ejercicio - Título: " + titulo + ", Autor: " + autor + ", Revisado: " + revisado);
    }
}
