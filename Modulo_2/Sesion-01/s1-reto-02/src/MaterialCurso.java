/**
 * Clase abstracta base para todos los materiales del curso.
 * Incluye título, autor y un método abstracto para mostrar detalles.
 */
public abstract class MaterialCurso {
    protected String titulo;
    protected String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract void mostrarDetalle();
}
