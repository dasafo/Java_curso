package execepciones_I;

import java.util.*;

import javax.swing.JOptionPane;

public class AreasPeso_61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Elige una opción: \n1: Cuandrado \n2: REctángulo \n3: TRiángulo \n4: Círculo");
		
		
		try {
		figura=entrada.nextInt(); //almacena un entero(en nuestro caso deberá ser 1,2,3 o 4)
		
		//entrada.close(); //cerramos System.in
		
		}catch(Exception e){
			
			System.out.println("Error");

		}finally {
			
		 entrada.close(); //metiendolo en finnaly no aseguramos que se ejecute siempre esto
		}
		
		switch (figura) {
		
		case 1:
			
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce lado"));
			
			System.out.println(Math.pow(lado, 2));
			
			break;
			
		case 2:
			
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));

			System.out.println("El área del rectángulo es " + base*altura);
			
			break;
			
		case 3:
			
			base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));

			System.out.println("El área del triángulo es " + (base*altura)/2);
			
			break;
			
		case 4:
			
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
			
			System.out.println("El área del círculo es ");
			System.out.println(Math.PI*(Math.pow(radio, 2)));

			break;
			
		default:
			System.out.println("La opción no es correcta");

		}
		
//---------------------------------------------------------------
		
		
		int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
		System.out.println("Si eres hombre tu peso ideal es: " + (altura-110) + " Kg");
		System.out.println("Si eres mujer tu peso ideal es: " + (altura-120) + " Kg");
		
	}

	static int figura;
	
}
