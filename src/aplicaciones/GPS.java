package aplicaciones;

public class GPS {
	
	boolean respuestaGps = true;
	
	public void setRespuestaGps(Boolean bool) {
		respuestaGps = bool;
	}
	public boolean estaEnZonaDeEstacionamiento() {
		return this.respuestaGps;
	}
}
