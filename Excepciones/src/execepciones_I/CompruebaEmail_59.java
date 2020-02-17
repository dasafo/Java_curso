package execepciones_I;

import java.io.EOFException;

import javax.swing.*;

public class CompruebaEmail_59 {

	public static void main(String[] args) {
		
		String mail=JOptionPane.showInputDialog("Introduce el Mail: ");


		try {
		examinaMail(mail);
		}catch(Exception e){
			
			System.out.println("La dirección no es correcta");
			e.printStackTrace(); //le decimos que imprima la llamada de este error
		}
	}
	
	// static void examinaMail(String mail) throws EOFException { //si ponemos un EOFException estamos obligados en este caso a porner una excepcion controlada(try catch)
	static void examinaMail(String mail) throws longitudEmailError{  //lanzamos nuestro error(creado abajo del todo
	
		int arroba=0;
		
		boolean punto=false;
		
		if(mail.length()<=3) { //lanzamos manualmente una excepcion (por ej ArrayIndexOutOfBoundsException)cuando se introduzca 3 carácteres o menos
			
			throw new longitudEmailError("El Email es muy corto.");
			
			// ArrayIndexOutOfBoundsException miExcepcion=new ArrayIndexOutOfBoundsException(); //este error es no controlado y no hace falta lanzarlo con un try catch
			
			//throw new EOFException();
			
		}else {
				
		for( int i=0; i<mail.length();i++) {
			
			if(mail.charAt(i)=='@') {  //método charAt de String, devuelve la posicion dentro de la cadena
				arroba++;
				
			}
			
			if(mail.charAt(i)=='.') {
				
				punto=true;
			}
		
		}

		if(arroba==1 && punto==true) {
			
			System.out.println("El Mail es correcto.");
		
		}else {
			
			System.out.println("El Mail no es correcto.");
		}
		
	}
	}

}

class longitudEmailError extends Exception{ //construimos nuestro propio mensaje error
	
	public longitudEmailError() {} //le damos dos tipos de métodos, este sin argumentos y el siguiene con el parámetro msjError
	
	public longitudEmailError(String msjError) {
		
		super(msjError);
	}
	
	
	
	
}

