package escribiendo;

import java.io.*;

public class EscribirFichero_64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Escribiendo accede=new Escribiendo();
		
		accede.escribir();
		
	}

}

class Escribiendo{
	
	public void escribir() {
		
		String frase="Esto es una prueba de escritura";
		
		try {
			FileWriter escritura=new FileWriter("/home/david/eclipse-workspace/textoNuevo.txt", true); //ponemos el true para que agrege el texto a un archivo ya preexistente, sino lo sobreescribe
			
			for(int i=0;i<frase.length();i++) {
				
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


