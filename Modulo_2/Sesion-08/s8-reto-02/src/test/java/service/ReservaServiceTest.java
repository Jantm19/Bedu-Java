package service;
/**
 * Pruebas unitarias para la clase ReservaService, utilizando Mockito para simular la disponibilidad.
 */
/**
 * Pruebas unitarias para la clase ReservaService, utilizando Mockito para simular la disponibilidad.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservaServiceTest {

    private DisponibilidadService disponibilidadService;
    private ReservaService reservaService;

    @BeforeEach
    public void setup() {
        disponibilidadService = mock(DisponibilidadService.class);
        reservaService = new ReservaService(disponibilidadService);
    }

    @Test
    public void reservaConfirmadaCuandoHayDisponibilidad() {
        when(disponibilidadService.hayDisponibilidad("2025-05-01", 2)).thenReturn(true);

        boolean resultado = reservaService.realizarReserva("2025-05-01", 2);

        assertTrue(resultado);
        verify(disponibilidadService).hayDisponibilidad("2025-05-01", 2);
    }

    @Test
    public void reservaRechazadaCuandoNoHayDisponibilidad() {
        when(disponibilidadService.hayDisponibilidad("2025-05-02", 5)).thenReturn(false);

        boolean resultado = reservaService.realizarReserva("2025-05-02", 5);

        assertFalse(resultado);
        verify(disponibilidadService).hayDisponibilidad("2025-05-02", 5);
    }

    @Test
    public void reservaInvalidaPorExcesoDePersonas() {
        boolean resultado = reservaService.realizarReserva("2025-05-03", 15);

        assertFalse(resultado);
        verify(disponibilidadService, never()).hayDisponibilidad(anyString(), anyInt());
    }
}
