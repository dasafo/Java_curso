/************************* Manipular ficheros y directorios************************
 * 
 * - C_File
 * 		-> M_getAbsolutePath(): Da la ruta del archivo
 * 		-> M_getPath() : 
 * 		-> M_getCanonicalPath() 
 * 		-> M_exits(): Nos dice si existe o no un archivo(T/F) 
 * 		-> M_list() 
 * 		-> M_isDirectory() 
 * 		   ....
 * 
 **********************************************************************************/

package ficheros_directorios;

import java.io.*;

public class PuebasRutas_68_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo=new File("ejemploArchivo");
		
		System.out.println(archivo.getAbsolutePath()); //para que imprima la ruta de ejemploArchivo
		
		System.out.println(archivo.exists()); //para ver si existe el archivo ejemploArchivo(true/false)
		
		
		
	}

}
