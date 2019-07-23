
import java.util.*;

public class PruebaTreeSet_83_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*TreeSet<String> ordenaPersonas=new TreeSet<String>();
		
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");
		
		for(String s: ordenaPersonas) {
			
			System.out.println(s); //vemos que con TreeSet los String los ordena por orden alfabetico(String--->Comparable--->ComarableTo(verAPI))
		
		}*/
		
		
		//-----Ahora queremos ordenarolo segun el numero y no alfabeticamente(por defecto)-------------

		Articulo primero=new Articulo(1, "Primer artículo");
		Articulo segundo=new Articulo(2000, "Segundo artículo");
		Articulo tercer=new Articulo(3, "Este es el Tercer artículo");
		
		
		TreeSet<Articulo> ordenaArticulos=new TreeSet<Articulo>();
		
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		
		for(Articulo art: ordenaArticulos) {
			
			System.out.println(art.getDescripcion()); //vemos que nos lo ordena por numero y no alfabeticamnete
		}

		System.out.println("------------------------------");
		
		//------------y después ordenado según el String(alfabeticamente)--------------------------------

		Articulo comparadorArticulos=new Articulo(); //como ARticulo le hemos dicho que tiene que dar 2 argumentos, creamos otro constructor Articulo vacio(public Articulo(){})

		
		TreeSet<Articulo> ordenaArticulos2=new TreeSet<Articulo>(comparadorArticulos);
		
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercer);
		
		for(Articulo art: ordenaArticulos2) {
			System.out.println(art.getDescripcion());
		}
		

	}
	//----------------------------------------------------------------------------------------
	
}



class Articulo implements Comparable<Articulo>, Comparator<Articulo>{
	
	public Articulo() {
		
		
	}
	
	public Articulo(int num, String desc) {
		
		numeroArticulo=num;
		descripcion=desc;
		
	}

	@Override
	public int compareTo(Articulo o) {
		// TODO Auto-generated method stub
		return numeroArticulo - o.numeroArticulo; //restamos el numero de un ARticulo que da el contructor con otro(compara articulos para ordenarolos por numero y no alfabeticamente)
	}
	
	public String getDescripcion() {
		
		return descripcion;
	}
	
	
	
	private int numeroArticulo;
	private String descripcion;
	@Override
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		String descripcionA=o1.getDescripcion();
		String descripcionB=o2.getDescripcion();

		return descripcionA.compareTo(descripcionB);

	}
	
}





