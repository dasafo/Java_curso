/****************************************************************************************************
 * Hoja de Ruta para este MVC, el cual consisitrá en hacer consultas CRUD 
 * (Create, Read, Update, Delete)
 * 
 * 		
 * 	1- Crear objetos de tipo Productos para poder manipularlos *Productos.java*
 * 	2- Crear un Modelo(BBDD). Es el archvo Java pertienente, encargado de
 * 		   de conectar con las BBDD y de crear los registros que se pidan. *ModeloProductos.java*
 * 	3- Crear un controlador (Servlet). Encargado de obtener dichos registros y 
 *  	   mandarlos a la Vista(JSP) *ControladorProductos.java*
 *  4- Crear la página JSP. Que es la interfaz que el usuario vera finalmente. *ListaProductos.jsp*
 * 
 ***************************************************************************************************/

package com.pildorasinformaticas.prod;

import java.util.Date;

public class Productos {
	
	
	
	
	//Contructores creados desde boton derecho-->source--->Generated Constructor using Fields y se seleccionan todos. Luego borramos super() que no lo necesitamos
	public Productos(String cArt, String seccion, String nArt, double precio, Date fecha, String importado, String pOrig) {
		
		this.cArt = cArt;
		this.seccion = seccion;
		this.nArt = nArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pOrig = pOrig;
	}
	
	
	/*Contructores creados desde boton derecho-->source--->Generated Constructor using Fields y se seleccionan todos
       menos cArt(será nuestro campo clave). También borramos super() que no lo necesitamos*/
	public Productos(String seccion, String nArt, double precio, Date fecha, String importado, String pOrig) {
		
		this.seccion = seccion;
		this.nArt = nArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pOrig = pOrig;
	}

	//-------Setters and Getters creados desde boton derecho-->source--->Generated Setters and Getters y se seleccionan todos los campos-------
	 	

	public String getcArt() {
		return cArt;
	}


	public void setcArt(String cArt) {
		this.cArt = cArt;
	}


	public String getSeccion() {
		return seccion;
	}


	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public String getnArt() {
		return nArt;
	}


	public void setnArt(String nArt) {
		this.nArt = nArt;
	}

	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getImportado() {
		return importado;
	}


	public void setImportado(String importado) {
		this.importado = importado;
	}


	public String getpOrig() {
		return pOrig;
	}


	public void setpOrig(String pOrig) {
		this.pOrig = pOrig;
	}

	
	//-------metodo toString() creado desde boton derecho-->source--->Generated to String() y se seleccionan todos los campos-------
	
	@Override
	public String toString() {
		return "Productos [cArt=" + cArt + ", seccion=" + seccion + ", precio=" + precio + ", fecha=" + fecha
				+ ", importado=" + importado + ", pOrig=" + pOrig + "]";
	}
	//-----------------------------------------------------------------------------------------------------------------------
	
	private String cArt;
	private String seccion;
	private String nArt;
	private double precio;
	private Date fecha;
	private String importado;
	private String pOrig;
	

}
