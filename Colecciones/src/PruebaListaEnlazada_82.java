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


/**************************Ejercicio Paises-Capitales***************************************
* Vamos a crear 2 LinkedList, una con Paises y otra con Capitales, para despues sobreponerlas,
* resultando al final una sola LinkedList
******************************************************************************************/ 

import java.util.*;

public class PruebaListaEnlazada_82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> paises=new LinkedList<String>();
		
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Peru");
		
		LinkedList<String> capitales=new LinkedList<String>();
		
		capitales.add("Madrid");
		capitales.add("Bogotá");
		capitales.add("DF");
		capitales.add("Lima");
		
		//System.out.println(paises);
		//System.out.println(capitales);
		
		
		//----Añadimos una lista a la otra (Pais-capital)-------------
		
		ListIterator<String> iterA=paises.listIterator(); //al crear el iterador por defecto se 'posiciona' delante de la lista
		ListIterator<String> iterB=capitales.listIterator();
		
		while(iterB.hasNext()) { //Mientras tengamos un elemento capital delante del iterador(hasNext()), haz...
			
			if(iterA.hasNext()) {  //si tambien hay un pais delante de la posicion del iterador, haz...
				
				iterA.next(); //Satla al siguiente elemento(hueco)
				
			}
			
			iterA.add(iterB.next());  //Me agregas a iterA el siguiente iterB (Pais(iterA)---Capital(iterB))
								      // Cuando salga del buble While el iterador(A y B) se encuentra al final de la lista
		}
		
		System.out.println(paises); //ahora iterA es iterA+iterB por lo que lo imprimimos

		iterB=capitales.listIterator(); //ponemos el iterador al principio de la lista B(capitales) otra vez
		
		while(iterB.hasNext()) { //queremos borrar las capitales en posiciones pares de nuestra lista B
			
			iterB.next();
			
			if(iterB.hasNext()) {
				
				iterB.next(); //nos colocamos delante de la posicion de la segunda capital (en la primera iteracion del bucle)
				iterB.remove(); //Borramos la capital de la posicion 2 en la priemera iteracion del bucle(luego la 4, luego la 6,...)
			}
		}
		
		System.out.println(capitales); //Comprobamos que hemos borrado las posiciones pares de nuestra lista capitales
		
		paises.removeAll(capitales); //borramos las capitales de nuestra lista paises(paises+capitales)
		System.out.println(paises);
		

		
	}

}
