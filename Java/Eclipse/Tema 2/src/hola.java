
public class hola {

	public static void main(String[] args) {
		String tay = "tay";
		int longitud = tay.length();
		int longitud1 = longitud;
		for(int i = 0; i<longitud;i++) {
			System.out.println(tay.substring((longitud1-1),longitud1));
			longitud1--;
		}
	}

}
