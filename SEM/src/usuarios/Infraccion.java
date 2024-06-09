package usuarios;
import java.time.*;
import sistema.*;

public class Infraccion {

	LocalDate fecha;
	LocalTime hora;
	ZonaDeEstacionamiento zona;
	Inspector inspector;
	String patente;
	
	public Infraccion(ZonaDeEstacionamiento zona, Inspector inspector, String patente){
		this.fecha = LocalDate.now();
		this.hora = LocalTime.now();
		this.zona = zona;
		this.inspector = inspector;
		this.patente = patente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public ZonaDeEstacionamiento getZona() {
		return zona;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public String getPatente() {
		return patente;
	}
	
	
	
	
	
}
