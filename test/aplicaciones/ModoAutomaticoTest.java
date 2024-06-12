package aplicaciones;

import aplicaciones.modos.ModoAutomatico;
import org.junit.jupiter.api.Test;
import sistema.SEM;

import static org.junit.jupiter.api.Assertions.*;

public class ModoAutomaticoTest {
	
	
    @Test
    public void testModoAutomatico() {
        SEM sem = new SEM();
        String patente = "EWY-843";
        String numTel = "11 5129-2345";
        Aplicacion app = new Aplicacion(sem, patente, numTel);

        // estoy en modo manual (por default)
        app.iniciarEstacionamiento();
        assertTrue(sem.hayEstacionamientoVigente(patente));

        app.setModo(new ModoAutomatico());
        app.driving();

        assertFalse(sem.hayEstacionamientoVigente(patente));

        app.driving();
        app.driving();
        app.driving();
        app.driving();
        app.driving();
        assertFalse(sem.hayEstacionamientoVigente(patente));

        app.walking();
        assertTrue(sem.hayEstacionamientoVigente(patente));

    }
}
