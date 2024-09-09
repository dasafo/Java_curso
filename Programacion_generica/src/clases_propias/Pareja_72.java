/*
 * Las clases genericas se van adaptando a los objetos
 * Aqui crearemos una clase generica con <>, y en el siguiente
 * programa 73 veremos como esta se adapta a diferentes objetos
 */

package clases_propias;

// Creamos una clase generica, al usar <T> o <U> o <K>(da igual) este ArrayList 
// puede ser definido inicialmente de cualquier objeto (String, Empleado, Jefe,....)
public class Pareja_72<T> {  //creamos una clase genérica
	
	public Pareja_72() {
		
		primero=null;
		
	}
	
	public void setPrimero(T nuevoValor) {
		
		primero=nuevoValor;
	}
	
	//----clase para herencias genericas (ver HerenciaGenericos_57_I)
	public static void imprimirTrabajador(Pareja_72<? extends Empleado_74_II> p) { //sino añadimos ? extends en HerenciaGenericos_75_I da problema con las herencias
		
		Empleado_74_II primero=p.getPrimero();
		
		System.out.println(primero);
	}
	
	
	public T getPrimero() {
		
		return primero;
	}
	
	private T primero; //variable de tipo generica T

}
