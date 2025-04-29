public class Persona {
    public String nombre;        // Se puede acceder desde cualquier parte
    private int edad;            // Solo accesible dentro de esta clase

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método público para acceder a la edad
    public int getEdad() {
        return edad;
    }

    // Método público para cambiar la edad
    public void setEdad(int nuevaEdad) {
        if (nuevaEdad > 0) {
            edad = nuevaEdad;
        }
    }
}
