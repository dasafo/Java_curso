/*
 * Las clases genericas se van adaptando a los objetos
 * Aqui crearemos una clase generica con <>, y en el siguiente
 * programa 73 veremos como esta se adapta a diferentes objetos
 */

package clases_propias;

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
	
	private T primero;

}
