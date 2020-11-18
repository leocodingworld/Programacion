package trim01.bloqueEjercicios04;

public class Eje06_Matrices {
	
	public static int[][] suma(int[][] m1, int[][] m2){
		int[][] matriz = new int[m1.length][m1.length];

		for(int i = 0; i <= m1.length - 1; i++){
			for(int j = 0; j <= m1[0].length - 1; j++){
				matriz[i][j] = m1[i][j] + m2[i][j];
			}
		}

		return matriz;
	}

	public static int[][] resta(int[][] m1, int[][] m2){
		int[][] matriz = new int[m1.length][m1.length];

		for(int i = 0; i < m1.length; i++){
			for(int j = 0; j < m1[0].length; j++){
				matriz[i][j] = m1[i][j] - m2[i][j];
			}
		}

		return matriz;
	}

	public static int[][] escalar(int[][] m1, int alfa){
		int[][] matriz = new int[m1.length][m1.length];

		for(int i = 0; i < m1.length; i++){
			for(int j = 0; j < m1[0].length; j++){
				matriz[i][j] = alfa * m1[i][j];
			}
		}

		return matriz;
	}

	public static int[][] producto(int[][] m1, int[][] m2){
		int[][] matriz = new int[m1.length][m2[0].length];
		int e;

		for(int i = 0; i < m1.length; i++){

			for(int j = 0; j < m2.length; j++){
				e = 0;
				
				for(int k = 0; k < m1.length; k++){
					e += m1[i][k] * m2[k][j];				
				}

				matriz[i][j] = e;
			}
		}
		
		return matriz;
	}
	
	public static void sacarMatrix(int[][] m) {
		
		for(int i = 0; i < m.length; i++) {			
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] +"\t");
			}
			
			System.out.println("");	
		}
		
	}

	public static void main(String[] args) {
		int[][] a = {
			{1,2},
			{3,4}
		};
		
		int[][] b = {
			{-9,4},
			{ 0,5}
		};
		
		int [][] c = {
			{ 0,2,1},
			{-1,6,4}
		};
		
			
		sacarMatrix(suma(a,b));
		System.out.println("\n");
		
		sacarMatrix(resta(a,b));
		System.out.println("\n");
		
		sacarMatrix(producto(a,b));
		System.out.println("\n");
		
		sacarMatrix(producto(a,c));
		System.out.println("\n");
		
		sacarMatrix(escalar(a,5));
		System.out.println("\n");

	}

}
