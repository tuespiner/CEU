
public class Ejercicio_3 {

	public static void main(String[] args) {
		int numero = 9;
		for(int i = 0; i != 5; i++) {
			System.out.println("");
			for(int x = 1; x != 10; x++) {
				if(i == 0) {
					System.out.print(x);
				}else if(i == 1) {
					if (x%2 == 0) {
						System.out.print(x);
					}
				}else if(i==2) {
					if (x%3 == 0) {
						System.out.print(x);
					}
				}else if(i==3){
					if (x%4 == 0) {
						System.out.print(x);
					}
				}else {
					if (x%5 == 0) {
						System.out.print(x);
					}
				}
			}
			
		}
		
	}

}
