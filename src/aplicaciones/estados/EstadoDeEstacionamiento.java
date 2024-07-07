package aplicaciones.estados;

import aplicaciones.Aplicacion;

public interface EstadoDeEstacionamiento {
    void iniciarEstacionamiento(Aplicacion aplicacion);
    void finalizarEstacionamiento(Aplicacion aplicacion);
}
