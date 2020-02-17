import javax.swing.*;

public class EntradaSalidaDatos_6_III {

	public static void main(String[] args) {
		
		double x=10000.0;
		
		System.out.printf("%1.2f",x/3); //Para redondear cifras decimales con printf("",) 
		
		
		
		
		String num1=JOptionPane.showInputDialog("Introduce un número: ");
		
		double num2=Double.parseDouble(num1); //convertimos en decimal el String de antes
		
		System.out.print("\n" + "La raiz de " + num2 + " es ");
		
		System.out.printf("%1.2f", Math.sqrt(num2));

	}

}
