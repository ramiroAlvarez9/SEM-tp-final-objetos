package notificaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import aplicaciones.Aplicacion;

class NotificadorTestCase {

	private Notificador notificador;
	private INotificado entidad;
	private Aplicacion app;
	private Aplicacion app2;
	private INotificacion notificacion;
	
	@BeforeEach
	void setUp() throws Exception {
		
		notificacion = mock(INotificacion.class);
		entidad = mock(INotificado.class);
		app = mock(Aplicacion.class);
		app2 = mock(Aplicacion.class);
		notificador = new Notificador();
	}
	
	@Test
	void testNotificarEntidades() {
		notificador.suscribir(entidad);
		notificador.notificar(notificacion);
		
		assertTrue(notificador.getEntidades().contains(entidad));
		verify(entidad).update(notificacion);
	}
	
	@Test
	void testNoRecibeNotificacionLaEntidad() {
		notificador.suscribir(entidad);
		notificador.desuscribir(entidad);
		notificador.notificar(notificacion);
		
		assertFalse(notificador.getEntidades().contains(entidad));
		verify(entidad, never()).update(notificacion);
	}
	
	@Test
	void testNotificarApps() {
		notificador.suscribir("123",app);
		notificador.suscribir("456",app2);
		notificador.notificar("123", notificacion);	
		
		verify(app).update(notificacion);
		verify(app2, never()).update(notificacion);	
	}
	
	@Test
	void testNoRecibeNotificacionLaApp() {
		notificador.suscribir("123",app);
		notificador.desuscribir("123",app);
		notificador.notificar("123", notificacion);	
	
		verify(app, never()).update(notificacion);	
	}
	

}
