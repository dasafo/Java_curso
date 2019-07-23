package clases_propias;

public class Pareja_73<T> {  //creamos una clase genérica
	
	public Pareja_73() {
		
		primero=null;
		
	}
	
	public void setPrimero(T nuevoValor) {
		
		primero=nuevoValor;
	}
	
	
	public static void imprimirTrabajador(Pareja_73<? extends Empleado_74_II> p) { //sino añadimos ? extends en HerenciaGenericos_75_I da problema con las herencias
		
		Empleado_74_II primero=p.getPrimero();
		
		System.out.println(primero);
	}
	
	
	public T getPrimero() {
		
		return primero;
	}
	
	private T primero;

}
