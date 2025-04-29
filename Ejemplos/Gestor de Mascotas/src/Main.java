public class Main {
    public static void main(String[] args) {
        Mascota m1 = new Mascota("Hachi", "Schnauzer", 10);
        m1.presentarse();

        m1.setEdad(-3); // Esto mostrará un mensaje de error pero no cambiará la edad
    }
}
