/************************* Manipular ficheros y directorios************************
 * 
 * - C_File
 * 		-> M_getAbsolutePath(): Da la ruta del archivo
 * 		-> M_getPath() : 
 * 		-> M_getCanonicalPath() 
 * 		-> M_exits(): Nos dice si existe o no un archivo(T/F) 
 * 		-> M_list(): Devuelve un array[STRING] con los nombres de directorios 
 * 		-> M_isDirectory() 
 * 		   ....
 * 
 **********************************************************************************/


package ficheros_directorios;

import java.io.*;

public class Eliminar_69_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ruta=new File("/home/david/eclipse-workspace/Acceso_Ficheros/pruebaTexto.txt");

		ruta.delete(); //para borrar el archivo

	}

}
