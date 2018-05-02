package EntregaPrimeraParte;

public class Test {

	public static void main(String[] args) {
	
		Herramienta tool = new Herramienta();
		tool.setColeccion("C:/datasets/dataset4.csv");

		Timer s = new Timer();
		s.start();
		int comparaciones = tool.generarIndice();		
 
		System.out.println("Time ->" + s.stop());
		System.out.println("Comparations ->" + comparaciones);
		tool.mostrarIndice();

	}

}
