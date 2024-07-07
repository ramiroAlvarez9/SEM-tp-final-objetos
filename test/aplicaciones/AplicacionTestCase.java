package aplicaciones;

import static org.junit.jupiter.api.Assertions.*;

import aplicaciones.estados.EstadoNoVigente;
import aplicaciones.estados.EstadoVigente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.time.LocalTime;

import sistema.*;
import aplicaciones.modos.*;

class AplicacionTestCase {

	private Aplicacion app;
	private SEM sem;
	private Modo modo;
	
	@BeforeEach
	void setUp() throws Exception {
		modo = mock(Modo.class);
		sem = mock(SEM.class);
		app = new Aplicacion(sem, "ABC153", "12345");
		
		app.iniciarEstacionamiento();
	}
	
	@Test
	void testInicioEstacionamiento() {
	
		when(sem.hayEstacionamientoVigente("ABC153")).thenReturn(true);
		
		assertInstanceOf(EstadoVigente.class, app.getEstado());
		assertTrue(app.hayEstacionamientoVigente());
		
	}
	
	@Test
	void testConsultaDatos() {
	
		when(sem.getCredito("12345")).thenReturn(1000.0);
		
		assertEquals(app.getCredito(), 1000.0);
		assertEquals(app.getPatente(), "ABC153");
		assertEquals(app.getNumeroTel(), "12345");
	}
	
	@Test
	void testHoraMaximaDisponible() {
		
		when(sem.calcularTiempoFinDe("ABC153")).thenReturn(LocalTime.of(10, 10, 10));
		assertEquals(app.getHoraMaximaDeEstacionamiento(), LocalTime.of(10, 10, 10));
	}
	
	@Test
	void testFinEstacionamiiento() {
		
		when(sem.hayEstacionamientoVigente("ABC153")).thenReturn(false);
		
		app.finalizarEstacionamiento();
		assertFalse(app.hayEstacionamientoVigente());
		assertInstanceOf(EstadoNoVigente.class, app.getEstado());
	}
	
	@Test
	void testWalking() {
		app.setModo(modo);
		app.walking();
		
		verify(this.modo).walking(app);
	}
	
	@Test
	void testDriving() {
		app.setModo(modo);
		app.driving();
		
		verify(this.modo).driving(app);
	}
}
