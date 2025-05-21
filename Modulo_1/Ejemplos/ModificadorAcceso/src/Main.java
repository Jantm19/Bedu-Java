//Los modificadores de acceso determinan la visibilidad de atributos y métodos.
//public → puedes entrar desde cualquier otra casa del vecindario.
//private → solo tú puedes entrar a tu habitación.
//protected → tú y tu familia (subclases) pueden entrar, si viven en la misma casa o son de la familia.
//(sin modificador) → solo los que viven en la misma casa (mismo paquete) pueden entrar.
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Sofía", 28);
        System.out.println(p1.nombre);         // OK (es pública)

        // System.out.println(p1.edad);        // ❌ Error (edad es privada)

        System.out.println(p1.getEdad());      // ✅ Correcto, usando getter
    }
}
//Usar private + getters/setters es una forma de encapsular:
//🔐 Ocultas los detalles internos y los expones solo si es necesario, de forma controlada.