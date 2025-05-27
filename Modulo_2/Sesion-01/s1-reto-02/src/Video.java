/**
 * Representa un material tipo Video con duración en minutos.
 */
public class Video extends MaterialCurso {
    private int duracion;

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("🎥 Video - Título: " + titulo + ", Autor: " + autor + ", Duración: " + duracion + " min");
    }
}
