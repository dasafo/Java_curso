/* 
 * Las mejores preacticas nos dicen que siempre hay q encapsular
 * todos los datos o acciones referentes a la bbdd y como en esta app
 * realizamos consultas a los Productos, pues creamos un archivo a parte
 * donde introducimos nuestra clase Productos
 * */
package modelo;

public class Productos {
	
	public Productos() {
		
		nArticulo="";
		seccion="";
		precio="";
		pOrigen="";
	}
	
	//Estos Getters an Setters se han hecho con botón derecho en Eclipse Sourse--->Generate Getters and Setters, seleccionando todos
	public String getnArticulo() {
		return nArticulo;
	}
	public void setnArticulo(String nArticulo) {
		this.nArticulo = nArticulo;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getpOrigen() {
		return pOrigen;
	}
	public void setpOrigen(String pOrigen) {
		this.pOrigen = pOrigen;
	}
	//-----------------------------------------------------------------------------------------------------------

	private String nArticulo;
	private String seccion;
	private String precio;
	private String pOrigen;


}
