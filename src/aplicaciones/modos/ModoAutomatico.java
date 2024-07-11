package aplicaciones.modos;

import aplicaciones.Aplicacion;

public class ModoAutomatico extends Modo {
	public void driving(Aplicacion app) {
		app.getEstado().finalizarEstacionamiento(app);
		if (app.getGPS().estaEnZonaDeEstacionamiento()) {
			app.recibirAlertaDeFinEstacionamiento();
		}
	}

	public void walking(Aplicacion app) {
		app.getEstado().iniciarEstacionamiento(app);
		if (app.getGPS().estaEnZonaDeEstacionamiento()) {
			app.recibirAlertaDeInicioEstacionamiento();
		}
	}
}
