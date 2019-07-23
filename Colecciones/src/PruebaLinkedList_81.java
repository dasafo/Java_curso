
import java.util.*;

public class PruebaLinkedList_81 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> personas=new LinkedList<String>();
		
		personas.add("Pepe");
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		
		System.out.println(personas.size()); //que imprima los elementos que hay en la lista LinkedList


		ListIterator<String> it=personas.listIterator(); //listIterator que hereda de Iterator nos deja hacer más cosas
		
		it.next(); //ahora nos situamos entre la posicion 0 y la 1
		
		it.add("David"); //así situamos a David en la segunda posicion
		
		
		for(String persona : personas) {
			
			System.out.println(persona);
		}
		
		
		
	}

}
