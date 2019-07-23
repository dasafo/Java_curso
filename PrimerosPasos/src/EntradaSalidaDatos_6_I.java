
import java.util.*;
public class EntradaSalidaDatos_6_I {

	public static void main(String[] args) {
		
		Scanner entrada=new Scanner(System.in); //scanner perteneciente a java.util
		
		
		System.out.println("Introduce tu nombre, por favor: ");

		String nombre_usuario=entrada.nextLine();  //nextLine de Scanner
		
		
		System.out.println("Introduce edad, por favor: ");
		
		int edad=entrada.nextInt();
		
		
		System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad+1) + " años.");
		
	}

}
