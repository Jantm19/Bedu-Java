/**
 * Subclase de UnidadEmergencia que representa una patrulla policial.
 * Usa composición para incluir GPS, sirena y operador.
 * Implementa un método iniciarOperacion() que ejecuta todos los componentes y su respuesta personalizada.
 */
public class Patrulla extends UnidadEmergencia {
    private SistemaGPS gps;
    private Sirena sirena;
    private Operador operador;

    public Patrulla(String nombre, String nombreOperador) {
        super(nombre);
        this.gps = new SistemaGPS();
        this.sirena = new Sirena();
        this.operador = new Operador(nombreOperador);
    }

    public void iniciarOperacion() {
        activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder();
    }

    @Override
    public void responder() {
        System.out.println("🚓 Patrulla atendiendo situación de seguridad ciudadana.");
    }
}
