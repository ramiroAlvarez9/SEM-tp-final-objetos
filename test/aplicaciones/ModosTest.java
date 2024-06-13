package aplicaciones;

import aplicaciones.modos.ModoAutomatico;
import org.junit.jupiter.api.Test;
import sistema.SEM;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

public class ModosTest {

	SEM sem;
	String patente;
	String numTel;
	Aplicacion app;

	@BeforeEach
	void setUp() throws Exception {

		sem = new SEM();
		patente = "EWY-843";
		numTel = "11 5129-2345";
		app = new Aplicacion(sem, patente, numTel);

	}

	@Test
	public void testInicioEstacionamientoEnModoManual() {

		// estoy en modo manual (por default)
		app.iniciarEstacionamiento();

		assertTrue(sem.hayEstacionamientoVigente(patente));

	}
	
	@Test
	public void seFinalizaEstacionamientoEnModoManual() {
		
		app.iniciarEstacionamiento();
		app.finalizarEstacionamiento();

		assertTrue(sem.hayEstacionamientoVigente(patente));


	}

	@Test
	public void noHayEstacionamientoEnModoAutomaticoCuandoSeRecibeAppDriving() {

		app.setModo(new ModoAutomatico());
		app.driving();
		app.driving();
		app.driving();
		app.driving();
		app.driving();
		app.driving();
		assertFalse(sem.hayEstacionamientoVigente(patente));


	}
	@Test
	public void seActivaElEstacionamientoAutomaticamenteCuandoSeRecibeWalkingYNoHayEstacionamientoVigente() {
		
		app.setModo(new ModoAutomatico());
		
		app.walking();
		app.walking();
		app.walking();
		app.walking();
		app.walking();
		app.walking();
		app.walking();
		app.walking();
		
		assertTrue(sem.hayEstacionamientoVigente(patente));


	}
	
	

	 	  
	 

}
