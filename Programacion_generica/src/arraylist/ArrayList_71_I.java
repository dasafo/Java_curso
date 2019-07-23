package arraylist;

public class ArrayList_71_I {

	public ArrayList_71_I(int z) {
		
		datosElemento=new Object[z];
	}

	public Object get(int i) {
		
		return datosElemento[i];
	
	}
	
	public void add(Object o) {
		
		datosElemento[i]=o;
		i++;
	}
	
	private Object[] datosElemento;
	private int i=0;
	
	
}
