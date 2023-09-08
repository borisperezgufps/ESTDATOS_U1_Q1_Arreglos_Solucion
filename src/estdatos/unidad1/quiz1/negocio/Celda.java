package estdatos.unidad1.quiz1.negocio;

public class Celda {

	private double capacidad;
	private boolean deteriorada;
	
	public Celda(double capacidad) {
		this.capacidad = (int) capacidad; // Se hace el casting a entero para eliminar los decimales.
	}
	
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isDeteriorada() {
		return deteriorada;
	}
	public void setDeteriorada(boolean deteriorada) {
		this.deteriorada = deteriorada;
	}
	
	
	
}
