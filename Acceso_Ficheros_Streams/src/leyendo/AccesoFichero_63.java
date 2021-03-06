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

package leyendo;

import java.io.*;

public class AccesoFichero_63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		leerFichero accediendo=new leerFichero();
		
		accediendo.lee();

	}

}

class leerFichero {
	
	public void lee() {
		
		try {
			//FileREader es una excepción controlada(TryCatch)
			FileReader entrada=new FileReader("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/ejemplo.txt"); 
			
			int c=0; //para que lea la primera posicion del .txt y por consiguiente su letra
			
			while(c!=-1) { // -1 ya que es lo que lee en el fichero cuando llega al final del texto(ver API)
				
				c=entrada.read();
				
				char letra=(char)c; //pasamos de ASCII que hay en c a UNICODE(haciendo castin con char) y lo almacenamos en letra
				System.out.print(letra);
				
				// System.out.println(c); //que nos imprime el ASCII del fichero
			}
			
			entrada.close(); //para que cierre el archivo 
			
		} catch (IOException e) { // la excepccion de FileREader es FileNotFoundException, pero ponemos IOException(superclase de la otra) para que también englobe a read
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
	}
	
}
