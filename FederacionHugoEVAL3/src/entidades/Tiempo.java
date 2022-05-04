package entidades;

public class Tiempo implements Comparable<Tiempo> {
	protected int horas;
	protected int min; // Valor maximo = 59
	protected int seg; // Valor maximo = 59
	protected int cent; // Valor maximo = 99
	
// Constructor por defecto
	public Tiempo() {
		super();
	}

// Constructor con atributos
	public Tiempo(int horas, int min, int seg, int cent) {
		super();
		this.horas = horas;
		this.min = min;
		this.seg = seg;
		this.cent = cent;
	}

// Getters y Setters
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSeg() {
		return seg;
	}

	public void setSeg(int seg) {
		this.seg = seg;
	}

	public int getCent() {
		return cent;
	}

	public void setCent(int cent) {
		this.cent = cent;
	}

// Metodo toString() con formato "horas:minutos:segundos,centesimas"	
	@Override
	public String toString() {
		return horas + ":" + min + ":" + seg + "," + cent;
	}

	@Override
	public int compareTo(Tiempo o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
