package clases_propias;

public class Empleado_74_II {


	public Empleado_74_II(String nombre, int edad, double salario) {
			
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
			
	}
		
	public String dameDatos() {
			
		return "El empleado se llama " + nombre + ". Tiene " + edad + " años." + " Y un salario de " + salario;
	}
	
	private String nombre;
	private int edad;
	private double salario;
		
		
}


