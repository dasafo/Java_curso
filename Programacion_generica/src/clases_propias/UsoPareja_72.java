package clases_propias;

public class UsoPareja_72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pareja_73<String> uno=new Pareja_73<String>();
		
		uno.setPrimero("Juan");
		
		System.out.println(uno.getPrimero());
		
		Persona pers1=new Persona("Ana");
		
		Pareja_73<Persona> otra=new Pareja_73<Persona>();
		
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
