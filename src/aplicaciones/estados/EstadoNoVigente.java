package aplicaciones.estados;

import aplicaciones.Aplicacion;

public class EstadoNoVigente implements EstadoDeEstacionamiento {
    public void iniciarEstacionamiento(Aplicacion aplicacion) {
        aplicacion.iniciarEstacionamiento();
    }

    public void finalizarEstacionamiento(Aplicacion aplicacion) {
    }
}
