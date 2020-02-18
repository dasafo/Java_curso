package poo;

public class Ej_Uso_Vehiculo_17_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		* Creamos un objeto llamado micoche1. Primero el nombre de la 
		* clase(Coche_17_I) a la que pertenece, despues el nombre del objeto,
		* luego el operador new que nos permite crear un nuevo objeto, y 
		* finalmente usamos el constructor de la clase. 
		 */
		Ej_Coche_17_I micoche1=new Ej_Coche_17_I(); 
		micoche1.establece_color("Rojo");
		
		Ej_Furgoneta_17_II mifurgoneta1=new Ej_Furgoneta_17_II(7,580); //Instanciamos otra clase
		mifurgoneta1.establece_color("azul");
		mifurgoneta1.configura_asientos("Si");
		mifurgoneta1.configura_climatizador("Si");
		
		System.out.println(micoche1.dime_datos_generales() + " " + micoche1.dime_color());

		System.out.println(mifurgoneta1.dime_datos_generales() + mifurgoneta1.dimeDatosFurgoneta());

	}

}
