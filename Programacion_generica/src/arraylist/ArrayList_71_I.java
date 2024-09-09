/*************************************ArrayList******************************************
 * 
 * - Son listas dinamicas compuestas por Objetos.
 * 
 * - C_ ArrayList
 * 		->M_ iterator()
 * 			|
 * 			--> I_Iterator
 * 				---> M_hasNext() : Nos dice s hay mas elementos o no en el <ArrayList>
 *  		    ---> M_next() : Devuelve el siguiente elemento de la iteracion
 * 				---> M_remove() : Elimina el elemento que estemos mirando
 * 
 ****************************************************************************************/

/*
 * Para ver la importancia de la programacion generica, primero vamos a contruir 
 * manualmente nuestro propio ArrayList aqui, y haremos uso de el
 * en UsoArrayList_71_II.java
 *
 * */
package arraylist;

// Creamos nuestro ArrayList creado manualmente
public class ArrayList_71_I {

	public ArrayList_71_I(int z) {
		
		datosElemento=new Object[z]; //Un Array de tipo Object con z elementos
	}

  // Creamos get() que emula el get de un ArrayList de verdad
	public Object get(int i) {
		
		return datosElemento[i];
	
	}
	
  // Creamos add() que emula el metodo add() de un ArrayList de verdad
	public void add(Object o) {
		
		datosElemento[i]=o;
		i++;
	}
	
	private Object[] datosElemento; // Un Objeto de tipo Array
	private int i=0;
	
	
}
