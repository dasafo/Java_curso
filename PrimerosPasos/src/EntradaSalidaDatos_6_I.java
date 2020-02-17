
import java.util.*;
public class EntradaSalidaDatos_6_I {

	public static void main(String[] args) {
		
		/*
	    creamos un objeto(instanciar/ejemplarizar) llamado 'entrada' perteneciente a Scanner en (java.util)
		a la cual le damos la funcion de guardar lo que le entra por sistema (System.in...de Scanner) 
		*/
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce tu nombre, por favor: ");

		/*
		 nextLine de Scanner, al NO ser estático NO hace falta poner Scanner.nextLine()
		 Pero en cambio, esto implica que hay que crear un objeto(instanciar/ejemplarizar) de la clase Scanner delante del método (entrada)
		Entonces se pondra ese objeto y luego el metodo nextLine (entrada.nextLine() 
		*/
		String nombre_usuario=entrada.nextLine();
		
		System.out.println("Introduce edad, por favor: ");
		
		int edad=entrada.nextInt();
		
		
		System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad+1) + " años.");
		
	}

}
