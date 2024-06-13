package sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import estacionamientos.*;
import aplicaciones.*;

class SEMTest {

	SEM sem;
	Aplicacion app;
	Aplicacion app2;
	String numeroTel = "11 23962123";
	String patente = "IBI 123";

	@BeforeEach
	void setUp() throws Exception {

		sem = new SEM();
		app = mock(Aplicacion.class);
		app2 = mock(Aplicacion.class);
		when(app.getNumeroTel()).thenReturn(numeroTel);
		when(app.getPatente()).thenReturn(patente);
		when(app2.getCredito()).thenReturn(20.0);
		

	}

	@Test
	void test_UnSemRegistraCorrectamenteUnaApp() {

		// Se pide el numero de tel (index) al diccionario interno del sem de
		// aplicaciones con credito ( - creditos - )
		sem.registrarApp(app);
		assertTrue(sem.getApps().containsKey(numeroTel));

	}

	@Test
	void test_unSemAgregaCorrectamenteCreditoAUnaApp() {

		// Sem registra app y carga correctamente 20.0 de credito.
		sem.registrarApp(app);

		sem.cargarCredito(numeroTel, 20.0);

		assertTrue(sem.getApps().containsKey(numeroTel));

		assertEquals(20.0, sem.getApps().get(numeroTel));

	}

	@Test
	void test_unSemRestaCreditoCorrectamente() {

		// Sem registra app y resta correctamente 10.0 de credito.
		sem.registrarApp(app);

		sem.cargarCredito(numeroTel, 20.0);

		sem.restarCredito(numeroTel, 10.0);

		assertTrue(sem.getApps().containsKey(numeroTel));

		assertEquals(10.0, sem.getApps().get(numeroTel));

	}

	@Test
	void test_SEMcalculaTiempoDeFinDeAppSegunCredito() {
		
		// Siempre va a dar un horario distinto, por el hecho que lo calcula con la hora actual

		sem.registrarApp(app);

		sem.cargarCredito(numeroTel, 120.0);

		assertEquals(LocalTime.of(20, 0), sem.calcularTiempoFinDe(numeroTel));
	}

	@Test
	void test_SEMRegistraEstacionamientoPorCompraPuntual() {

		sem.registrarEstacionamientoDesdeCompraPuntual(patente, 3);

		Estacionamiento estacionamientoActual = sem.estacionamientoConPatente(patente);

		assertTrue(sem.getEstacionamientos().contains(estacionamientoActual));

	}

	@Test
	void test_SEMRegistraEstacionamientoPorApp() {

		sem.registrarEstacionamiento(app);

		Estacionamiento estacionamientoActual = sem.estacionamientoConPatente(patente);

		assertTrue(sem.getEstacionamientos().contains(estacionamientoActual));

	}

	@Test
	void test_SEMDetectaSiHayEstacionamientoVigente() {

		sem.registrarEstacionamiento(app);

		Estacionamiento estacionamientoActual = sem.estacionamientoConPatente(patente);

		assertTrue(sem.hayEstacionamientoVigente(patente));

	}

	@Test
	void test_SEMCalculaCantidadDeEstacionamientosVigentes() {
		
		sem.registrarEstacionamiento(app);
		sem.registrarEstacionamientoDesdeCompraPuntual("AAA 321", 3);
		int cantidadEstacionamientosVigentes = sem.estacionamientosVigentes().collect(Collectors.toList()).size();
		assertEquals(2, cantidadEstacionamientosVigentes);

	}
	
	@Test
	void test_SEMFinalizaTodosLosEstacionamientosVigentes() {


		sem.registrarEstacionamientoDesdeCompraPuntual("AAA 321", 3);
		sem.registrarEstacionamientoDesdeCompraPuntual("AAA 123", 4);
		sem.finalizarTodosLosEstacionamientos();
		

		
		assertEquals(0, sem.estacionamientosVigentes().collect(Collectors.toList()).size());

	}

}
