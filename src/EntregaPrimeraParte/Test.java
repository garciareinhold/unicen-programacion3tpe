package EntregaPrimeraParte;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		//Se inicializa una instancia del buscador de libros
		BookFinder tool= new BookFinder();
		
		//Timer para evaluar el tiempo en que se genera la coleccion completa de libros
		Timer t= new Timer();
		t.start();
		
		//Se setea el path de un archivo de donde leer los datos y se crea la coleccion de libros
		tool.setColeccion("C:/datasets/dataset3.csv");
		
		System.out.println(t.stop());
		
		//Timer para evaluar el tiempo en que se genera el indice
		Timer s= new Timer();
		s.start();
		
		//Se genera el índice a partir de la coleccion de libros previamente creada
		tool.generarIndice();
		System.out.println(s.stop());
		
		//Imprimimos los nodos que fueron visitados para generar el índice
		System.out.println(tool.getNodosVisitados());
		
		//Imprimimos el índice para ver los generos
		tool.imprimirGeneros();
		
		//Se setea el path del archivo de salida de la coleccion resultante
		tool.setSalida("C:/salidas/salida1.csv");
		
		//Se piden ver los libros por género. Se genera un archivo con los libros que componen el género dado en el path seteado previamente
		tool.verLibrosGenero("cine");
	}

}
