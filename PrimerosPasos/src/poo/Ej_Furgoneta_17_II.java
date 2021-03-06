package poo;

public class Ej_Furgoneta_17_II extends Ej_Coche_17_I { 	//Con extends hacemos heredar furgoneta de la clase Coche ya creada

	
	private int capacidad_carga;	//encapsulamos variables
	private int plazas_extra;
	
	
	public Ej_Furgoneta_17_II(int plazas_extra, int capacidad_carga) { //Creamos constructor con la herencia de Coche y las propias de Furgoneta
		
		super(); //Con super llamamos al contructor de la calse padre(coche)
		
		 /*
        Con THIS indicamos que accedemos a los atributos de la clase
        En este caso asociamos los atributos de la clase a los argumentos 
        del constructor.
        */
		
		this.capacidad_carga=capacidad_carga;
		
		this.plazas_extra=plazas_extra;
		
	}
	
	public String dimeDatosFurgoneta() {		//GETTER
		
		return " La capacidad de carga es: " + capacidad_carga + " Y las plazas son: " + plazas_extra;
		
	}
	
	
}
