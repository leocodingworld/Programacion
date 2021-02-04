package trim02.poo.torneo;

public class Torneo {

	public static void main(String[] args) {
		Equipo e1 = new Equipo();		
		Equipo e2 = new Equipo(); 
		Equipo e3 = new Equipo(); 
		Equipo e4 = new Equipo();
		  
		Equipo[] equipos = {e1, e2, e3, e4};
		  
		Partido p1 = new Partido(e1,e2); 
		Partido p2 = new Partido(e3,e4);
		  
		for(Equipo e:equipos){ 
			e.setCodigo(); 
			e.setNumJugadores(); 
			e.setValoracion();
		  
			System.out.println(e.toString()); 
			System.out.println(""); 
		}
		  
		p1.jugarPartido(); 
		p2.jugarPartido();
		  
		for(Equipo e:equipos){ 
			System.out.println(e.toString());
			System.out.println(""); 
		}
		 
	}
	
}
