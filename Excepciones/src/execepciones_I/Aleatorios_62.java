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

public class Aleatorios_62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	 int elementos=Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz:"));

	 int numAleat[]=new int[elementos];
	 
	 for(int i=0; i<numAleat.length; i++) {
		 
		 numAleat[i]=(int)(Math.random()*100);
	 }
	 
	 for(int elem: numAleat) {
		 
		 System.out.println(elem);
	 }
	 
	 
	}

}
