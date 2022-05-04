package entidades;

import java.util.Arrays;

public class Participante implements Comparable <Participante>{
	protected long id;
	protected int dorsal; // valor entre 001 y 150
	protected char calle;
	/// Examen 11 Ejercicio 2
	protected boolean penalización = false;
	protected String otros;
	
	/// Examen 11 Ejercicio 2
	protected Tiempo[] tiempo;

	public Participante(long id, int dorsal, char calle, boolean penalizacion, String otros) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
		this.penalización = penalizacion;
		this.otros = otros;
	}
	
	public Participante(long id, int dorsal, char calle) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
	}

	public Participante() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public char getCalle() {
		return calle;
	}

	public void setCalle(char calle) {
		this.calle = calle;
	}

	/// Examen 11 Ejercicio 2
	public boolean isPenalización() {
		return penalización;
	}

	public void setPenalización(boolean penalización) {
		this.penalización = penalización;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public Tiempo[] getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo[] tiempo) {
		this.tiempo = tiempo;
	}

	/// Examen 11 Ejercicio 2
	@Override
	public String toString() {
		return "Participante [id=" + id + ", dorsal=" + dorsal + ", calle=" + calle + ", penalización=" + penalización
				+ ", otros=" + otros + ", tiempo=" + Arrays.toString(tiempo) + "]";
	}

	@Override
	public int compareTo(Participante p) {
//		if (this.getTiempo().compareTo(p.getTiempo()))
//			return -1;
//		else
//		
//		if (this.getTiempo().compareTo(p.getTiempo()))
//			return 1;
//		else {
//			if (this.getNifnie().compareTo(o2.getNifnie()))
			return 0;
//		}
	}

}
