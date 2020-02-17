package execepciones_I;

import javax.swing.*;

public class VariasExcepciones_60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
