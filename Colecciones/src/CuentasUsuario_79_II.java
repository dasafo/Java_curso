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

/*****************************************Ejercicio Banco************************************* 
 * 
 * - Tenemos un Banco con 4 clientes, cada uno con un Nombre un Nº de Cuenta y un Saldo.
 * - Crearemos una colección donde almacenaremos a estos clientes.
 * - Pasos a seguir:
 * 		1- Crear una clase que contruya Clientes con sus características.
 * 		2- Crear una colección
 * 		3- Agregar objetos(clientes) a la colección
 * 		4- Recorrer la colección para ver los objetos
 * 
 ********************************************************************************************/


import java.util.*;

public class CuentasUsuario_79_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente_79_I cl1=new Cliente_79_I("Antonio Contreras", "0001", 200000);
		Cliente_79_I cl2=new Cliente_79_I("Maria Serbina", "0002", 250000);
		Cliente_79_I cl3=new Cliente_79_I("Alvaro Lapuerta", "0003", 300000);
		Cliente_79_I cl4=new Cliente_79_I("Bertin Osborne", "0004", 400000);
		Cliente_79_I cl5=new Cliente_79_I("Antonio Contreras", "0001", 200000); //mismo cliente que cl1

		// Usamos la colección I_Set ya que se ajusta a nuestro ejercicio
		// ya que no se pueden repetir objetos, podremos agregar o eliminar elementos
		Set <Cliente_79_I> clientesBanco=new HashSet<Cliente_79_I>();
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5); 

		
		/*for (Cliente_79_I cliente_79_I : clientesBanco) {
			
			System.out.println(cliente_79_I.getNombre() + " " 
			
					+ cliente_79_I.getnCuenta() + " " + cliente_79_I.getSaldo());
			
			if(cliente_79_I.getNombre().equals("Julio Iglesias")) { //para remover un objeto(veremos abajo que esto se hace mejor con iteradores)
				
				clientesBanco.remove(cliente_79_I);
			}
			
		}*/
		
		
		//-----------Mejor se elimina Julio Iglesias con un Iterator--------
		
		Iterator<Cliente_79_I> it=clientesBanco.iterator(); 
		
		while(it.hasNext()) { //mientras exista siguiente elemento(cosas que recorrer)
			
			String nombreCliente=it.next().getNombre();
			
			if(nombreCliente.equals("Julio Iglesias")){ //removemos Julio Iglesias
				
				it.remove();
			}
		}
		
		//------------------------------------------------------
		
		
		for (Cliente_79_I cliente_79_I : clientesBanco) {
			
			System.out.println(cliente_79_I.getNombre() + " " 
			
					+ cliente_79_I.getnCuenta() + " " + cliente_79_I.getSaldo());
			
		}
		
		
		//Ahora hacemos lo misma tarea que con el for-Each de arriba pero con iteradores(más complicado)
		
		/*Iterator<Cliente_79_I> it=clientesBanco.iterator();
		
		while(it.hasNext()) { //hasNext comprueba(true/false) si hay un objeto al que saltar con Next()
			
			String nombreCliente=it.next().getNombre(); //next() da un salto al siguiente 'hueco' de objetos, y así puede esturiar lo que hay en el objeto tiene detras(ananliza a toro pasado)
		
			System.out.println(nombreCliente);
			
			// String nCuenta=it.next().getnCuenta(); //esto nos daría el nCuenta del siguiente ya que aplicamos otra vez Next()(por eso en este caso es mejor usar el For-Each de antes) 
		
		}*/
		
		//----------------------------------------------------------------------------------------------
		
		

		
	}

}
