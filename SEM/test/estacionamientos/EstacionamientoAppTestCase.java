package estacionamientos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import notificaciones.*;

class EstacionamientoAppTestCase {

	private EstacionamientoApp estacionamientoApp;
	private Notificador notificador;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		notificador = mock(Notificador.class);
		estacionamientoApp = new EstacionamientoApp(notificador, "123","456");  // patrente = 123, num = 456
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
