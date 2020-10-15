package trim01;

public class Multiplos7_10 {
	
	public static void main(String[] args) {
		int c = 1;
		
		for(int i = 1; c <= 10; i++) {
			if(i % 7 == 0) {
				System.out.println(i);
				c++;
			}
		}
		
	}
	
}
