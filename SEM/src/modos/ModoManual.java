package modos;

import aplicaciones.Aplicacion;
import sistema.SEM;

public class ModoManual extends Modo {

	@Override
	public void iniciarEstacionamiento(Aplicacion aplicacion) {
		SEM sem = aplicacion.getSem();
		sem.registrarEstacionamiento(aplicacion.getPatente(), aplicacion.getNumeroTel());           
	}

	@Override
	public void finalizarEstacionamiento(Aplicacion aplicacion) {
		SEM sem = aplicacion.getSem();
		sem.finalizarEstacionamiento( aplicacion.getNumeroTel() );
	}
	 
}
