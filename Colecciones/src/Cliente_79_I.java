/*
 * + Las colecciones cambian de tamaño dinámicamente
 * + Pueden ir provistas de odenamiento
 * + Se pueden insertar y eliminar elementos
 * + NO puede almacenar datos primitivos como si hace un Array,
 * pero si puede almacenar objetos.
 * + Las colecciones vienen determinadas por una serie de interfaces, 
 * en cuya cúspide esta I_Collection de la cual descienden 3 interfaces:

    1. I_Set: Permite almacenar una coleccion de elementos no repetidos y sin ordenar
    1.1. I_SortedSet
    
    2. I_List: Pueden estar repetidos y estar indexados con valores numricos.
        Permite acceso aleatorio a sus posiciones
    
    3. I_Queue: No permite acceso aleatorio. Solo permite acceder a elementos
        que se encuentren al principio o al final.
- Fuera de I_Collection se encuentra:
    4. I_Map: Permite crear una coleccion de elementos repetibles indexados por
        clave unica arbitraria (no solo numeros como en las List, tambien pueden
        ser string)
    4.1. I_SortedMap
 ********************************************************************************   
 *** Las Interfaces y sus clases asociadas al detalle estan en los archivos de 
 *** pildorasinformaticas de JAva en la carpeta Colecciones/ColeccionesInfo
 *********************************************************************************
 */



public class Cliente_79_I {
	
	public Cliente_79_I(String nombre, String nCuenta, double saldo) {
		
		this.nombre=nombre;
		this.nCuenta=nCuenta;
		this.saldo=saldo;
		
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getnCuenta() {
		return nCuenta;
	}
	public void setnCuenta(String nCuenta) {
		this.nCuenta = nCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	
	//(VER EJERCICIO 80)
	//-----Esta parte esta hecho automaticamente en barra de herramientas: 'Source'--->'Generate hashCode() and equals()'------>nCuenta------>Generate
	//Esto es para que detecte si hay dos numeros de cuentas dupplicados
	
	private String nombre;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nCuenta == null) ? 0 : nCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente_79_I other = (Cliente_79_I) obj;
		if (nCuenta == null) {
			if (other.nCuenta != null)
				return false;
		} else if (!nCuenta.equals(other.nCuenta))
			return false;
		return true;
	}
	//-----------------------------------------------------------------------------------------

	
	
	private String nCuenta;
	private double saldo;
}
