package clases_propias;

public class UsoPareja_73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pareja_72<String> uno=new Pareja_72<String>(); //primero=null
		
		uno.setPrimero("Juan"); //primero="Juan"
		
		System.out.println(uno.getPrimero());
		
		Persona pers1=new Persona("Ana");
		
		Pareja_72<Persona> otra=new Pareja_72<Persona>(); //primero=null
		
		otra.setPrimero(pers1);
		
		System.out.println(otra.getPrimero());

	}

}

class Persona{
	
	public Persona(String nombre) {
		
		this.nombre=nombre;
	}
	public String toString() {
		
		return nombre;
	}
	
	private String nombre;
}
