import javax.swing.*;

public class Factorial_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Long resultado=1L;
		
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un número: ")); //con parseInt de Integer transformamos el String de JOptionPane en int
		
		for (int i=numero;i>0;i--) {
			
			resultado*=i;
		}

		System.out.println("EL factorial de " + numero + " es " + resultado);
		
	}

}
