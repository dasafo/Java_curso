package clases_propias;

public class UsoPareja_73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    // Usamos la clase generica creada en UsoPareja_73.java y le damos uso de 
    // String
		Pareja_72<String> uno=new Pareja_72<String>(); //primero=null
		
		uno.setPrimero("Juan"); //primero="Juan"
		
		System.out.println(uno.getPrimero());
		
		Persona pers1=new Persona("Ana");
		
    // Ahora usamos la clase generica otra vez del archivo anterior y le damos 
    // el uso de la clase Persona creada abajo
		Pareja_72<Persona> otra=new Pareja_72<Persona>(); //primero=null
		
		otra.setPrimero(pers1); //le damos el mismo valor creado antes en pers1
		
		System.out.println(otra.getPrimero()); //nos devolvera un objeto no un string como antes, pero como hemos implementeado en la clase Persona toString() nos mostrara el nombre

	}

}

class Persona{
	
	public Persona(String nombre) {
		
		this.nombre=nombre;
	}
  // Si queremos que nos devuelva un string y no el nombre del objeto Persona hacemos:
	public String toString() {
		
		return nombre;
	}
	
	private String nombre;
}
