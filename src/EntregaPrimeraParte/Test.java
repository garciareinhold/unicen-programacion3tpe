package EntregaPrimeraParte;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		
		Herramienta tool= new Herramienta();
		Timer t= new Timer();
		t.start();
		tool.setColeccion("C:/datasets/dataset1.csv");
		System.out.println(t.stop());
		Timer s= new Timer();
		s.start();
		tool.generarIndice();
		System.out.println(s.stop());
		System.out.println(tool.getNodosVisitados());
		tool.getIndice().printPreOrder();
//		tool.setSalida("C:/salidas/salida1.csv");
//		tool.VerLibrosXGenero("cine");
	}

}
