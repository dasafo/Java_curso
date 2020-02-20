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
/*
 * - Si queremos leer cientos de palabras lo usado hasta ahora no sería eficiente,
 * por ello se crean los Buffer.
 * - Un Buffer es una especie de memoria interna que se coloca fisicamente en medio
 * de lo que sería nuestro código y nuestro archivo de texto.
 * - De esta forma el texto se descarga primero en ese Buffer y después nuestro 
 * programa poco a poco va operando con esa info del Buffer.
 * - Se gana rapidez y eficiencia (se usa por ejemplo en los Streamings)
 */

package leyendo;

import java.io.*;

public class BufferFichero_65 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		leerFichero2 accediendo=new leerFichero2();
		
		accediendo.lee();

	}

}

class leerFichero2{
	
	public void lee() {
		
		try {
			
			entrada=new FileReader("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/ejemplo.txt"); //FileREader es una excepción controlada(TryCatch)
			
			BufferedReader mibuffer=new  BufferedReader(entrada); //con Buffer almaenamos en una memoria intermedia el fichero de texto
			
			String linea="";
			
			while(linea!=null) { 
				
				linea=mibuffer.readLine(); //leera la primera linea almacenada en mibuffer
				
				if(linea!=null) { //para que no imprima null al final
				System.out.println(linea);
				}
				// System.out.println(c); //que nos imprime el ASCII del fichero
			}
			 
			
		}catch (IOException e) { // la excepccion de FileREader es FileNotFoundException, pero ponemos IOException(superclase de la otra) para que también englobe a read
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
			
		}finally{
			
			try {
				entrada.close();

			}catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	FileReader entrada;
}
