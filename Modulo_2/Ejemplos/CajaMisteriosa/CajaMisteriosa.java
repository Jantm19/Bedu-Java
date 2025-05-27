// Clase genérica CajaMisteriosa que puede almacenar un valor de cualquier tipo X
public class CajaMisteriosa <X> {

    // Variable privada que guarda el valor dentro de la caja
    private X valor;

    // Método para guardar un nuevo valor en la caja
    public void guardar(X nuevoValor) {
        this.valor = nuevoValor;
    }

    // Método para sacar (retornar) el valor guardado en la caja
    public X sacar() {
        return valor;
    }

    // Método que indica si la caja está vacía (es decir, si no tiene valor)
    public boolean estaVacia() {
        return valor == null;
    }
}
