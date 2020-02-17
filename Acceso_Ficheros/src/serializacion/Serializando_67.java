package serializacion;

import java.util.*;

import java.io.*;

public class Serializando_67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Administrador jefe=new Administrador("Juan", 80000, 2005,12,15);
		
		jefe.setIncentivo(5000);
		
		
		Empleado[] personal=new Empleado[3];
		
		personal[0]=jefe;
		
		personal[1]=new Empleado("Ana", 25000, 2008, 10,1);
		
		personal[2]=new Empleado("Luis", 18000, 2012, 9,15);
		
		try {
			
			ObjectOutputStream escribiendoFichero=new ObjectOutputStream(new FileOutputStream("/home/david/eclipse-workspace/Acceso_Ficheros/empleado.txt"));
			
			escribiendoFichero.writeObject(personal);
			
			escribiendoFichero.close();
			
			
			ObjectInputStream recuperandoFichero=new ObjectInputStream(new FileInputStream("/home/david/eclipse-workspace/Acceso_Ficheros/empleado.txt"));
			
			Empleado[] personalRecuperado=(Empleado[]) recuperandoFichero.readObject(); //hacemos castin porque InputStream nos devuelve un objeto y queremos []
			
			recuperandoFichero.close();
			
			for(Empleado e: personalRecuperado) { //lo hacemos con un for each (por cambiar)
				
				System.out.println(e);
			}
			
			
			
		}catch(Exception e) {
			
			
		}
		
		

	}

}

//-----------------------------------------------------------------------------------------------------------

class Empleado implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //esto es como la huella de los programas(version), que tanto emisor como receptor debe tener por si hay actualizaciones

	public Empleado(String n, double s, int agno, int mes, int dia){
		
		nombre=n;
		
		sueldo=s;
		
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1,dia);
		
		fechaContrato=calendario.getTime();
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	
	public void subirSueldo(double porcentaje){
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
		
	}
	
	public String toString(){ //toString da una descripcion de la clase
		
		return "El Nombre es =" + nombre + ",y su sueldo es =" + sueldo + ", fecha de contrato=" + fechaContrato;
		
	}

	private String nombre;
	
	private double sueldo;
	
	private Date fechaContrato;
	
}

//--------------------------------------------------------------------------------------------------------

class Administrador extends Empleado{
	
	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public Administrador(String n, double s, int agno, int mes, int dia){
			
			super(n,s,agno,mes,dia);
			
			incentivo=0;
			
		}
		
		public double getSueldo(){
			
			double sueldoBase=super.getSueldo();
			
			return sueldoBase + incentivo;
			
		}
		
		public void setIncentivo(double b){
			
			incentivo=b;
		}
		
		
		public String toString(){
			
			return super.toString() + " Incentivo=" + incentivo;
			
		}
	
		private double incentivo;
	
}

