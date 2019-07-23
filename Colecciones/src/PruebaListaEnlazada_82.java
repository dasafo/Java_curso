
import java.util.*;

public class PruebaListaEnlazada_82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> paises=new LinkedList<String>();
		
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Peru");
		
		LinkedList<String> capitales=new LinkedList<String>();
		
		capitales.add("Madrid");
		capitales.add("Bogotá");
		capitales.add("DF");
		capitales.add("Lima");
		
		//System.out.println(paises);
		//System.out.println(capitales);
		
		
		//----Añadimos una lista a la otra (Pais-capital)-------------
		
		ListIterator<String> iterA=paises.listIterator(); //al crear el iterador por defecto se 'posiciona' delante de la lista
		ListIterator<String> iterB=capitales.listIterator();
		
		while(iterB.hasNext()) { //Mientras tengamos un elemento capital delante del iterador(hasNext()), haz...
			
			if(iterA.hasNext()) {  //si tambien hay un pais delante de la posicion del iterador, haz...
				
				iterA.next(); //Satla al siguiente elemento(hueco)
				
			}
			
			iterA.add(iterB.next());  //Me agregas a iterA el siguiente iterB (Pais(iterA)---Capital(iterB))
								      // Cuando salga del buble While el iterador(A y B) se encuentra al final de la lista
		}
		
		System.out.println(paises); //ahora iterA es iterA+iterB por lo que lo imprimimos

		iterB=capitales.listIterator(); //ponemos el iterador al principio de la lista B(capitales) otra vez
		
		while(iterB.hasNext()) { //queremos borrar las capitales en posiciones pares de nuestra lista B
			
			iterB.next();
			
			if(iterB.hasNext()) {
				
				iterB.next(); //nos colocamos delante de la posicion de la segunda capital (en la primera iteracion del bucle)
				iterB.remove(); //Borramos la capital de la posicion 2 en la priemera iteracion del bucle(luego la 4, luego la 6,...)
			}
		}
		
		System.out.println(capitales); //Comprobamos que hemos borrado las posiciones pares de nuestra lista capitales
		
		paises.removeAll(capitales); //borramos las capitales de nuestra lista paises(paises+capitales)
		System.out.println(paises);
		

		
	}

}
