package poo;

public class Coche_17_I {
	
	//Con private encapsulamos esas variables, que solo pueden ser modificadas desde esta clase.
	private int ruedas; 
	private int ancho;
	private int largo;
	private int motor;
	private int peso_plataforma;
	

	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;
	
	
	public Coche_17_I() { 		//Constructor(condiciones iniciales)
		
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;
		
	}
	
	//Creamos los GETTER(para poder ver la info de esta clase desde otros clases)
	public String dime_datos_generales(){
		 return "La plataforma tiene " + ruedas + " ruedas " + ". Mide " + largo/1000 + 
		 " metros, con un ancho de " + ancho + 
		 " cm y un peso de plataforma de " + peso_plataforma + " Kg.";
		
	}
	
	
	
	//Creamos un SETTER, no devulve dato, modifica dato (void)
	public void establece_color(String color_coche) {
		
		color=color_coche;
	}
	
	public String dime_color() {		//GETTER
		return "El color del coche es " + color + ".";
	}

	
	
	public void configura_asientos(String asientos_cuero) { 	//SETTER
		
		//this.asientos_cuero=asientos_cuero; //this cuando la variable de la clase coincide con la del argumento(con color(por ej.) era diferente)
		
		if(asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero=true;
		}else {
				this.asientos_cuero=false;
			}
	
	}
	
	public String dime_asientos() { 	//GETTER
		
		if(asientos_cuero==true) {
			
			return "El coche tiene asientos de cuero.";
		}else {
			
			return "El coche tiene asientos de serie.";
		}
	}
	
	
	
	
	public void configura_climatizador(String climatizador) { 	//SETTER
		
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	
	public String dime_climatizador() { 	//GETTER
		
		if(climatizador=true) {
			return "EL coche lleva climatizador";
		}else {
			return "EL coche lleva aire acondicionado";
		}
	}
	
	
	
	
	public String dime_peso_coche() { 	//SETTER + GETTER
		
		int peso_carroceria=500;
		
		peso_total=peso_plataforma + peso_carroceria;
		
		if(asientos_cuero==true) {
			
			peso_total=peso_total+50;
			
		}
		
		if(climatizador=true) {
			
			peso_total=peso_total+20;
		}
		
		return "El peso del coche es " + peso_total;
		
	}
	
	
	
	public int precio_coche() { 	//SETTER + GETTER
		
		int precio_final=10000;
		
		if(asientos_cuero==true) {
			
			precio_final+=2000;
		}
		if(climatizador==true) {
			
			precio_final+=1500;
		}
		
		return precio_final;
	}
	
}
