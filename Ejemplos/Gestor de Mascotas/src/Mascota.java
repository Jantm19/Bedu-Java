public class Mascota {
    private String nombre;
    private String raza;
    private int edad;

    // Constructor
    public Mascota(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        setEdad(edad); // usamos el setter para validar
    }

    // Getters - "Obtener" (leer un valor)
    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    // Setters -  "Establecer" (cambiar un valor)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa.");
        }
    }

    // Método para presentarse
    public void presentarse() {
        System.out.println("Hola, soy " + nombre + ", tengo " + edad + " años y soy de la raza " + raza + ".");
    }
}
