package aplicaciones.modos;

import aplicaciones.Aplicacion;

public abstract class Modo {
	public void driving(Aplicacion aplicacion) { }
	public void walking(Aplicacion aplicacion) { }
	
	public void iniciarEstacionamiento(Aplicacion app) {
		app.getSem().registrarEstacionamiento(app); 
	}
	
	public void finalizarEstacionamiento(Aplicacion app) {
		app.getSem().finalizarEstacionamiento(app.getNumeroTel());
	}
}
