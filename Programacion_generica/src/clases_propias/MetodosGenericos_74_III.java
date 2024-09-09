package clases_propias;

import java.util.GregorianCalendar;

public class MetodosGenericos_74_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombres[]= {"Jose", "María", "Pepe"};
		
		System.out.println(misMatrices2.getMenor(nombres));//como el metdodo getMenor es statico tenemos q usar el nombre de la calse primero que es misMatrices

		
    // Ahora vamos a ver (como se explica abajo a la hora de definir el metodo
    // misMatrices2), que al no haber implementado en Empleado_74_II la interfaz
    // de Comparable, esto nos da error.
		/*Empleado_74_II paco=new Empleado_74_II("Paco", 45, 2555);
		Empleado_74_II ana=new Empleado_74_II("Ana", 45, 2555);
		Empleado_74_II maria=new Empleado_74_II("María", 45, 2555);
		
		Empleado_74_II misEmpleados[]= {paco, ana, maria};

		System.out.println(misMatrices2.getMenor(misEmpleados)); // esto da error
    */
		
    // Ahora vemos lo contario, como GregorianCalendar si que implementa la interfaz
    // Comparable, no da error
		GregorianCalendar fechas[]= {
				
				new GregorianCalendar(2018,10,15),
				new GregorianCalendar(2018,5,15),
				new GregorianCalendar(2018,4,15),
		};
		
		System.out.println(misMatrices2.getMenor(fechas));


		}
		
		
	}



class misMatrices2 {
	
	//implmentamos la interfaz Comparable para poder usar compareTo()
  //este metodo Comarableto compara un objeto con otro y lo ordena devolviendo un numero
  //que indica que indica si el valor comparado es igual, menor o mayor
	public static <T extends Comparable> T getMenor(T[]a) { //como no sabemos que tipo de Array=a recibirá lo dejamos genérico (T)
		/*
     * - Public: para que sea accesible desde otras clases
     * - Static: para comvertirlo en un metodo de clase y asi no necesitar una instancia 
     *   perteneciente a la clase misMatrices para usar este metodo getElementos()
     * - <T extends Comparable>: compareTo() pertenece a la interfaz Comparable
     *   por ello hay que hacer la extension(OJO con extends no implements)
     * - T: Indica el tipo de dato que devuelve un dato generico(String, Date, Empleado,..)
     * - (T[]a): el metodo devulve un Array de tipo generico y la 'a' es la variable
     *
     * El extends que se hace con la interfz comparable no haría falta si fuera de tipo 
     * String, Date o GCalendar porque estas ya implementan esa interfaz, pero tendriamos
     * problemas si usamos de otro tipo como por ejemplo Empleado, a la hora de 
     * implementar dicha clase tendriamos que implementar esa interfaz.
    */
		

		if(a==null || a.length==0)	{
	
			return null;
		}
		
		T elementoMenor=a[0]; //alacenamos el elemento menor en la posicion 0 del array
    // esta varibale elementoMenor es de tipo generico
		
		for(int i=1; i<a.length; i++) { //comparamos los siguientes elementos(compareTo()) con el anterior para que al salir nos indique el elemento menor de todo el Array
			
			if(elementoMenor.compareTo(a[i])>0) {
				
				elementoMenor=a[i];
			}
		}
		
		return elementoMenor;
	
	}

	
}
