package EntregaPrimeraParte;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		
		Herramienta tool= new Herramienta();
		Timer t= new Timer();
		t.start();
		tool.setColeccion("C:/datasets/dataset4.csv");
		System.out.println(t.stop());
		tool.generarIndice();
		tool.getIndice().printPreOrder();
		tool.setSalida("C:/salidas/salida1.csv");
		tool.VerLibrosXGenero("cine");
	}

}
