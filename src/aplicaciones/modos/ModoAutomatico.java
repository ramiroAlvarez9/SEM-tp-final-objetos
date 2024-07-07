package aplicaciones.modos;

import aplicaciones.Aplicacion;

public class ModoAutomatico extends Modo {
	public void driving(Aplicacion app) {
		app.getEstado().finalizarEstacionamiento(app);
	}

	public void walking(Aplicacion app) {
		app.getEstado().iniciarEstacionamiento(app);
	}
}
