package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona[] lasPersonas=new Persona[2];
		
		lasPersonas[0]=new Empleado2("Luis Conde", 50000, 2009, 02, 25);
		lasPersonas[1]=new Alumno("Ana Lopez","Biológicas");
		
		for(Persona p: lasPersonas) {
			
			System.out.println(p.dameNombre() + ", " + p.dameDescripcion());
		}
		
	}

}

/*
- Un metodo abstacto es un metodo que se usará en los hijos, pero cada
hijo le dará un uso diferente, por eso se declara vacio en el padre.
- Si tenemos un solo metodo abstracto, la clase padre debe ser abstracta también.
- Un metodo abstracto en una clase padre no tienen contenido,
dicho contenido se les da en las clases hijas.
- Una clase abstracta no se puede instanciar
*/


/*-------------------------------------------------------------------
---------------------------- PERSONA ---------------------------------
-------------------------------------------------------------------*/

abstract class Persona{		//Abstract porque será la clase de cuya clase irán las diferentes ramas de la herencia(subclases) que no están conectadas entre ellas.

	public Persona(String nom) {			//Contructor
		
		nombre=nom;
	}
	
	public String dameNombre() {		//GETTER
		return nombre;
		
	}
	
	public abstract String dameDescripcion(); //ENcapsulamiento. Simpre que el objeto sea abstract la clase también debe ser abstract
	
	private String nombre; 
	
}

/*-------------------------------------------------------------------
---------------------------- EMPLEADO2 ---------------------------------
-------------------------------------------------------------------*/

class Empleado2 extends Persona{		//realizamos la herencia a la clase abstract Persona. Esta clase no estará conectada con Alumno
	
	public Empleado2(String nom, double sue, int agno, int mes, int dia) { //Constructor, que asigan valores iniciales 
		//y tiene que tener el mismo nombre de la clase a la que pertenece (Empleado2) 
	
		super(nom); //Invocamos al constructor de la clase padre(Persona)
		sueldo=sue;
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1, dia);
		altaContrato=calendario.getTime();
		
		++IDsiguiente;
		ID=IDsiguiente;
		
	}
	
	public String dameDescripcion() {		//Metodo abstracto de Persona que debemos implementar
		
		return "Este empelado tiene un ID= " + ID + " con un sueldo= " + sueldo;
	}
	
	public double dameSueldo() { 	//GETTER
		
		return sueldo;
	}
	
	public Date dameFechaContrato() {	//GETTER
		
		return altaContrato;
	}
	
	
	public void subeSueldo(double porcentaje) {		//SETTER
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
	}
	
	
	private double sueldo;			//Encapsulamiento
	private Date altaContrato;
	private static int IDsiguiente;
	private int ID;
	
}


/*-------------------------------------------------------------------
---------------------------- ALUMNO ---------------------------------
-------------------------------------------------------------------*/
class Alumno extends Persona{ //Realizamos herencia con PErsona(Abstract), y por lo tanto no conectada con Empleado2
	
	public Alumno(String nom, String car) {		//Constructor(Tiene que tener el mismo nombre que la clase)
		
		super(nom);		//Invocamos con super al constructor de la clase padre(abstracta)
		carrera=car;
		
	}
	
	public String dameDescripcion() {		//Metodo abstracto de Persona que debemos implmentar
			
		return "Este alumno está estudiando la carrera de " + carrera;
	}
		
	private String carrera;		//Encapsulamiento
		
	
}

