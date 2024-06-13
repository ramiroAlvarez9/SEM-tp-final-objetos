package usuarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.*;
import estacionamientos.EstacionamientoApp;



class InspectorTest {

	private Inspector inspector;
	private SEM sem;
	private EstacionamientoApp estacionamiento;
	private ZonaDeEstacionamiento zona;
	
	@BeforeEach
	void setUp() throws Exception {
		
		estacionamiento = mock(EstacionamientoApp.class);
		sem = mock(SEM.class);
		inspector = new Inspector(sem);
		zona = mock(ZonaDeEstacionamiento.class);
	
	}

	@Test
	void testEstacionamientoConPatente_EstaVigente() {
		
		when(sem.estacionamientoConPatente("123")).thenReturn(estacionamiento);

		when(estacionamiento.esVigente()).thenReturn(true);
		
		boolean respuesta = inspector.consultaEstacionamientoVigente("123");
		
		assertTrue(respuesta);
	}
	
	@Test
	void testEstacionamientoConPatente_NoEstaVigente() {
		
		when(sem.estacionamientoConPatente("123")).thenReturn(estacionamiento);
		when(estacionamiento.esVigente()).thenReturn(false);
		
		boolean respuesta = inspector.consultaEstacionamientoVigente("123");
		
		assertFalse(respuesta);
	}
	
	@Test
	void testPatenteRecibioInfraccion() {
		
		inspector.cargarInfraccionPara("123", zona);
		Infraccion infraccion = inspector.getInfracciones().get(0);
		
		assertEquals(infraccion.getPatente(), "123");
		
		assertEquals(infraccion.getZona(), zona);
		
		assertEquals(infraccion.getHora().getHour(), LocalTime.now().getHour());
		
		assertEquals(infraccion.getFecha(), LocalDate.now());

		assertEquals(infraccion.getInspector(), inspector);
		
		assertEquals(inspector.getInfracciones().size(), 1);
		
	}
	
}
