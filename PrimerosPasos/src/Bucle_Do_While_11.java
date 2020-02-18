import javax.swing.*;

public class Bucle_Do_While_11 {

	public static void main(String[] args) {
		
		String genero="";
		
		do {
			
			genero=JOptionPane.showInputDialog("Introduce tu género (H/M): ");
			
		}while(genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false);//equalsIgnoreCase para que no diferencie entre mayúsculas y minúsculas

		int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura en cm: "));
		
		int pesoIdeal=0;
		
		if(genero.equalsIgnoreCase("H")) {
			
			pesoIdeal=altura-110;
		}
		
		else if (genero.equalsIgnoreCase("M")) {
			
			pesoIdeal=altura-120;
		}
		System.out.println("Tu peso ideal es " + pesoIdeal);
	}
	

}
