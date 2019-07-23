package poo;

public class PruebasConEmpleados_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados trabajador1=new Empleados("Paco");
		Empleados trabajador2=new Empleados("Ana");
		Empleados trabajador3=new Empleados("Antonio");
		Empleados trabajador4=new Empleados("Maria");

		trabajador1.cambiaSeccion("RRHH");
	

		System.out.println(trabajador1.devuelveDatos() + "\n" + trabajador1.devuelveDatos() + "\n" + 
				trabajador2.devuelveDatos()+ "\n" + trabajador3.devuelveDatos() + 
				"\n" + trabajador4.devuelveDatos());
		
		System.out.println(Empleados.dameIDsiguiente());

	}

}



class Empleados{
	
	public Empleados(String nom) {	//Constructor(condiciones iniciales)
		
		nombre=nom;
		seccion="Administración";
		
		ID=IDsiguiente;
		IDsiguiente++;
		
	}
	
	public void cambiaSeccion(String seccion) {		//SETTER
		
		this.seccion=seccion;
		
	}
	
	public String devuelveDatos() {		//GETTER
		
		return "El nombre es: " + nombre + " y la sección es " + seccion + " y el ID= " + ID; 		
	}
	
	
	public static String dameIDsiguiente() {	//GETTER
		return "El ID siguiente es: " + IDsiguiente; //puede acceder a IDsiguiente porque esta es static, sino no podría acceder a una varibel de la clase
		
	}
	
	
	private final String nombre;		//Con 'final' nos aseguramos que la variable nombre asignada no cambia(constante)
	private String seccion;
	
	private int ID;		//Con static le decimos que esa variable es de la clase, y no de cada "trabajador"
	private static int IDsiguiente=1;
	
}