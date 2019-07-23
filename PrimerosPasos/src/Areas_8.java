import java.util.*;
import javax.swing.*;

public class Areas_8 {

	public static void main(String[] args) {
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Circulo");

		int figura=entrada.nextInt();
		
		switch(figura) {
		
		case 1:
			
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado")); //metemos todo en Integer.parseInt(...) para convertir el String en int
			
			System.out.println("El área del cuadrado es " + Math.pow(lado, 2));
			
			break;
			
		case 2:
			
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base:")); //metemos todo en Integer.parseInt(...) para convertir el String en int
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura:"));
			
			System.out.println("El área del rectángulo es " + base*altura);
			
			break;
			
		case 3:
			
			 base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base:")); //metemos todo en Integer.parseInt(...) para convertir el String en int
			 altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura:"));
			
			System.out.println("El área del triángulo es " + (base*altura)/2);
			
			break;
		
			
		case 4:
			
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio:")); //metemos todo en Integer.parseInt(...) para convertir el String en int
			
			System.out.print("El área del círculo es ");
			
			System.out.printf("%1.2f", Math.PI*(Math.pow(radio,2)));
			
			break;
			
		default:
			System.out.println("La opción que has elegido no existe.");
			
		}
		
	}

}
