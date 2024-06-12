package sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import aplicaciones.*;
import compras.*;

import static org.mockito.Mockito.*;

class PuntoDeVentaTest {

	// Aplicacion(SEM sem, String patente, String numeroTel)

	String patente = "EWY-843";
	String numTel = "11 5129-2345";
	SEM sem;
	PuntoDeVenta puntoDeVenta;
	Aplicacion aplicacion;

	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SEM.class);
		puntoDeVenta = new PuntoDeVenta(sem);

	}
		
	
	@Test
	void testPuntoDeVentaAgregaCompraCorrectamenteCuandoCargaCredito() {
		
		//Prop: registra la compra dentro de su lista de compras (Compra por celular).
		
		puntoDeVenta.cargarCredito(numTel, 20.00);
		
		Compra compra = puntoDeVenta.getCompraPorNumeroDeTelefono(numTel); 
		
		assertEquals(numTel, compra.getNumeroTel());
		
	}
	@Test
	void testPuntoDeVentaRegistraCorrectamenteEstacionamientoPorCompraPuntual() {
		//Prop: registra la compra dentro de su lista de compras (compra puntual, en "efectivo").

		puntoDeVenta.registrarEstacionamiento(patente, 3);
		
		Compra compra = puntoDeVenta.getCompraPorPuntoDeVenta(puntoDeVenta);
		
		assertEquals(3, compra.getCantHoras());
		assertEquals(puntoDeVenta, compra.getPuntoDeVenta());
	}

}
