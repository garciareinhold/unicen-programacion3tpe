package EntregaPrimeraParte;

public class Libro {

	private String nombre;
	private String[] generos;
	
	public Libro(String nombre, String generos) {
		this.nombre= nombre;
		this.generos= generos.split(" ");
	}
	
	public boolean contieneGenero(String genero) {
		for(int i=0; i<generos.length; i++) {
			if(generos[i].equals(genero)) return true;
		}
		return false;
	}
	
	public String[] getGeneros() {
		return this.generos;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
