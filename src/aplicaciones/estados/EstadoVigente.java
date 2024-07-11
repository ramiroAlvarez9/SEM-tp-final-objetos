package aplicaciones.estados;

import aplicaciones.Aplicacion;

public class EstadoVigente implements EstadoDeEstacionamiento {
    public void iniciarEstacionamiento(Aplicacion app) { }

    public void finalizarEstacionamiento(Aplicacion app) {
        app.setEstado(new EstadoNoVigente());
        app.getSem().finalizarEstacionamiento(app.getNumeroTel());
    }
}
