import javax.swing.*;

public class EntradaSalidaDatos_6_II {

	public static void main(String[] args) {
		
		String nombre_usuario=JOptionPane.showInputDialog("Introduce tu nombre por favor: ");
		
		String edad=JOptionPane.showInputDialog("Introduce tu edad por favor: ");
		
		
		int edad_usuario=Integer.parseInt(edad); //Almacenamos como entero la edad con Integer.parseInt(), ya que con JOptionPane solo acpeta Strings
		
		System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad_usuario+1) + " años.");
		

	}

}
