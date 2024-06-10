package usuarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistema.SEM;
import estacionamientos.EstacionamientoApp;



class InspectorTest {

	private Inspector inspector;
	private SEM sem;
	private EstacionamientoApp estacionamiento;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		estacionamiento = mock(EstacionamientoApp.class);
		sem = mock(SEM.class);
		inspector = new Inspector(sem);
		
	}

	@Test
	void testEstacionamientoConPatente_EstaVigente() {
		
		
		boolean respuesta = inspector.consultaEstacionamientoVigente("123");
	}
	@Test
	void testPatenteRecibioInfraccion() {

	
	}

}
