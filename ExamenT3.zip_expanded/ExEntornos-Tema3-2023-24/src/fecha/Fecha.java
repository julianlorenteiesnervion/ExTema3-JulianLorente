package fecha;

public class Fecha {
	public static final int DIEZ = 10;
	private int dia; //día
	private int mes; //mes
	private int annio; //a�o

	
	/**
	 * @deprecated
	 */
	public Fecha() {

	}

	/**
	 * Constructor de la clase Fecha
	 * @param dia Parámetro para el día
	 * @param mes Parámetro para el mes
	 * @param anio Parámetro para el año
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.annio = anio;
	}

	
	/**
	 * Método para comprobar si una fecha es correcta
	 * @return Devuelve un booleano indicando si la fecha es correcta o no
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = annio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Método esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	 * @return Devuelve si es bisiesto
	 */
	private boolean esBisiesto() {
		return annio % 4 == 0 && annio % 100 != 0 || annio % 400 == 0;
	}

	/**
	 * Método diaSiguiente
	 */
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				annio++;
			}
		}
	}

	/**
	 * Método toString (Modifica lo que devuelve el toString)
	 */
	@Override
	public String toString() {
		String mensaje;
		
		if (dia < DIEZ && mes < DIEZ) {
			mensaje = "0" + dia + "-0" + mes + "-" + annio;
		} else if (dia < DIEZ && mes >= DIEZ) {
			mensaje = "0" + dia + "-" + mes + "-" + annio;
		} else if (dia >= DIEZ && mes < DIEZ) {
			mensaje = dia + "-0" + mes + "-" + annio;
		} else {
			mensaje = dia + "-" + mes + "-" + annio;
		}
		
		return mensaje;
	}

}
