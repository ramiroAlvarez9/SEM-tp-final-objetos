package usuarios;

import java.util.ArrayList;
import java.util.List;

import sistema.*;

public class Inspector {
    
	private SEM sem;
    private List<Infraccion> infracciones = new ArrayList<Infraccion>();
    
    public Inspector(SEM sem) {
    	this.sem = sem;
    }

	public SEM getSem() {
		return sem;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

    public boolean consultaEstacionamientoVigente(String patente) {
    	return this.getSem().estacionamientoConPatente(patente).esVigente();
    }
    
    public void cargarInfraccionPara(String patente, ZonaDeEstacionamiento zona) {
    		Infraccion i = new Infraccion(zona, this, patente);
    		infracciones.add(i);
    }
}
