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
		
		String elementos=misMatrices.getElementos(nombres);
		
		System.out.println(elementos);
		
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
	
	// Creamos un metodo genérico
	
	public static <T> String getElementos(T[]a) { //como no sabemos que tipo de Array=a recibirá lo dejamos genérico (T)
		
		return "El Array tiene " + a.length + " elementos.";
	}
	
}
