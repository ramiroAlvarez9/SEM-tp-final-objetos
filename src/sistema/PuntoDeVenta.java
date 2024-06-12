package sistema;
import compras.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PuntoDeVenta {

    private final SEM sem;
    private List<Compra> comprasRealizadas = new ArrayList<Compra>();

    public PuntoDeVenta(SEM sem) {
        this.sem = sem; 
    }

    public void cargarCredito(String numeroTel, Double monto) {
        sem.cargarCredito(numeroTel, monto);
        CompraCelular nuevaCompra = new CompraCelular(LocalDate.now(), LocalTime.now(),numeroTel, monto, this);
        comprasRealizadas.add(nuevaCompra);
    }

}