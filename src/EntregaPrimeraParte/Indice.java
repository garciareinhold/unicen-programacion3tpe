package EntregaPrimeraParte;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Indice {

	private Vector<NodoIndice> generos;

	public Indice() {
		this.generos = new Vector<NodoIndice>();
	}

	public int agregarLibroPorGenero(Comparable genero, Libro libro) {
		int comparaciones = 0;
		NodoIndice nodo = new NodoIndice(genero);
		if (this.generos.size() == 0) {
			this.generos.add(nodo);
		} else if (this.generos.size() == 1) {
			comparaciones++;
			if (nodo.getGenero().compareTo(this.generos.elementAt(0).getGenero()) < 0) {
				this.generos.add(0, nodo);
			} else {
				this.generos.add(nodo);
			}
		} else {
			comparaciones = comparaciones + agregarLibroGenero(this.generos, nodo, libro);
		}

		return comparaciones;

	}

	public int agregarLibroGenero(Vector<NodoIndice> arreglo, NodoIndice dato, Libro libro) {

		int izquierda = 0;
		int derecha = arreglo.size() - 1;
		int centro = 0;
		int comparaciones = 0;

		boolean elementoRepetido = false;

		while ((izquierda <= derecha) && (!elementoRepetido)) {
			centro = ((izquierda + derecha) / 2);

			if (dato.getGenero().compareTo(arreglo.elementAt(centro).getGenero()) == 0) {
				elementoRepetido = true;
				comparaciones++;

			}
			if (dato.getGenero().compareTo(arreglo.elementAt(centro).getGenero()) < 0) {
				derecha = centro - 1;
				comparaciones++;
			} else {
				izquierda = centro + 1;
				comparaciones++;

			}
		}

		if (!elementoRepetido) {
			arreglo.add(izquierda, dato);
			arreglo.elementAt(izquierda).setLibro(libro);
		} else {
			arreglo.elementAt(centro).setLibro(libro);
		}

		return comparaciones;

	}

	public boolean existeGenero(Comparable genero) {

		int i = 0;
		while ((i < this.generos.size()) && (!this.generos.elementAt(i).getGenero().equals(genero))) {
			i++;
		}

		if (this.generos.size() == i)
			return false;
		else
			return true;

	}

	public void mostrarIndice() {
		for (int i = 0; i < this.generos.size(); i++) {
			System.out.println("//Genero// " + this.generos.elementAt(i).getGenero());			
		}
	}
	
	public void mostrarLibrosPorGenero () {
		for (int i = 0; i < this.generos.size(); i++) {
			System.out.println("//Genero// " + this.generos.elementAt(i).getGenero());
			this.generos.elementAt(i).mostrarLibros();
		}
	}

}
