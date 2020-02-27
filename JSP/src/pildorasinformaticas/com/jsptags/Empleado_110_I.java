/*
****************************************JSP Tags******************************************

- Son librerias de etiquetas parecidas a los xml, utilizadas en paginas JSP
- Sirven para hacer mas simple la programacion, lectura, modificacion de
  paginas dinamicas JSP
- NO son imprescindibles pero si muy recomendables:
	-> Separan el codigo Java del codigo HTML
	-> Se integran limpiamente en el codigo HTML
	-> Minimizan el codigo en la web
	-> Hacen que el codigo dinamico sea reutilizable
	-> HAcen que el mantenimiento web sea sencillo

- Tipos de JSP Tags:

	-> JSP CustomsTags (Hechas por uno mismo)
	
	-> JSTL Standard Tag Library (librerias ya prefabricadas)
	
		Etiquetas:
			-> Core
				* Aglutinan las funcionalidades basicas de JSP
				* Bucles, condicionales....sintaxis basica de Java
			-> Formato
				* Aplican formato a elementos de dentro de JSP
				* Formato fecha, numero, moneda, internacionalizacion
			-> XML
				* Permite la manipulacion de vodigo XML en una web JSP
			-> SQL
				* Permite manipular BBDD desde paginas JSP.
					(No recomendado, mejor usando Beans)
					
		Pasos a seguir para usar los JSTL:
			1- Descargar la libreria JSTL
			2- Agregar la libreria al proyecto
			3- Importar la libreria en cada pagina JSP donde se use
				(< % taglib prefix="c" uri=http://java.sun.com/jsp/jstl/core %>)

******************************************************************************************
 */


package pildorasinformaticas.com.jsptags;

public class Empleado_110_I {
	
	private String nombre;
	private String apellido;
	private String puesto;
	private double salario;
	
	
	public Empleado_110_I(String nombre, String apellido, String puesto, double salario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto = puesto;
		this.salario = salario;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
