// Clase que representa un vuelo con la opción de reservar y cancelar un asiento
public class Vuelo {
    private final String codigoVuelo;
    private String destino;
    private String horaSalida;
    private Pasajero asientoReservado;

    public Vuelo(String codigo, String destino, String horaSalida) {
        this.codigoVuelo = codigo;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.asientoReservado = null;
    }

    public boolean reservarAsiento(Pasajero p) {
        if (asientoReservado == null) {
            asientoReservado = p;
            return true;
        }
        return false;
    }

    public boolean reservarAsiento(String nombre, String pasaporte) {
        if (asientoReservado == null) {
            asientoReservado = new Pasajero(nombre, pasaporte);
            return true;
        }
        return false;
    }

    public void cancelarReserva() {
        asientoReservado = null;
    }

    public String obtenerItinerario() {
        String infoVuelo = "Vuelo: " + codigoVuelo + " | Destino: " + destino + " | Salida: " + horaSalida;
        if (asientoReservado != null) {
            infoVuelo += "\nPasajero: " + asientoReservado.getNombre() + " | Pasaporte: " + asientoReservado.getPasaporte();
        } else {
            infoVuelo += "\nNo hay asiento reservado.";
        }
        return infoVuelo;
    }
}
