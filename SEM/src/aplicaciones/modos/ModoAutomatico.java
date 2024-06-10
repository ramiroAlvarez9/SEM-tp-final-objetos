package aplicaciones.modos;

import aplicaciones.Aplicacion;
import estacionamientos.EstadoDeEstacionamiento;

public class ModoAutomatico extends Modo {

	public void driving(Aplicacion app) {
		if(app.getEstado() == EstadoDeEstacionamiento.Vigente){
			finalizarEstacionamiento(app);
		}
	}

	public void walking(Aplicacion app) {
		if(app.getEstado() == EstadoDeEstacionamiento.NoVigente) {
			iniciarEstacionamiento(app);
		}
	}
}
