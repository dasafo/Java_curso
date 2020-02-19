/**************************************Jerarquía de errores*************************************
 * 
 * -En tiempo de compilación: Errores de sintaxis del programador (falta ;, falta llave,...)
 * -En tiempo de ejecución:
 * 		-> C_Throwable (es la (super)clase que maneja los errores en Java)
 *			--> C_Error (errores de HArdware (poco espacio en en el PC,...))
 *			--> C_Exception:
 *				---> C_IOException: 
 *								Excepciones comprobadas, no son culpa del programador, 
 *								y estamosobligados a caputarlas con un try-catch.
 *								(Alguien ha movido una imagen de una carpeta,...)
 *				---> C_RuntimeException 
 *								Excepciones NO comprobadas, culpa del programador y no estamos
 *								obligados a caputarlas, esto queda a merced del programador.
 * 								(Tamaño del array erróneo,...)
 *  
 *  -throws: Se usa para indicar a un metodo que va a lanzar un error (que se debe o no capturar)
 *  		 Ej: static void metodo() throws NombreDeLaExcepcion{..}			
 *  -throw: (SIN S) Se usa en cualquier parte del codigo para indicar que en ese punto se 
 *  		lanza una excepcion

 * C=Clase
 ***********************************************************************************************/


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
	
	// static void examinaMail(String mail) throws EOFException { //si ponemos un EOFException que hereda de IOEXception estamos obligaod a poner un try-catch
	static void examinaMail(String mail) throws longitudEmailError{  //lanzamos nuestro error(creado abajo del todo
	
		int arroba=0;
		
		boolean punto=false;
		
		//lanzamos manualmente una excepcion (por ej ArrayIndexOutOfBoundsException)
		//cuando se introduzca 3 carácteres o menos en el nombre del email
		if(mail.length()<=3) { 
			
			throw new longitudEmailError("El Email es muy corto."); //lanzamos el error con THROW
			
			// ArrayIndexOutOfBoundsException miExcepcion=new ArrayIndexOutOfBoundsException(); //este error es no controlado y no hace falta lanzarlo con un try catch
			// throw miExcepcion; //lanzamos el error con THROW
			// throw new ArrayIndexOutOfBoundsException(); //esto es lo mismo que las dos lineas superiores
			
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

