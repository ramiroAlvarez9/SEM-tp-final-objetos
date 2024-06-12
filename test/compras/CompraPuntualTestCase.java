package compras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.PuntoDeVenta;

class CompraPuntualTestCase {

	private CompraHora compraPuntual0;
	private CompraHora compraPuntual1;
	
	private PuntoDeVenta puntoDeVenta;
	
	@BeforeEach
	void setUp() throws Exception {
		
		puntoDeVenta = mock(PuntoDeVenta.class);
		
		compraPuntual0 = new CompraHora(LocalDate.now(), LocalTime.now(), 3, puntoDeVenta);
		compraPuntual1 = new CompraHora(LocalDate.now(), LocalTime.now(), 2, puntoDeVenta);
	}

	@Test
	void testNuevaCompraHora() {
		
		assertEquals(compraPuntual0.getFechaCompra(), LocalDate.now());
		assertEquals(compraPuntual0.getHora().getHour(), LocalTime.now().getHour());
		
		assertEquals(compraPuntual0.getPuntoDeVenta(), puntoDeVenta);
		assertEquals(compraPuntual0.getCantHoras(), 3);
		assertEquals(compraPuntual0.getNumControl(),0);
		
		assertEquals(compraPuntual1.getNumControl(),1);
	}
	
}
