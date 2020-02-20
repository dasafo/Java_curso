/*
 * La herencia entre clases genericas es diferente a las clases normales.
 * El principio de Sustitucion(ES UN..) no funcionaria con clases genericas, 
 * funcionaria si añadimos ? extends en la clase a la que se hace mencion:
 * 
 * Ej (ver el metodo imprimirTRabajador() de la clase Pareja_72):	
 * public static void imprimirTrabajador(Pareja_72<? extends Empleado_74_II> p) {...}

 */

package clases_propias;

public class HerenciaGenericos_75_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//------Herencia para clases normales---------------
		
		/*Empleado_74_II Administrativa=new Empleado_74_II("Elena", 45, 1500);
		
		Jefe_75_II DirectoraComercial=new Jefe_75_II("Ana", 27, 3500);
		
		Empleado_74_II nuevoEmpleado=DirectoraComercial; //Un jefe ES UN Empleado, por lo que lo podemos almacenar en Empleado
		*/
		
		//---------------------------------------------------
		
		//-------Herencia para clases Genericas----------------------
		Pareja_72<Empleado_74_II> Administrativa=new Pareja_72<Empleado_74_II>();
		
		Pareja_72<Jefe_75_II> DirectoraComercial=new Pareja_72<Jefe_75_II>();
		
		// Pareja_73<Empleado_74_II>nuevoEmpleado=DirectoraComercial; //el principio de Sustitucion(ES UN..) no funcionaria con clases genericas, funcionaria si añadimos ? extends en Pareja_73,

		Pareja_72.imprimirTrabajador(Administrativa); //funciona porque Administrativa es de tipo empleado, y ese metodo(imprimir trabajdor) me pide un metodo de tipo Empleado
		
		Pareja_72.imprimirTrabajador(DirectoraComercial); //No funcionaria sin ? extends en Pareja_72,  porque aqui la herencia no funciona con genericos(hay que usar tipos comodín

		//-------------------------------------------------------------
		
	}

}
