
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
