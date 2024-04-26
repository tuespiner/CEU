package EJ2;

public class Fecha {

	private int dia;
	private int mes;
	private int año;

	public Fecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}

	public boolean valida() {
		if (dia < 1 || dia > 31) {
			return false;
		}
		if (mes < 1 || mes > 12) {
			return false;
		}

		int diasMes = switchDiasMes();
		if (dia > diasMes) {
			return false;
		}
		else {
			return true;
		}

	}

	private int switchDiasMes() {
		int diasMes = 0;
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			diasMes = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diasMes = 30;
			break;
		case 2: // a�o bisiesto
			if (esBisiesto())
				diasMes = 29;
			else
				diasMes = 28;
			break;
		}
		return diasMes;
	}

	private boolean esBisiesto() {
		return (año % 400 == 0) ||
				((año % 4 == 0) && (año % 100 != 0));
	}

}
