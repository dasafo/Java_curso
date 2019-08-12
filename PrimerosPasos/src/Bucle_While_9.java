import javax.swing.*;

public class Bucle_While_9 {

	public static void main(String[] args) {
		
		String clave="David";
		
		String pass="";
		
		while (clave.equals(pass)==false) {
			
			pass=JOptionPane.showInputDialog("Introduce la contraseña: ");
			
			if(clave.equals(pass)==false) {
				
				System.out.println("Contraseña incorrecta");
				
			}
			
		}
		
		System.out.println("Contraseña correcta");

	}

}
