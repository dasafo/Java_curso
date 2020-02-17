package poo;

public class Clase_21_I {
	
	protected int mivar=5; //Con protected permitimos que esta variable pueda ser usada por una subclase perteneciente a otro paquete(que no sea poo)
							//Sino pusieramos protected, estaría por defecto, y en ese caso Java no permite hacer eso, solo permite para variables u objetos dentro del mismo paquete
	int mivar2=7;
	
	public String mimetodo() {	//GETTER
		
		return "El valor de mivar2 es: " + mivar2;
	}

}
