package poo;

public class Uso_Vehiculo_17_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instanciamos una clase poniendo la clase a la que pertenece(micoche1 es una instancia de la clase Coche_17_I
		Coche_17_I micoche1=new Coche_17_I(); 
		micoche1.establece_color("Rojo");
		
		Furgoneta_17_III mifurgoneta1=new Furgoneta_17_III(7,580); //Instanciamos otra clase
		mifurgoneta1.establece_color("azul");
		mifurgoneta1.configura_asientos("Si");
		mifurgoneta1.configura_climatizador("Si");
		
		System.out.println(micoche1.dime_datos_generales() + " " + micoche1.dime_color());

		System.out.println(mifurgoneta1.dime_datos_generales() + mifurgoneta1.dimeDatosFurgoneta());

	}

}
