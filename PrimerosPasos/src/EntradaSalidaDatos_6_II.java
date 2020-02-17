import javax.swing.*;

public class EntradaSalidaDatos_6_II {

	public static void main(String[] args) {
		
		/*
		Al ser el método showInputDialog static, se pone el nombre de su clase delante
		Recordar tambien que el argumento elegido para este metodo es un Object(ver API) que lo ponemos como
		String, que en este caso no es un tipo de dato, sino un objeto perteneciente a la clase String
		*/
		String nombre_usuario=JOptionPane.showInputDialog("Introduce tu nombre por favor: ");
		
		String edad=JOptionPane.showInputDialog("Introduce tu edad por favor: ");
		
		
	//Almacenamos como int la edad con Integer.parseInt(), ya que con JOptionPane devuelve Strings
		int edad_usuario=Integer.parseInt(edad);
		
		System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad_usuario+1) + " años.");
		

	}

}
