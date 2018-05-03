package EntregaPrimeraParte;

public class Test {

	public static void main(String[] args) {
		
		// Se genera la coleccion general con todos los libros
		Herramienta tool = new Herramienta();
		tool.setColeccion("C:/datasets/dataset4.csv");

		// Se inicia el timer (para la medicion) y se genera el indice
		Timer s = new Timer();
		s.start();
		int comparaciones = tool.generarIndice();		
		
		// Se muestran los resultados por pantalla
		System.out.println("Tiempo ->" + s.stop());
		System.out.println("Comparaciones ->" + comparaciones);
		tool.mostrarIndice();

	}

}
