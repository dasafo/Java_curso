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
			FileReader entrada=new FileReader("/home/david/eclipse-workspace/ejemplo.txt"); //FileREader es una excepción controlada(TryCatch)
			
			int c=0;
			
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
