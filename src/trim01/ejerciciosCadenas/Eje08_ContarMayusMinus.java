package trim01.ejerciciosCadenas;

import java.util.Scanner;

public class Eje08_ContarMayusMinus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Dime una frase y te la analizo: ");
        String f = sc.nextLine();
        String subf;

        int mayus = 0;
        int minus = 0;
        int spaces = 0;
        int nums = 0;

        for(int i = 1; i <= f.length(); i++){
            subf = f.substring(i-1,i);

            if(subf.matches("[a-z]")){
                minus++;
            }

            if(subf.matches("[A-Z]")){
                mayus++;
            }

            if(subf.matches("[0-9]")){
                nums++;
            }

            if(subf.matches(" ")){
                spaces++;
            }
        }

        System.out.println("Esta frase contiene:");
        System.out.println("\tMayúsculas: " + mayus);
        System.out.println("\tMinúsculas: " + minus);
        System.out.println("\tNúmeros: " + nums);
        System.out.println("\tEspacios: " + spaces);

	}

}
