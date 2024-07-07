package aplicaciones.estados;

import aplicaciones.Aplicacion;

public class EstadoVigente implements EstadoDeEstacionamiento {
    public void iniciarEstacionamiento(Aplicacion aplicacion) { }

    public void finalizarEstacionamiento(Aplicacion aplicacion) {
        aplicacion.finalizarEstacionamiento();
    }
}
