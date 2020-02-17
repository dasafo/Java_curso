import java.util.*;

public class Uso_Enum_Tallas_22 {
	
	/*Con enum nos aseguramos que una variable(Tallas) solo puede almacenar
	 * un feterminado tipo de strings(S,M,L,XL)*/
	
	
	//enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE};  //Tipos numerados
	
	enum Talla{
		
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
		
		private Talla(String abreviatura) { //Constructor que también hace de SETTER en este caso
			
			this.abreviatura=abreviatura;
		}
		
		public String dameAbreviatura() { //getter
			
			return abreviatura;
		}
		
		
		private String abreviatura;		 //variable encapsulada
			
	}
	
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		/*Talla s=Talla.MINI;
		
		Talla m=Talla.MEDIANO;
		
		Talla l=Talla.GRANDE;
		
		Talla xl=Talla.MUY_GRANDE;*/
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Escribe una entrada: MINI, MEDIANO, GRANDE, MUY_GRANDE");
		
		String entrada_datos=entrada.next().toUpperCase(); //next() es de Scanner y toUpperCase() es de String que convierte todos los caracteres a mayúsculas
		
		Talla la_talla=Enum.valueOf(Talla.class, entrada_datos);
		
		System.out.println("Talla= " + la_talla);
		
		System.out.println("Abreviatura= " + la_talla.dameAbreviatura());
		
		
	}

}
