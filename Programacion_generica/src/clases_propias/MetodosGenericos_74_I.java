/*
 * Aqui veremos como podemos crear también metodos genericos (no hacen
 * falta que este dentro de clases genericas). Y ver como estos metodos
 * cambian según el objeto al que le hagamos referencia.
 */

package clases_propias;

public class MetodosGenericos_74_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombres[]= {"Jose", "María", "Pepe"};
		
		String elementos=misMatrices.getElementos(nombres); //como el metdodo getElementos es statico tenemos q usar el nombre de la calse primero que es misMatrices
		
		System.out.println(elementos);
		
    // Ahora vamos a hacerlo con un Array de tipo Empleado_74_II
		Empleado_74_II listaEmpleados[]= {
				
				new Empleado_74_II("Ana",45,2055),
				new Empleado_74_II("Ana",45,2055),
				new Empleado_74_II("Ana",45,2055),
				new Empleado_74_II("Ana",45,2055),
				
		};
				
		System.out.println(misMatrices.getElementos(listaEmpleados));
				
		}
		
		
	}



class misMatrices {
	
	// Creamos un metodo genérico q nos devuelva la longitud del Array
	
	public static <T> String getElementos(T[]a) { //como no sabemos que tipo de Array=a recibirá lo dejamos genérico (T)
    /*
     * - Public: para que sea accesible desde otras clases
     * - Static: para comvertirlo en un metodo de clase y asi no necesitar una instancia 
     *   perteneciente a la clase misMatrices para usar este metodo getElementos()
     * - <T>: A la hora de definir metodos genericos le decimos q es generico con <T>
     * - String: Indica el tipo de dato que devuelve
     * - (T[]a): el metodo devulve un Array de tipo generico y la 'a' es la variable
    */
		
		return "El Array tiene " + a.length + " elementos.";
	}
	
}
