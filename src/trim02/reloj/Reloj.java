package trim02.reloj;

public class Reloj {
	
	private int horas;
	private int minutos;
	private int segundos;
	private int milisegundos;
	private String formato;
	private String meridiano;

	private static final String FORMATO_DEFECTO = "24h";
	private static final String AM = "a.m.";
	private static final String PM = "p.m.";

	public Reloj() {
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
		this.milisegundos = 0;
		this.formato = FORMATO_DEFECTO;
		this.meridiano = PM;
	}
	
	public Reloj(int horas) {
		this();
		this.horas = horas;			
		this.meridiano = (horas < 12 && horas >= 0) ? AM:PM;	
	}

	public Reloj(int horas, int minutos) {
		this(horas);
		this.minutos = minutos;	
	}

	public String getFormato() {
		return formato;
	}	

	public String getMeridiano() {
		return meridiano;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getMilisegundos() {
		return milisegundos;
	}

	public void setMilisegundos(int milisegundos) {
		this.milisegundos = milisegundos;
	}

	public void setFormato(String formato) {
		this.formato = formato;
		
		if(this.formato.equals("12h")){
			if(this.horas > 12) {
				this.horas -= 12;
			}
			
			if(this.horas == 0) {
				this.horas = 12;
			}
			
		} 
		
		if(this.formato.equals("24h") && this.meridiano.equals(PM)){
			this.horas += 12;
		}
	}

	public void sumarHoras(int horas) {
		int total = this.horas + horas;
		int limite = 0;

		switch(this.formato){
			case "24h":
				limite = 24;

				break;
			case "12h":
				limite = 12;

				if(this.meridiano.equals(AM))
				
				break;
		}		

		for(int i = 1; total >= limite; i++){
			total -= limite;

			if(total <= limite){
				switch(limite){
					case 12:
						if(i % 2 != 0){
							this.meridiano = (this.meridiano.equals(PM)) ? AM:PM;
						}
						
						if(total == 0) {
							total = 12;
						}

						break;
					case 24:
						this.meridiano = (total >= 0 && total < 12) ? AM:PM;
						
						break;
				}
			
			}

		}

		this.horas = total;
	}
	
	public void sumarMinutos(int minutos) {
		int total = this.minutos + minutos;
		int restante = total % 60;

		if(total >= 60){
			this.sumarHoras(total / 60);
		}

		this.minutos = restante;
	}

	public void sumarSegundos(int segundos) {
		int total = this.segundos + segundos;
		int restante = total % 60;

		if(total >= 60){
			this.sumarMinutos(total / 60);
		}

		this.segundos = restante;
	}

	public void sumarMilisegundos(int milisegundos) {
		int total = this.milisegundos + milisegundos;
		int restante = total % 1000;

		if(total >= 1000){
			this.sumarSegundos(total / 1000);
		}

		this.milisegundos = restante;
	}	

	public void darHora() {
		String laHora;
		String horas = String.valueOf(this.horas);
		String minutos = String.valueOf(this.minutos);
		String segundos = String.valueOf(this.segundos);
		String milisegundos = String.valueOf(this.milisegundos);

		if(this.horas < 10){
			horas = "0" + horas;
		}

		if(this.minutos < 10){
			minutos = "0" + minutos;
		}

		if(this.segundos < 10){
			segundos = "0" + segundos;
		}

		if(this.milisegundos < 100){
			milisegundos = "0" + milisegundos;

			if(this.milisegundos < 10){
				milisegundos = "0" + milisegundos;
			}
		}

		laHora = horas + ":" + minutos + ":" + segundos + "." + milisegundos;

		if(this.formato.equals("12h")){
			laHora += " " +  meridiano;
		}

		System.out.println(laHora);
	}

	@Override
	public String toString(){
		return minutos + ":" + segundos + "." + milisegundos;
	}

}
