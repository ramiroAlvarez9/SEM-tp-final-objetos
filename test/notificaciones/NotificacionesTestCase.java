package notificaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificacionesTestCase {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private NotificacionFinEstacionamiento notificacionFin;
	private NotificacionCargaCredito notificacionCargaCredito;

	@BeforeEach
	void setUp() throws Exception {
		notificacionFin = new NotificacionFinEstacionamiento("123", LocalTime.of(10, 10), 100.0);
		notificacionCargaCredito = new NotificacionCargaCredito(50.0);
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(originalOut);
	}

	@Test
	void testNotificacionFin() {
		assertEquals(notificacionFin.getCosto(), 100.0);
	}

	@Test
	void testNotificacionCargaCredito() {
		assertEquals(notificacionCargaCredito.getCredito(), 50.0);
	}

	@Test
	public void testInformar() {
		Double credito = 100.0;
		NotificacionCargaCredito notificacion = new NotificacionCargaCredito(credito);

		notificacion.informar();

		String expectedOutput = String.format("Tu crédito es %s %n", credito);
		assertEquals(expectedOutput, outputStreamCaptor.toString());
	}

}
