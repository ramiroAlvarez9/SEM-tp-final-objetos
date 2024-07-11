package aplicaciones.estados;

import aplicaciones.Aplicacion;

public class EstadoNoVigente implements EstadoDeEstacionamiento {
    public void iniciarEstacionamiento(Aplicacion app) {
        app.setEstado(new EstadoVigente());
    }

    public void finalizarEstacionamiento(Aplicacion app) {
    }
}
