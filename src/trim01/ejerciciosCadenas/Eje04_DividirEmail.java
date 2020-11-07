package trim01.ejerciciosCadenas;

public class Eje04_DividirEmail {
	
	public static void main(String[] args) {
		String email = "paquito@chocolatero.es";
        
        System.out.println(email.substring(0,email.indexOf("@")));
        System.out.println(email.substring(email.indexOf("@") + 1));
	}
	
}
