
public class UsoLibro_80_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libro_80_I libro1=new Libro_80_I("P en Java", "Juan", 25);
		Libro_80_I libro2=new Libro_80_I("P en Java 2.0", "Juan", 25);
		
		// libro1=libro2; //ambos objetos tendrán la misma referencia (hashCode). Este sirve(hashCode) para que JAva diferencie entre 2 objetos 
						  //de una misma Clase, cosa que con equals no somos capaces por si solo
		
		if(libro1.equals(libro2)) {
			System.out.println("Es el mismo libro.");
			
			System.out.println(libro1.hashCode()); //Codigo(referencia) del objeto
			System.out.println(libro2.hashCode());
			
		}else {
			
			System.out.println("No es el mismo libro.");
			
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());

		}

		
	}

}
