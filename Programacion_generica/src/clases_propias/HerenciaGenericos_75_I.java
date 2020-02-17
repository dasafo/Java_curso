package clases_propias;

public class HerenciaGenericos_75_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Empleado_74_II Administrativa=new Empleado_74_II("Elena", 45, 1500);
		
		Jefe_75_II DirectoraComercial=new Jefe_75_II("Ana", 27, 3500);
		
		Empleado_74_II nuevoEmpleado=DirectoraComercial; //Un jefe ES UN Empleado, por lo que lo podemos almacenar en Empleado
		*/
		
		Pareja_73<Empleado_74_II> Administrativa=new Pareja_73<Empleado_74_II>();
		
		Pareja_73<Jefe_75_II> DirectoraComercial=new Pareja_73<Jefe_75_II>();
		
		// Pareja_73<Empleado_74_II>nuevoEmpleado=DirectoraComercial; //el principio de Sustitucion(ES UN..) no funcionaria con clases genericas, funcionaria si añadimos ? extends en Pareja_73,

		Pareja_73.imprimirTrabajador(Administrativa); //funciona porque Administrativa es de tipo empleado, y ese metodo(imprimir trabajdor) me pide un metodo de tipo Empleado
		
		Pareja_73.imprimirTrabajador(DirectoraComercial); //No funcionaria sin ? extends en Pareja_73,  porque aqui la herencia no funciona con genericos(hay que usar tipos comodín

		
	}

}
