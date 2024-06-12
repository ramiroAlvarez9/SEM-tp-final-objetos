package aplicaciones.modos;

import aplicaciones.Aplicacion;
import sistema.SEM;

public abstract class Modo {
	public void iniciarEstacionamiento(Aplicacion aplicacion) {
		SEM sem = aplicacion.getSem();
		sem.registrarEstacionamiento(aplicacion);
	}

	public void finalizarEstacionamiento(Aplicacion aplicacion) {
		SEM sem = aplicacion.getSem();
		sem.finalizarEstacionamiento(aplicacion.getNumeroTel());
	}

	public void driving(Aplicacion aplicacion) { }
	public void walking(Aplicacion aplicacion) { }
}
