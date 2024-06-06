package sem.estacionamientos;

public class EstacionamientoPuntual extends Estacionamiento{

    public EstacionamientoPuntual(String patente, int horas) {
        super(patente);
        this.fin = calcularHorarioFin(calcularTiempoDentroDe(horas));
    }
}
