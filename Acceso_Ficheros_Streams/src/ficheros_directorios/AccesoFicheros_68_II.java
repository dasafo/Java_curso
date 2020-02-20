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

public class AccesoFicheros_68_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// "home" + file.separator + "david" + file.separator + ".." + ... para que sea compatible con todos los Sist. Operat.
		File ruta=new File("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/");
		
		System.out.println(ruta.getAbsolutePath());
		
		String[] nombresArchivos=ruta.list(); //almacenamos en un array el nombre de los archivos y carpetas almacenados en la direccion de arriba 
		
		for(int i=0;i<nombresArchivos.length;i++) { //mostramos en consola nombreArchivos
			
			System.out.println(nombresArchivos[i]);
			
			File f=new File(ruta.getAbsolutePath(), nombresArchivos[i]); //almacenamos la direccion de cada archivo o carpeta de esa direccion
			
			if(f.isDirectory()) { //si el arvhico es una carpeta le decimos que muestre lo que hay dentro
				
				String[] archivosSubcarpeta=f.list();
				
				for(int j=0;j<archivosSubcarpeta.length;j++) {
					
					System.out.println(archivosSubcarpeta[j]);

				}
				
			}
		}
		
		
	}

}
