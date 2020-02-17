import javax.swing.JOptionPane;

public class CompruebaEMail_13 {

	public static void main(String[] args) {
		
		int arroba=0;
		
		boolean punto=false;
		
		String mail=JOptionPane.showInputDialog("Introduce el Mail: ");
		
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
		}
		else {
			System.out.println("El Mail no es correcto.");
		}
		
	}

}
