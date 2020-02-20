package clases_propias;

import java.util.GregorianCalendar;

public class MetodosGenericos_74_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombres[]= {"Jose", "María", "Pepe"};
		
		System.out.println(misMatrices2.getMenor(nombres));
		
		/*Empleado_74_II paco=new Empleado_74_II("Paco", 45, 2555);
		Empleado_74_II ana=new Empleado_74_II("Ana", 45, 2555);
		Empleado_74_II maria=new Empleado_74_II("María", 45, 2555);
		
		Empleado_74_II misEmpleados[]= {paco, ana, maria};

		System.out.println(misMatrices2.getMenor(misEmpleados));*/
		
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
	public static <T extends Comparable> T getMenor(T[]a) { //como no sabemos que tipo de Array=a recibirá lo dejamos genérico (T)
		
		if(a==null || a.length==0)	{
	
			return null;
		}
		
		T elementoMenor=a[0]; //alacenamos el elemento menor en la posicion 0 del array
		
		for(int i=1; i<a.length; i++) { //comparamos los siguientes elementos(compareTo()) con el anterior para que al salir nos indique el elemento menor de todo el Array
			
			if(elementoMenor.compareTo(a[i])>0) {
				
				elementoMenor=a[i];
			}
		}
		
		return elementoMenor;
	
	}
	
}
