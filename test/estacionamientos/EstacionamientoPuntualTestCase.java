package estacionamientos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import notificaciones.Notificador;
import sistema.SEM;

class EstacionamientoPuntualTestCase {

	private EstacionamientoPuntual estacionamientoPuntual;
	private Notificador notificador;
	private SEM sem;
	
	@BeforeEach
	void setUp() throws Exception {
	
		sem = mock(SEM.class);
		notificador = mock(Notificador.class);
		estacionamientoPuntual = new EstacionamientoPuntual(notificador,"123", 1);
	}
	
	@Test
	void testInicioEstacionamiento() {
				
		assertEquals(estacionamientoPuntual.getInicio().getHour(), LocalTime.now().getHour());
		assertEquals(estacionamientoPuntual.getInicio().getMinute(), LocalTime.now().getMinute());
	
		assertTrue(estacionamientoPuntual.esVigente());
		
		assertEquals(estacionamientoPuntual.getFin().getHour(), LocalTime.now().plusHours(1).getHour());
		
		assertEquals( 40.0, estacionamientoPuntual.costo() );
	}
	
	@Test
	void testFinEstacionamiento() {
		
		estacionamientoPuntual.finalizar(sem, notificador);
		
		assertFalse(estacionamientoPuntual.esVigente());
		
	}

}
