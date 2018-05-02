package EntregaPrimeraParte;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

//		Herramienta tool= new Herramienta();
//		tool.setColeccion("C:/datasets/dataset1.csv");
//		tool.generarIndice();
//		tool.getIndice().printPreOrder();
//		tool.setSalida("C:/salidas/salida1.csv");
//		tool.VerLibrosXGenero("cine"); 
		
		Indice generos = new Indice();
		Comparable gen = "Ficcion";
		
		Comparable gen2 = "Guerra";
		Comparable gen1 = "Warras";
		Comparable gen4 = "Arre";
		Comparable gen5 = "Galacticas";
		Comparable gen6 = "Aastern";
		Comparable gen7 = "Zodiaco";
		
		generos.setGenero(gen);		
		generos.setGenero(gen2);
		generos.setGenero(gen1); 
		generos.setGenero(gen4);
		generos.setGenero(gen5);
		generos.setGenero(gen6);
		generos.setGenero(gen7);
		
		System.out.println("////////////////////////");
		generos.mostrarIndice();
		
		
		
		
		
	}

}
