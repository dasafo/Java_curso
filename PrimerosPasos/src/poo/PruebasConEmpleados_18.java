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
		
		//Ponemos Empleados porque el metodo dameIDsiguiente() es static y hay que poner el nombre de la clase
		System.out.println(Empleados.dameIDsiguiente()); 

	}

}



class Empleados{
	
	public Empleados(String nom) {	//Metodo Constructor(condiciones iniciales y se llama siempre igual que la clase)
		
		nombre=nom;
		seccion="Administración";
		
		ID=IDsiguiente;
		IDsiguiente++;
		
	}
	
	public void cambiaSeccion(String seccion) {		//SETTER
		
		this.seccion=seccion; //this.seccion hace referecnia a la variable seccion asociada a esta clase y seccion al argumento de este metodo
		
	}
	
	public String devuelveDatos() {		//GETTER
		
		return "El nombre es: " + nombre + " y la sección es " + seccion + " y el ID= " + ID; 		
	}
	
	//Creamos un metodo(getter) static
	public static String dameIDsiguiente() {	//GETTER
		return "El ID siguiente es: " + IDsiguiente; //puede acceder a IDsiguiente porque esta es static, sino no podría acceder a una varibel de la clase
		
	}
	
	
	private final String nombre;		//Con 'final' nos aseguramos que la variable nombre asignada no cambia(ahora sería una constante)
	private String seccion;
	
	private int ID;		
	/*Con static le decimos que esa variable es de la clase, y no de cada "trabajador"
	sin static cada objeto/trabajador almacena su propia "lista" con nombre y seccion
	Con static le decimos que esta variable es compartida por todos los trabjadores(pertenece a la clase no a los objetos)*/
	private static int IDsiguiente=1;
	
}