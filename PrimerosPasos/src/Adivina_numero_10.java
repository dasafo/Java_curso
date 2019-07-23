import java.util.*;

public class Adivina_numero_10 {

	public static void main(String[] args) {
		
		int aleatorio=(int)(Math.random()*100); //Random devuelve un double que refundimos en un int
		
		Scanner entrada=new Scanner(System.in);
		
		int numero=0;
		
		int intentos=0;
		
		do{
			
			intentos++;
			
			System.out.println("Introduce un número: ");
			
			numero=entrada.nextInt(); //nextInt de Scanner devuelve el input que es String como entero
			
			if(aleatorio<numero) {
				
				System.out.println("Más bajo");
			}
			
			else if(aleatorio>numero) {
				System.out.println("Más alto");
			}
				
		} while(numero!=aleatorio);
		
		System.out.println("BINGO. Los has conseguido en " + intentos + " intentos.");
	}

}
