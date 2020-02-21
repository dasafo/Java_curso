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

import java.util.*;

public class PruebaTreeSet_83_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*TreeSet<String> ordenaPersonas=new TreeSet<String>();
		
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");
		
		for(String s: ordenaPersonas) {
			
			System.out.println(s); //vemos que con TreeSet los String los ordena por orden alfabetico(String--->Comparable--->ComarableTo(verAPI))
		
		}*/
		
		
		//-----Ahora queremos ordenarolo segun el numero y no alfabeticamente(por defecto)-------------

		Articulo2 primero=new Articulo2(1, "Primer artículo");
		Articulo2 segundo=new Articulo2(2000, "Segundo artículo");
		Articulo2 tercer=new Articulo2(3, "Este es el Tercer artículo");
		
		
		TreeSet<Articulo2> ordenaArticulos=new TreeSet<Articulo2>();
		
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		
		for(Articulo2 art: ordenaArticulos) {
			
			System.out.println(art.getDescripcion()); //vemos que nos lo ordena por numero y no alfabeticamnete
		}

		System.out.println("------------------------------");
		
		//------------y después ordenado según el String(alfabeticamente)--------------------------------

		// Articulo2 comparadorArticulos=new Articulo2(); //como ARticulo le hemos dicho que tiene que dar 2 argumentos, creamos otro constructor Articulo vacio(public Articulo(){})

		// TreeSet<Articulo2> ordenaArticulos2=new TreeSet<Articulo2>(comparadorArticulos);
		
		// ComparadorArticulos comparaArt=new ComparadorArticulos();
		
		TreeSet<Articulo2> ordenaArticulos2=new TreeSet<Articulo2>(new Comparator<Articulo2>() {
				
			@Override
			public int compare(Articulo2 o1, Articulo2 o2) {
				// TODO Auto-generated method stub
				String desc1=o1.getDescripcion();
				String desc2=o2.getDescripcion();
				
				return desc1.compareTo(desc2);

			}
				
		});
		
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercer);
		
		for(Articulo2 art: ordenaArticulos2) {
			System.out.println(art.getDescripcion());
		}
		

	}
	//----------------------------------------------------------------------------------------
	
}



class Articulo2 implements Comparable<Articulo2>{
	
	
	public Articulo2(int num, String desc) {
		
		numeroArticulo=num;
		descripcion=desc;
		
	}

	@Override
	public int compareTo(Articulo2 o) {
		// TODO Auto-generated method stub
		return numeroArticulo - o.numeroArticulo; //restamos el numero de un ARticulo que da el contructor con otro(compara articulos para ordenarolos por numero y no alfabeticamente)
	}
	
	public String getDescripcion() {
		
		return descripcion;
	}
	
	
	
	private int numeroArticulo;
	private String descripcion;
	
	
}

