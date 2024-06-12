package compras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.PuntoDeVenta;

class CompraCelularTestCase {

	private CompraCelular compraCelular;
	private PuntoDeVenta puntoDeVenta;
	
	@BeforeEach
	void setUp() throws Exception {
		
		puntoDeVenta = mock(PuntoDeVenta.class);
		compraCelular = new CompraCelular(LocalDate.now(), LocalTime.now(),"123", 30.27, puntoDeVenta);
	}
	
	@Test
	void testNuevaCompraCelular() {
		assertEquals(compraCelular.getFechaCompra(), LocalDate.now());
		assertEquals(compraCelular.getHora().getHour(), LocalTime.now().getHour());
		
		assertEquals(compraCelular.getPuntoDeVenta(), puntoDeVenta);
		assertEquals(compraCelular.getNumControl(),2);
		
		assertEquals(compraCelular.getMonto(),30.27);
		assertEquals(compraCelular.getNumeroTel(),"123");
	}

}
