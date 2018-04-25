package EntregaPrimeraParte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {

	private String path;

	public void generarCSV(ArrayList<Libro> coleccion, ArrayList<Integer> punteros) {

		BufferedWriter bw = null;
		try {
			File file = new File(this.path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);


			for(int i=0; i<punteros.size(); i++){
				String linea= coleccion.get(punteros.get(i)).getNombre();
				bw.write(linea);
				bw.newLine();
			}

			//			String contenidoLinea1 = "Usuario1,Tiempo1";
			//			bw.write(contenidoLinea1);
			//			bw.newLine();



		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}

	}

	public void setPath(String path) {

		this.path=path;
	}
}
