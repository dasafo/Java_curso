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

import java.util.*;

public class UsoEmpleado_70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Empleado listaEmpleados[]=new Empleado[3];
		
		listaEmpleados[0]=new Empleado("Ana", 45, 2500);
		
		listaEmpleados[1]=new Empleado("Antonio", 55, 2000);
		
		listaEmpleados[2]=new Empleado("Maria", 25, 2600);*/
		
		ArrayList <Empleado> listaEmpleados=new ArrayList<Empleado>(); //ArrayList para que el Array vaya aumentando la matriz automaticamente
		
		// mlistaEmpleados.ensureCapacity(11); //ArrayList guarda 10 posiciones por defecto, si aumentamos de 10(11 por ejemplo), crea otras 11 posiciones más, 
														//con esto(ensureCapacity, destruimos las 10 primeras, y ahorramos memoria
	
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
		
		// listaEmpleados.trimToSize(); //cuando tenemos la matriz que quremos se usa esto para borrar la memoria anterior que gnerea ArrayList
		
		// listaEmpleados.add(new Empleado("Olga", 23, 2200)); 
		// listaEmpleados.set(1, new Empleado("Olga", 23, 2200)); //le decimos que esta entrada la queremos en la posición 1 gracias a set

		// System.out.println(listaEmpleados.get(4).dameDatos()); //nos devuelve la entrada que está en quinto lugar(4)

		// System.out.println(listaEmpleados.size());
		
		
		
		
		//1- Recorremos el ArrayList

		/*for(Empleado e: listaEmpleados) { //lo hacemos con un for each (por cambiar)
			
			System.out.println(e.dameDatos());
		}*/
		/*for(int i=0;i<listaEmpleados.size();i++) { //lo mismo que el foreach anterior pero con for normal
			
			Empleado e=listaEmpleados.get(i);
			
			System.out.println(e.dameDatos());
			
		}*/
		
		
		//2- También se puede hacer los mismo de arrriba pero con Iteradores
		
		Iterator <Empleado> miIterador=listaEmpleados.iterator();
		
		while(miIterador.hasNext()) {
			
			System.out.println(miIterador.next().dameDatos());
		}
		//------------------------------------------------------------------------
		
		
		//-----esto es lo mismo de arriba pero pasando el ListArray a un Array normal para trabajar con estos últimos-----
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



