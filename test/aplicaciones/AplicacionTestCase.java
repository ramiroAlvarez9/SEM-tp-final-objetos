package aplicaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estacionamientos.EstadoDeEstacionamiento;

import static org.mockito.Mockito.*;

import java.time.LocalTime;

import sistema.*;
import aplicaciones.modos.*;
import notificaciones.*;

class AplicacionTestCase {

	private Aplicacion app;
	private SEM sem;
	private Modo modo;
	private INotificacion notificacion;
	
	@BeforeEach
	void setUp() throws Exception {
		
		notificacion = mock(INotificacion.class);
		modo = mock(Modo.class);
		sem = mock(SEM.class);
		app = new Aplicacion(sem, "ABC153", "12345");
		
		app.iniciarEstacionamiento();
	}
	
	@Test
	void testInicioEstacionamiento() {
	
		when(sem.hayEstacionamientoVigente("ABC153")).thenReturn(true);
		
		assertEquals(app.getEstado(), EstadoDeEstacionamiento.Vigente);
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
		assertEquals(app.getEstado(), EstadoDeEstacionamiento.NoVigente);
		
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
	
	@Test
	void testUpdateDefault() {
		app.update(notificacion);
		
		verify(notificacion).informar();
	}
	
	@Test
	void testUpdateInicioEstacionamiento() {
		notificacion = mock(NotificacionInicioEstacionamiento.class);
		
		app.update(notificacion);
		verify(notificacion).informar();
	}
	
	@Test
	void testUpdateFinEstacionamiento() {
		notificacion = mock(NotificacionFinEstacionamiento.class);
		
		app.update(notificacion);
		verify(notificacion).informar();
	}
	
	
}
