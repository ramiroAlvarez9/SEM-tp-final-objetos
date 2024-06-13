package aplicaciones.modos;

import aplicaciones.Aplicacion;
import sistema.SEM;

public class ModoManual extends Modo {
	
	public void iniciarEstacionamiento(Aplicacion aplicacion) {
		SEM sem = aplicacion.getSem();
		sem.registrarEstacionamiento(aplicacion);
	}

	public void finalizarEstacionamiento(Aplicacion aplicacion) {
		SEM sem = aplicacion.getSem();
		sem.finalizarEstacionamiento(aplicacion.getNumeroTel());
	}
}
