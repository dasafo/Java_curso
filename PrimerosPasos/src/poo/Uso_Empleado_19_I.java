package poo;
import java.util.*;

public class Uso_Empleado_19_I{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Empleado empleado1=new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		Empleado empleado2=new Empleado("Ana López", 95000, 1995, 06, 02);
		Empleado empleado3=new Empleado("María Martín", 105000, 2002, 03, 15);

		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		System.out.println("Nombre: " + empleado1.dameNombre() + " Sueldo: " + empleado1.dameSueldo()
				+ " Fecha de Alta: " + empleado1.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado2.dameNombre() + " Sueldo: " + empleado2.dameSueldo()
		+ " Fecha de Alta: " + empleado2.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado3.dameNombre() + " Sueldo: " + empleado3.dameSueldo()
		+ " Fecha de Alta: " + empleado3.dameFechaContrato());*/
		
		Jefatura jefe_RRHH=new Jefatura("Juan", 55000, 2006, 9, 25); //principio de sustitución
		
		jefe_RRHH.estableceIncentivo(2570);
		
		Empleado[] misEmpleados=new Empleado[6];
		
		misEmpleados[0]=new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		misEmpleados[1]=new Empleado("Ana López", 95000, 1995, 06, 02);
		misEmpleados[2]=new Empleado("María Martín", 105000, 2002, 03, 15);
		
		misEmpleados[3]=new Empleado("Antonio Fernández"); //Este pertenecería al otro Constructor Empleado
		
		misEmpleados[4]=jefe_RRHH;  //Polimorfismo en acción(objeto de la subclase(jefatura) cuando espera una de la superclase(Empleado)
		misEmpleados[5]=new Jefatura("Maria", 95000,1995, 03, 26);

		Jefatura jefa_finanzas=(Jefatura) misEmpleados[5]; //REfundición o Casting. Pasamos misEmpleados[5] del objeto Empleado a JEfatura
		
		
		jefa_finanzas.estableceIncentivo(55000); //ahora le podemos aplicar estableceIncentivo() al pertenecer a Jefatura
		
		System.out.println("El jefe " + jefa_finanzas.dameNombre() + " tiene un bonus de " + jefa_finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de " + misEmpleados[3].establece_bonus(200));

		
		
		//Para ver que podemos usar instanceof para que nos diga si una instancia pertenece a una clase o una interfaz:
		
		/* Empleado director_comercial=new Jefatura("Sandra", 85000, 2012, 05, 05);
	       Comparable ejemplo=new Empleado("Elisa", 95000, 2011, 06, 07);
		
		if(director_comercial instanceof Empleado) {		//instanceof para comprobar si pertenece a la clase Empleado
			
			System.out.println("Es un tipo Jefatura");
		}
		
		if(ejemplo instanceof Comparable) {		//instanceof para comprobar si pertenece a la interfaz de Jefatura, Comparable
			System.out.println("Implementa la interfaz Comparable");
		} */
		
		
		
		System.out.println(jefa_finanzas.tomar_decisiones("Dar más días de vacaciones a los empleados"));
		
		/*for(int i=0;i<3; i++) {
			
			misEmpleados[i].subeSueldo(5);
		}*/
		
		for(Empleado e: misEmpleados) {
			
			e.subeSueldo(5);
		}
		
		
		
		/*for(int i=0; i<3; i++) {
			
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() 
				+ " Sueldo: " + misEmpleados[i].dameSueldo()
				+ " Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
		}*/
		
		
	/*Definimos el método sort de la clase Arrays (debemos implementar la interfaz Comparable en Empleado), 
	y añadir el método compareTo(ver API). Esto ordena los empledados segun su sueldo*/
		Arrays.sort(misEmpleados);		
		
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre: " + e.dameNombre() 
					+ " Sueldo: " + e.dameSueldo()  	//aqui cuando llegue a Juan tomará el de Jefatura(ENlazado dinamico)
					+ " Fecha de Alta: " + e.dameFechaContrato());
			
		}
		
	}

}


//******************************* Clases y metodos ****************************************************

/*Con implements asociamos la interfaz comparable y trabajadores, y estamos obligados a
 * implementar todos los metodos de las interfaces implementadas*/
class Empleado implements Comparable, Trabajadores_19_II {   
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) { //Constructor, que asigan valores iniciales 
		//y tiene que tener el mismo nombre de la clase a la que pertenece (Empleado) 
	
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1, dia); //mes-1 ya que Enero es el 0, así sería enero=1
		altaContrato=calendario.getTime(); //getTime es un metodo de Calendar(de donde heredamos GregorianCalendar)
		
		++IDsiguiente;
		ID=IDsiguiente;
	
	}
	
	
	public double establece_bonus(double gratificacion) { 
		
		return Trabajadores_19_II.BONUS_BASE + gratificacion;
	}
	
	
	//Otro constructor(sobrecarga de constructores)(diferentes argumetnos para cada constructor) 
	public Empleado(String nom) { 
		
		this(nom, 3000, 2000, 01, 01); //Con este This llamamos al otro constructor y pasarle los parámetros
		
	}
	
	
	public String dameNombre() {  	//GETTER
		
		return nombre + " ID: " + ID;
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
	
	public int compareTo(Object miObjeto) {		//declaramos la varibale de la interfaz Comparable(ver API) para ordenar por sueldo, ID,...
		
		Empleado otroEmpleado=(Empleado) miObjeto;  //refundimos(castin) para crear la variable otroEmpleado dentro como Empleado.
		
		if(this.sueldo<otroEmpleado.sueldo) {
			
			return -1;
		}
		
		if(this.sueldo>otroEmpleado.sueldo) {
			
			return 1;
		}
		
		return 0;
		
	}
	
	//encapsulamos estas variables para que no puedan ser modificadas desde fuera de la clase
	private String nombre; //String es una clase, no un tipo primitivo de datos
	private double sueldo; //double es un tipo primitivo de datos
	private Date altaContrato; //Date es una clase, no un tipo primitivo de datos
	private static int IDsiguiente;
	private int ID;
	
}


/*
 * - Herencia de Empleado(padre) y si ponemos 'final class', cortamos aqui la herencia, 
 * no se podrán heredar más hacia abajo.
 * - Ponemos la interface Jefes_19_III conectada a Jefatura, por lo que estamos obligados a 
 * incluir todos los metdos de esa interfaz (y de la interface TRabajadores_19_II, ya que 
 * también hay herencia de una sobre otra) dentro de Jefatura 
  */
class Jefatura extends Empleado implements Jefes_19_III {		
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) { //Constructor
		
		super(nom, sue, agno, mes, dia); //implementamos el primer constructor de Empleados(5 argumentos)
		
	}
	
	
	public String tomar_decisiones(String decision){ //Creamos el método creado con la Interface Jefes
		
		return "Un miembro de la dirección ha tomado la decisión de: " + decision;
	}
	
	
	public double establece_bonus(double gratificacion) {  //metodo de la interface trabajadores que esta por encima de la interface jefes
															//el triangulo verde indica que este metodo machaca al creado antes en la clase Empleado
		double prima=2000;
		
		return Trabajadores_19_II.BONUS_BASE + gratificacion + prima;
		
	}
	
	public void estableceIncentivo(double b) {  //SETTER
		
		incentivo=b;
		
	}
	
	public double dameSueldo(){		//GETTER (el triangulo verde dice que este machaca/sobreescribe al mismo método que hemos puesto en el padre
		
		double sueldoJefe=super.dameSueldo(); //Con super le decimos que llame al método del padre(que habíamos machacado pero que necesitamos para establecer el sueldo base).
		
		return sueldoJefe + incentivo;
		
	}
	
	
	private double incentivo;		//encapsulamiento de variables
	
}

