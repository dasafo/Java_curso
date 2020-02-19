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

import javax.swing.*;

public class VariasExcepciones_60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * HAcemos un try-catch para que caputre varios errores
		 */
		try {
		division();
		}catch(ArithmeticException e) {
			
			System.out.println("No se permite dividir por cero");
		
		}catch(NumberFormatException e) { 
			
			System.out.println("No has introducido un numero entero");
		
			//System.out.println(e.getMessage()); 
			
			System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName()); //nos informa del tipo del error

		}
	
		}
	
	static void division() {
		
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));

		System.out.println("El resultado es: " + num1/num2);
	}

}
