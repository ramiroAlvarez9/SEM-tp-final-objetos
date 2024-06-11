package estacionamientos;

import notificaciones.Notificador;

public class EstacionamientoPuntual extends Estacionamiento{
    
	public EstacionamientoPuntual(Notificador notificador, String patente, int horas) {
        super(notificador, patente);
        this.fin = calcularTiempoDentroDe(horas);
    }
	
	
}
