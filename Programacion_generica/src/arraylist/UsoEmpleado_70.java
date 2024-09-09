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

/* Si usamos un Array simple como 'Empleado listaEmpleados[]=new Empleado[3]', tenemos
// que indicar siempre cuantos elementos tendra este array y ademas, siempre
// tendra que ser el mismo tipo de objetos (pej. Empleados), lo cual es incomodo
// porque en muchas ocasiones no sabremos cuantos elementos tendrá este Array o querremos
// alamacenar diferentes tipos de objetos.
// Por eso existe el ArrayList, ahi no tenemos que debinir los elementos
*/

package arraylist;

import java.util.*;

public class UsoEmpleado_70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Empleado listaEmpleados[]=new Empleado[3];
		
		listaEmpleados[0]=new Empleado("Ana", 45, 2500);
		
		listaEmpleados[1]=new Empleado("Antonio", 55, 2000);
		
		listaEmpleados[2]=new Empleado("Maria", 25, 2600);*/
		
		ArrayList <Empleado> listaEmpleados=new ArrayList<Empleado>(); //ArrayList para que el Array vaya aumentando la matriz automaticamente
		
    //ArrayList guarda 10 posiciones por defecto, si aumentamos de 10(11 por ejemplo),
    //crea otras 11 posiciones más, con esto(ensureCapacity, destruimos las 10
    //primeras, y ahorramos memoria. Pero entonces tenemos el mismop problema que con 
    //un Array normal, en algun momento tenemos q indicarle cuantos elementos tenemos,
    //y esto sigue siendo incomod
	//mlistaEmpleados.ensureCapacity(11);

	// Para añadir elementos a un ArrayList se usa el metodo de este add()
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		
    // cuando tenemos la matriz que quremos se usa esto para borrar la
    // memoria anterior que gnerea ArrayList. Es decir conforme vamos añadiendo
    // elementos al ArrayList, Java va añadiendo mas espacio en memoria por si
    // quisieramos añadir mas elementos, con el metodo trimToSize(), elimina este
    // exceso de memoria vacio en el momento que sabemos que ya no vamos a añadir 
    // mas elementos al ArrayList. Pero una vez mas, si añadiesemos mas elementos despues
    // de este trimToSize() JAva volveria a añadir espacio en memoria, por lo tanto
    // tampoco hemos avanzado mucho.
	//listaEmpleados.trimToSize(); 	
    
		// listaEmpleados.add(new Empleado("Olga", 23, 2200)); 
		// listaEmpleados.set(1, new Empleado("Olga", 23, 2200)); //le decimos que esta entrada la queremos en la posición 1 gracias a set

		// System.out.println(listaEmpleados.get(4).dameDatos()); //nos devuelve la entrada que está en quinto lugar(4)

    // Usamos el metodo de ArrayList llamado siz() para saber el numero de elementos almacenados en el ArrayList
		// System.out.println(listaEmpleados.size());
		
		
		
		
		//1- Recorremos el ArrayList
    
    //USamos un FOR EACH para recorrer el ArrayList
		/*for(Empleado e: listaEmpleados) { 
			
			System.out.println(e.dameDatos());
		}*/


    // Ahora podemos usar tambien un for normal para recorrer el ArrayList,
    // PEro tenemos que tener en cuenta que en un ArrayList no hay indices, por los
    // tanto no podremos usar length, sino size(), hacerlo así:
		/*for(int i=0;i<listaEmpleados.size();i++) { //lo mismo que el foreach anterior pero con for normal
			
			Empleado e=listaEmpleados.get(i);
			
			System.out.println(e.dameDatos());
			
		}*/
		
		
		//2- También se puede hacer los mismo de arriba pero con Iteradores, la clase
    // Iteratori tiene 3 metodos, hasNext(), next() y remove(), de esta forma no usamos
    // ni un iterador for ni un for each
		
		Iterator <Empleado> miIterador=listaEmpleados.iterator();
		
		while(miIterador.hasNext()) {
			
			System.out.println(miIterador.next().dameDatos());
		}
		//------------------------------------------------------------------------
		
		
		// Si quremos usar length() como si fuera un Array normal, se podría hacer
    // esto, es lo mismo de arriba pero pasando el ListArray a un Array normal para
    // trabajar con estos últimos.
		/*Empleado arrayEmpleados[]=new Empleado[listaEmpleados.size()];
		
		listaEmpleados.toArray(arrayEmpleados);
		
		for(int i=0;i<arrayEmpleados.length;i++) {
			
			System.out.println(arrayEmpleados[i].dameDatos());
		}*/
		//-------------------------------------------------------------------------------------------------
		
	}

	
}


class Empleado{
	
	public Empleado(String nombre, int edad, double salario) {
		
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
		
	}
	
	public String dameDatos() {
		
		return "El empleado se llama " + nombre + ". Tiene " + edad + " años." + " Y un salario de " + salario;
	}
	
	private String nombre;
	private int edad;
	private double salario;
}



