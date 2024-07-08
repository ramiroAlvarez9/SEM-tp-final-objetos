package notificaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalTime;


class NotificadorTestCase {

	private Notificador notificador;
	private Entidad entidad;
	
	@BeforeEach
	void setUp() throws Exception {
		entidad = mock(Entidad.class);
		notificador = new Notificador();
		
		notificador.suscribir(entidad);

	}

	@Test
	void testSuscripcionEntidad() {
		assertTrue(notificador.getEntidades().contains(entidad));
	}
	
	@Test
	void testDesuscripcionEntidad() {
		notificador.desuscribir(entidad);
		assertFalse(notificador.getEntidades().contains(entidad));
	}
	
	@Test
	void testAvisoNuevoEstacionamiento() {
		LocalTime hora = LocalTime.now();
		notificador.notificarInicioEstacionamiento("ABC123", hora);
		verify(entidad).inicioEstacionamiento("ABC123", hora);;
	}
	
	@Test
	void testAvisoFinEstacionamiento() {
		LocalTime hora = LocalTime.now();
		notificador.notificarFinEstacionamiento("ABC123", hora, 10);;
		verify(entidad).finEstacionamiento("ABC123", hora, 10);;
	}
	
	@Test
	void testAvisoCargaCredito() {
		notificador.notificarCredito(100);
		verify(entidad).cargaCredito(100);
	}
	
}
