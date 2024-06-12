package sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estacionamientos.EstacionamientoApp;
import usuarios.Inspector;

class ZonaDeEstacionamientoTestCase {

	private ZonaDeEstacionamiento zona;
	private Inspector inspector;
	private PuntoDeVenta puntoDeVenta;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		inspector = mock(Inspector.class);
		puntoDeVenta = mock(PuntoDeVenta.class);
		
		HashSet<Inspector> inspectores = new HashSet<>();
		HashSet<PuntoDeVenta> puntosDeVenta = new HashSet<>();
		inspectores.add(inspector);
		puntosDeVenta.add(puntoDeVenta);
		
		
		zona = new ZonaDeEstacionamiento(puntosDeVenta, inspectores);
	}
	
	@Test
	void testZona() {
		
		assertTrue(zona.getInspectores().contains(inspector));
		assertTrue(zona.getPuntoDeVentas().contains(puntoDeVenta));
	}

}
