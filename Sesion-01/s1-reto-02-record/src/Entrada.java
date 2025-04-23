public record Entrada(String nombreEvento, double precioEntrada) {
    // El método toString() es generado automáticamente por el record
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombreEvento() + " | Precio: $" + precioEntrada());
    }
}
