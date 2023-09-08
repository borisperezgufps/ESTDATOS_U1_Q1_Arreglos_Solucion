package estdatos.unidad1.quiz1.negocio;

public class Panel {

	private String identificador;
	private double porcentajeCalidad;
	
	private Celda[] celdas;
	private Celda[] defectuosas;
	
	public Panel() {
		celdas = new Celda[10]; // Valor arbitrario
		
		llenarCeldas();
	}
	
	/**
	 * Este m�todo se encarga de recorrer el arreglo celdas y
	 * marcar todas las celdas como deterioradas si tienen la 
	 * capacidad por debajo de 30%.
	 */
	public void iniciarRevisionCeldas() {
		for (int i = 0; i < celdas.length; i++) {
			Celda celda = celdas[i];
			if(celda!=null && celda.getCapacidad()<30)
				celda.setDeteriorada(true);
		}
	}
	
	/**
	 * Este m�todo se encarga de recorrer el arreglo celdas
	 * y retirar las celdas que est�n marcadas como deterioradas. 
	 * Adicionalmente, las celdas retiradas deber�n organizarse 
	 * en un segundo arreglo de nombre defectuosas. Este segundo 
	 * arreglo debe tener el tama�o exacto de celdas defectuosas
	 */
	public void moverCeldasDefectuosas() {
		int contadorCeldasDeterioradas = 0;
		
		// Cuento las celdas deterioradas.
		for (int i = 0; i < celdas.length; i++) {
			Celda celda = celdas[i];
			if(celda!=null && celda.isDeteriorada())
				contadorCeldasDeterioradas++;
		}
		
		// Se instancia el arreglo de celdas defectuosas
		defectuosas = new Celda[contadorCeldasDeterioradas];
		
		int contadorArregloDefectuosas = 0; // Contador para el 2do arreglo
		for (int i = 0; i < celdas.length; i++) {
			Celda celda = celdas[i]; // Se obtiene la celda
			if(celda!=null && celda.isDeteriorada()) { // Se buscan las celdas deterioradas
				celdas[i] = null; // Se pone en null la posici�n de la celda deteriorada
				defectuosas[contadorArregloDefectuosas] = celda; // Se agrega la celda al 2do arreglo
				contadorArregloDefectuosas++;
			}
		}
	}
	
	/**
	 * Este m�todo se encarga de revisar el arreglo celdas y
	 * establecer el porcentaje de celdas que siguen funcionando. 
	 * El atributo porcentajeCalidad deber� colocarse el valor 
	 * correspondiente. Por ejemplo, si quedan 4 celdas de 10, entonces
	 * el porcentaje calidad ser� de 40%.
	 */
	public void actualizarEstadoPanel() {
		int contadorCeldasFuncionales = 0;
		for (int i = 0; i < celdas.length; i++) {
			Celda celda = celdas[i];
			if(celda!=null && !celda.isDeteriorada())
				contadorCeldasFuncionales++;
		}
		
		setPorcentajeCalidad(contadorCeldasFuncionales / celdas.length * 100);
		
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public double getPorcentajeCalidad() {
		return porcentajeCalidad;
	}

	public void setPorcentajeCalidad(double porcentajeCalidad) {
		this.porcentajeCalidad = porcentajeCalidad;
	}

	/**
	 * Este m�todo se usa para llenar el arreglo de celdas.
	 * La informaci�n de la capacidad se generar� de forma aleatoria.
	 */
	private void llenarCeldas() {
		for (int i = 0; i < celdas.length; i++) {
			Celda celda = new Celda(Math.random()*100); // Genera un n�mero entre 0 y 99
			celdas[i] = celda;
		}
	}
	
	public void imprimirCeldas() {
		for (int i = 0; i < celdas.length; i++) {
			Celda celda = celdas[i];
			if(celda!=null)
				System.out.println(celda.getCapacidad() + " - " + celda.isDeteriorada());
		}
	}
}
