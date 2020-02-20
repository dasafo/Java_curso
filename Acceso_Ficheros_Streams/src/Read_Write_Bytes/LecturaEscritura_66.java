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


package Read_Write_Bytes;

import java.io.*;

public class LecturaEscritura_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contador=0; //para que nos cuenta los bytes que hay en la imagen
		
		int datosEntrada[]=new int[59097]; //almacenamos los bytes en una matriz una vez sabemos cuantos tenemos gracias a contador

		try {
			
			FileInputStream archivoLectura=new FileInputStream("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/Acceso_Ficheros_Streams/6.jpg");
			
			boolean finalAr=false;
			
			while(!finalAr) { //la excalamacion delante niega lo que sigue
				
				int byteEntrada=archivoLectura.read(); //leera todos los bytes uno a uno
				
				if(byteEntrada!=-1) //le decimos que el valor -1(el último por defecto) no lo meta en el array
					
					datosEntrada[contador]=byteEntrada;
								
				else
					
					finalAr=true;
					
				System.out.println(datosEntrada[contador]);
					
				contador++;
				
			}
			
			archivoLectura.close();
			
		}catch(IOException e) {
			
			System.out.println("Error al acceder a la imagen");
			
		}
		
		System.out.println(contador);
		
		creaFichero(datosEntrada);

	}
	
	
	static void creaFichero(int datosNuevoFichero[]) {
		
		try {
			 FileOutputStream ficheroNuevo=new FileOutputStream("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/Acceso_Ficheros_Streams/6_copia.jpg");
			 
			 for(int i=0;i<datosNuevoFichero.length;i++) { //leemos el array dónde están almacenados los bytes de la imagen orifinal
				 
				 ficheroNuevo.write(datosNuevoFichero[i]);
			 }
			
			 ficheroNuevo.close();
			 
		}catch(IOException e) {
			
			System.out.println("Error al crear el archivo");

		}
		
	}

}
