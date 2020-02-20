/*****************Formas de abordar los Streams (secuencias)*********************
 * 
 * - Flujo de Bytes
 * 		-> C(A)_InputStream (para ver la info de bytes almacenadas en un archivo)
 * 		-> C(A)_OutputStream (Para escribir bytes en un archivo)
 * 
 * - Flujo de caracteres
 * 		-> C(A)_Reader (para leer la info de caracteres almacenadas en un archivo)
 * 			--> C_FileReader
 * 		-> C(A)_Writer (Para escribir caracteres en un archivo)
 * 			--> C_FileWriter
 * 
 * - Buffer/Filtro (memoria intermedia entre el texto y nuestro codigo)
 * 		-> C_BufferedReader
 * 			--> M_readLine() (lee linea a linea un archivo entero)
 * 		-> C_BufferedWriter
 * 
 * C(A)= Clase Abstracta M=Metodo
 *********************************************************************************/


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
			FileWriter escritura=new FileWriter("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/ejemplo.txt", true); //ponemos el true para que agrege el texto a un archivo ya preexistente, sino lo sobreescribe
			
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


