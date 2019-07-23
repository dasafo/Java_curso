package poo;
import java.util.*;

public class Uso_Empleado_19_I {

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
		
		Jefatura jefe_RRHH=new Jefatura("Juan", 55000, 2006, 9, 25);		//principio de sustitución
		
		jefe_RRHH.estableceIncentivo(2570);
		
		Empleado[] misEmpleados=new Empleado[6];
		
		misEmpleados[0]=new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		misEmpleados[1]=new Empleado("Ana López", 95000, 1995, 06, 02);
		misEmpleados[2]=new Empleado("María Martín", 105000, 2002, 03, 15);
		
		misEmpleados[3]=new Empleado("Antonio Fernández"); //Este pertenecería al otro Constructor Empleado
		
		misEmpleados[4]=jefe_RRHH;  //Polimorfismo en acción(objeto de la subclase(jefatura) cuando espera una de la superclase(Empleado)
		misEmpleados[5]=new Jefatura("Maria", 95000,1995, 03, 26);

		Jefatura jefa_finanzas=(Jefatura) misEmpleados[5]; //REfundición o Castin(visto al principio del curso, para transdormar un objeto de un tipo en otro)
		
		jefa_finanzas.estableceIncentivo(55000);
		
		System.out.println("El jefe " + jefa_finanzas.dameNombre() + " tiene un bonus de " + jefa_finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de " + misEmpleados[3].establece_bonus(200));

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
		
			Arrays.sort(misEmpleados);		//Definimos el método sort de la clase Arrays para la interfaz comparar
		
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre: " + e.dameNombre() 
					+ " Sueldo: " + e.dameSueldo()  	//aqui cuando llegue a Juan tomará el de Jefatura(ENlazado dinamico)
					+ " Fecha de Alta: " + e.dameFechaContrato());
			
		}
		
	}

}



class Empleado implements Comparable, Trabajadores_19_II {   //con implements asociamos la interfaz comparable y trabajadores
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) { //Constructor, que asigan valores iniciales 
		//y tiene que tener el mismo nombre de la clase a la que pertenece (Empleado) 
	
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1, dia);
		altaContrato=calendario.getTime();
		
		++IDsiguiente;
		ID=IDsiguiente;
	
	}
	
	
	public double establece_bonus(double gratificacion) { 	//GETTER
		
		return Trabajadores_19_II.bonus_base + gratificacion;
	}
	
	
	public Empleado(String nom) { //Otro constructor(sobrecarga de constructores) 
		
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
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private static int IDsiguiente;
	private int ID;
	
}



class Jefatura extends Empleado implements Jefes_19_III {		//Herencia de EMpleado(padre) y si ponemos 'final class', cortamos aqui la herencia, no se podrán heredar más hacia abajo
														//Y ponemos la interface Jefes conectada a Jefatura
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) { //Constructor
		
		super(nom, sue, agno, mes, dia);
		
	}
	
	
	public String tomar_decisiones(String decision){ //Creamos el método creado con la Interface Jefes
		
		return "Un miembro de la dirección ha tomado la decisión de: " + decision;
	}
	
	
	public double establece_bonus(double gratificacion) {  //metodo de la interface trabajadores que esta por encima de la interface jefes
															//el triangulo verde indica que este metodo machaca al creado antes en la clase Empleado
		double prima=2000;
		
		return Trabajadores_19_II.bonus_base + gratificacion + prima;
		
	}
	
	public void estableceIncentivo(double b) {  //SETTER
		
		incentivo=b;
		
	}
	
	public double dameSueldo(){		//GETTER (el triangulo verde dice que este machaca al mismo método que hemos puesto en el padre
		
		double sueldoJefe=super.dameSueldo(); //Con super le decimos que llame al método del padre(que habíamos machacado pero que necesitamos para establecer el sueldo base).
		
		return sueldoJefe + incentivo;
		
	}
	
	
	private double incentivo;		//encapsulamiento de variables
	
}

