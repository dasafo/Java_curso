/**********************************************************************************************
 * + Las colecciones son almacenes de objetos dinámicos
 * + Las colecciones cambian de tamaño dinámicamente
 * + Pueden ir provistas de odenamiento
 * + Se pueden insertar y eliminar elementos
 * + NO puede almacenar datos primitivos como si hace un Array, pero si puede almacenar objetos.
 * 
 * + Las colecciones vienen determinadas por una serie de interfaces: 
 * 
 * <> I_Collection <> 
 * 
 *		-> I_Set: + Permite almacenar una coleccion de elementos no repetidos y sin ordenar
 *				  - No tiene acceso aleatorio
 *				  - Poca eficiencia a la hora de orndear elementos (si se puede)
 *   		--> I_SortedSet
 *   		--> C_HashSet
 *   		--> C_LinkedHashSet
 *   		--> C_TreeSet
 *   		--> C_EnumSet
 *   		--> C_CompyOnWriteArraySet
 *   		--> C_ConcurrentSkipListSet
 *   
 *   	-> I_List: + Pueden estar repetidos y estar indexados (con valores numricos).
 *       		   + Permite acceso aleatorio a sus posiciones
 *       		   + ListIterator modifica en cualquier dirección.
 *       		   + Sintaxis similar a los Array	
 *       		   - Bajo rendimiento
 *       	--> C_ArrayList
 *       	--> C_LinkedList
 *       	--> C_Vector
 *       	--> C_CopyOnWriteArrayList
 *   
 *   	-> I_Queue: + Rapido acceso al primer y último elemento 
 *   				+ Permite crear colas de elementos muy eficientes
 *   				-No permite acceso aleatorio. Solo permite acceder a elementos
 *       			 que se encuentren al principio o al final.
 *       	--> C_ArrayDeque
 *       	--> C_LinkedBlockingDeque
 *       	--> C_LinkedList
 *       	--> C_PriorityQueue
 *       	--> C_PriorityBlockingQueue
 * 
 * - I_Map: + Permite crear una coleccion de elementos repetibles indexados por
 *       	  clave unica arbitraria (no solo numeros para acceder a su Clave
 *       	  como en las List, tambien podemos acceder a su Clave mediante Strings).
 *			- Poca eficiencia
 *   	-> I_SortedMap
 *   	-> C_HashMap
 *   	-> C_LinkedHashMap
 *   	-> C_TreeMap
 *   	-> C_EnumMap
 *   	-> C_WeakHashMap
 *   	-> C_HashTable
 *   	-> C_ConcurrentHashMap
 *   
 * - I_Iterator: Construye un objeto que recorre una coleccion elemento a elemento
 * 				 una coleccion de objetos.
 * 		-> M_next() : salta a la siguiente objeto/elemento de la coleccion, y examina el elemnto saltado
 * 		-> M_hasnext : Nos dice si hay un objeto/elemento en la siguiente posicion de la coleccion (T/F)
 * 		-> M_remove() : Elimina objetos/elementos de la coleccion
 *   
 **********************************************************************************************  
 * Las Interfaces y sus clases asociadas al detalle estan en los archivos de 
 * pildorasinformaticas de JAva en la carpeta Colecciones/ColeccionesInfo
 *********************************************************************************************/

/***********************************El hashCode*****************************************
* 
* El HASHCODE es el codigo de la memoria interna (Heap: memoria "largo plazo") que asocia
* a un objeto creado. La referencia/puntero a dicho objeto se encuentra en la memoria Stack
* (memoria corta).  
* Ej: Libro libro1=new Libro()
* 		1- En la memoria Heap se crea el Objeto Libro con un hashCode único.
* 		2- En Stack se crea la referencia libro1 que apunta a ese objeto Libro en Heap
* 		3- Si tuvieramos dos referencias iguales (libro1=libro2), ambas apuntarian al mismo sitio
* 
*********************************************************************************************/

// Los LinkedList son mas eficientes si queremos usar colecciones en los cuales vamos a borrar
// y añadir objetos constantemente, sino podremos usar simplemente un ArrayList.

import java.util.*;

public class PruebaLinkedList_81 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> personas=new LinkedList<String>();
		
		personas.add("Pepe");
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		
		System.out.println(personas.size()); //que imprima los elementos que hay en la lista LinkedList


		ListIterator<String> it=personas.listIterator(); //listIterator que hereda de Iterator nos deja hacer más cosas
		
		it.next(); //ahora nos situamos entre la posicion 0 y la 1
		
		it.add("David"); //así situamos a David en la segunda posicion
		
		
		for(String persona : personas) {
			
			System.out.println(persona);
		}
		
		
		
	}

}
