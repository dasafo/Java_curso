package leyendo;

import java.io.*;

public class AccesoFichero2_65 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		leerFichero2 accediendo=new leerFichero2();
		
		accediendo.lee();

	}

}

class leerFichero2{
	
	public void lee() {
		
		try {
			
			entrada=new FileReader("/home/david/eclipse-workspace/ejemplo.txt"); //FileREader es una excepción controlada(TryCatch)
			
			BufferedReader mibuffer=new  BufferedReader(entrada); //con Buffer almaenamos en una memoria intermedia el fichero de texto
			
			String linea="";
			
			while(linea!=null) { 
				
				linea=mibuffer.readLine(); //leera la primera linea almacenada en mibuffer
				
				if(linea!=null) {
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
