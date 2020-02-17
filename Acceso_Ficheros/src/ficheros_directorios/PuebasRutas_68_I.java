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
