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


package arraylist;

public class ArrayList_71_I {

	public ArrayList_71_I(int z) {
		
		datosElemento=new Object[z];
	}

	public Object get(int i) {
		
		return datosElemento[i];
	
	}
	
	public void add(Object o) {
		
		datosElemento[i]=o;
		i++;
	}
	
	private Object[] datosElemento;
	private int i=0;
	
	
}
