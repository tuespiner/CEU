import java.util.Scanner;
public class Ejercicio_2_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nomb1;
		String nomb2;
		String nomb3;
		int largo1;
		int largo2;
		int largo3;
		System.out.println("dime un nombre");
		nomb1 = scanner.nextLine();
		System.out.println("dime otro nombre");
		nomb2 = scanner.nextLine();
		System.out.println("dime otro nombre");
		nomb3 = scanner.nextLine();
		
		largo1 = nomb1.length();
		largo2 = nomb2.length();
		largo3 = nomb3.length();
		if((largo1 > largo2) &&(largo1 > largo3)) {
			System.out.println(nomb1);
			if(largo2 > largo3) {
				System.out.println(nomb2+"\n"+nomb3);
			}else {
				System.out.println(nomb3+"\n"+nomb2);
			}
		}
		else if((largo2 > largo1) &&(largo2 > largo3)) {
			System.out.println(nomb2);
			if(largo1 > largo3) {
				System.out.println(nomb1+"\n"+nomb3);
			}else {
				System.out.println(nomb3+"\n"+nomb1);
			}
		}
		else if((largo3 > largo1) &&(largo3 > largo2)) {
			System.out.println(nomb3);
			if(largo1 > largo2) {
				System.out.println(nomb1+"\n"+nomb2);
			}else {
				System.out.println(nomb2+"\n"+nomb1);
			}
		}
		
		
	}

}
