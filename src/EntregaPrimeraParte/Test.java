package EntregaPrimeraParte;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
	
		Herramienta tool = new Herramienta();
		tool.setColeccion("C:/datasets/dataset4.csv");

		Timer s = new Timer();
		s.start();
		int comparaciones = 0;

		comparaciones = tool.generarIndice();

		System.out.println("Time ->" + s.stop());
		System.out.println("Comparations ->" + comparaciones);
		// tool.mostrarIndice();

	}

}
