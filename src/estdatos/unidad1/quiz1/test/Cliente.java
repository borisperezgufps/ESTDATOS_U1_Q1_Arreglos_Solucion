package estdatos.unidad1.quiz1.test;

import estdatos.unidad1.quiz1.negocio.Panel;

public class Cliente {

	public static void main(String[] args) {
		Panel p = new Panel();
		
		System.out.println("/////////////////////////");
		p.imprimirCeldas();
	
		p.iniciarRevisionCeldas();
		p.moverCeldasDefectuosas();
		p.actualizarEstadoPanel();		

		System.out.println("/////////////////////////");
		p.imprimirCeldas();
		
	}
	
}
