package EntregaPrimeraParte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {

	private String path;

	public void generarCSV(ArrayList<String> nombres) {

		BufferedWriter bw = null;
		try {
			File file = new File(this.path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);


			for(int i=0; i<nombres.size(); i++){
				String linea= nombres.get(i);				
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
