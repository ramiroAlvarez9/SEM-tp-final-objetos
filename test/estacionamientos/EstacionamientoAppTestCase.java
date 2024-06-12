package estacionamientos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import notificaciones.*;
import aplicaciones.*;
import sistema.SEM;
import java.time.*;

class EstacionamientoAppTestCase {

	private EstacionamientoApp estacionamientoApp;
	private Notificador notificador;
	private Aplicacion app;
	private SEM sem;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		notificador = mock(Notificador.class);
		app = mock(Aplicacion.class);
		sem = mock(SEM.class);
	}
	
	@Test
	void testInicioEstacionamiento() {
		when(app.getHoraMaximaDeEstacionamiento()).thenReturn(LocalTime.of(8, 20, 45));
		when(app.getNumeroTel()).thenReturn("123");
		when(app.getPatente()).thenReturn("456");
		
		estacionamientoApp = new EstacionamientoApp(notificador, app);
		
		assertEquals(estacionamientoApp.getNumeroTel(),"123");
		assertEquals(estacionamientoApp.getPatente(),"456");
		assertEquals(estacionamientoApp.getFin(),LocalTime.of(8, 20, 45));
		assertTrue(estacionamientoApp.esVigente());
	}
	
	@Test
	void testFinEstacionamiento() {
		estacionamientoApp = new EstacionamientoApp(notificador, app);
		estacionamientoApp.finalizar(sem, notificador);
		
		assertFalse(estacionamientoApp.esVigente());
	}

}
