package trim02.poo.torneo;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	
	public void jugarPartido() {
		this.equipo1.aumentarValoracion();
		this.equipo2.aumentarValoracion();
	}
}
