package Read_Write_Bytes;

import java.io.*;

public class LecturaEscritura_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contador=0; //para que nos cuenta los bytes que hay en la imagen
		
		int datosEntrada[]=new int[59097]; //almacenamos los bytes en una matriz una vez sabemos cuantos tenemos gracias a contador

		try {
			
			FileInputStream archivoLectura=new FileInputStream("/home/david/eclipse-workspace/Acceso_Ficheros/6.jpg");
			
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
			 FileOutputStream ficheroNuevo=new FileOutputStream("/home/david/eclipse-workspace/Acceso_Ficheros/6_copia.jpg");
			 
			 for(int i=0;i<datosNuevoFichero.length;i++) { //leemos el array dónde están almacenados los bytes de la imagen orifinal
				 
				 ficheroNuevo.write(datosNuevoFichero[i]);
			 }
			
			 ficheroNuevo.close();
			 
		}catch(IOException e) {
			
			System.out.println("Error al crear el archivo");

		}
		
	}

}
