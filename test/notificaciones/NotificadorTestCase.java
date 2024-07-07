package notificaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import aplicaciones.Aplicacion;

class NotificadorTestCase {

	private Notificador notificador;
	private Entidad entidad;
	private Aplicacion app;
	private Aplicacion app2;
	
	@BeforeEach
	void setUp() throws Exception {
		entidad = mock(Entidad.class);
		app = mock(Aplicacion.class);
		app2 = mock(Aplicacion.class);
		notificador = new Notificador();

		notificador.suscribir(entidad);

	}

	/*
	test1:
		sem.crearEstacionamiento -> hace notificacion
		assert notificador.notificarInicioEstacionamiento()
		assert entidad uso inicioEstacionamiento(patente, horaInicio);

	test2:
		sem.cargarCredito -> hace notificacion
		assert notificador.notificarCargaCredito()
		assert entidad uso cargaCredito(nuevoCredito);

	test1:
		sem.crearEstacionamiento -> hace notificacion
		assert notificador.notificarFinEstacionamiento()
		assert entidad uso finEstacionamiento(patente, horaInicio, costo);

	 */
}
