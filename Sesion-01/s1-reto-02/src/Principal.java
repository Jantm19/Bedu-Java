public class Principal {
    public static void main(String[] args) {
        // Crear objetos de tipo Entrada
        Entrada entrada1 = new Entrada("Concierto de Morat", 800.00);
        Entrada entrada2 = new Entrada("Obra de Teatro", 450.0);

        // Llamar al método mostrarInformacion() para mostrar los datos
        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();
    }
}
