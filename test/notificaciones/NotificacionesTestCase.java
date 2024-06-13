package notificaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificacionesTestCase {

	private NotificacionFinEstacionamiento notificacionFin;
	private NotificacionCargaCredito notificacionCargaCredito; 
	
	
	@BeforeEach
	void setUp() throws Exception {
		notificacionFin = new NotificacionFinEstacionamiento("123", LocalTime.of(10, 10), 100.0);
		notificacionCargaCredito = new NotificacionCargaCredito(50.0);
	}
	
	@Test
	void testNotificacionFin() {
		assertEquals(notificacionFin.getCosto(), 100.0);
	}
	
	@Test
	void testNotificacionCargaCredito() {
		assertEquals(notificacionCargaCredito.getCredito(), 50.0);
	}

}
