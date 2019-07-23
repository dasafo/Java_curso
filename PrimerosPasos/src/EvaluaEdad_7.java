import java.util.*;

public class EvaluaEdad_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner entrada=new Scanner(System.in);
			
			System.out.println("Introduce tu edad, por favor: ");
			
			int edad=entrada.nextInt();
			
			if(edad<18) {
				System.out.println("Eres menor.");
			}
			else if(edad<40) {
				System.out.println("Eres adulto.");
			}
			else if(edad<65) {
				System.out.println("Eres madurito.");
			}
			else {
				System.out.println("Eres un viejales.");
			}
	}

}
