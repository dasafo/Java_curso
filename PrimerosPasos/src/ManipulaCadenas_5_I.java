
public class ManipulaCadenas_5_I {

	public static void main(String[] args) {
		
		//String es una clase, por eso debemos instanciar/ejemplarizar la variable que queramos usar como string
		String nombre="David";
		
		System.out.println("Mi nombre es " + nombre);

		System.out.println("Mi nombre tiene " + nombre.length() + " letras.");
		
		//Para que saque la letra en la posicion 3 (0,1,2) con charAt
		System.out.println("La tercera letra de " + nombre + " es la '" + nombre.charAt(2) + "'");
	
		int ultima_letra;
		
		ultima_letra=nombre.length();
		
		System.out.println("Y la última letra es la '" + nombre.charAt(ultima_letra-1) + "'");
	
	}

}
