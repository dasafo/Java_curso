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

public class Creando_69_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File ruta=new File("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/Acceso_Ficheros/pruebaTexto.txt");
		
		// ruta.mkdir(); //para crear una nueva carpeta con el nombre nuevoDirectorio(puesto arriba)
		
		String archivoDestino=ruta.getAbsolutePath();
		
		try {
			ruta.createNewFile(); //crear un archivo con el nombre pruebaTExto.txt
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Escribiendo accedeEs=new Escribiendo();
		
		accedeEs.escribir(archivoDestino);
		
		
	}

}


class Escribiendo{  //metemos en el archivo creado el texto que ponemos a continuacion
	
	
	public void escribir(String rutaArchivo) {
		
		String frase="Esto es un ejemplo";
		
		try {
			
			FileWriter escritura=new FileWriter(rutaArchivo);
			
			for(int i=0;i<frase.length();i++) {
				
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
			
		}catch(IOException e) {}
	}
	
}





