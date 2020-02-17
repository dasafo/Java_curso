
import java.util.*;

public class PruebaTreeSet_83_II {

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

		Articulo2 primero=new Articulo2(1, "Primer artículo");
		Articulo2 segundo=new Articulo2(2000, "Segundo artículo");
		Articulo2 tercer=new Articulo2(3, "Este es el Tercer artículo");
		
		
		TreeSet<Articulo2> ordenaArticulos=new TreeSet<Articulo2>();
		
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		
		for(Articulo2 art: ordenaArticulos) {
			
			System.out.println(art.getDescripcion()); //vemos que nos lo ordena por numero y no alfabeticamnete
		}

		System.out.println("------------------------------");
		
		//------------y después ordenado según el String(alfabeticamente)--------------------------------

		// Articulo2 comparadorArticulos=new Articulo2(); //como ARticulo le hemos dicho que tiene que dar 2 argumentos, creamos otro constructor Articulo vacio(public Articulo(){})

		// TreeSet<Articulo2> ordenaArticulos2=new TreeSet<Articulo2>(comparadorArticulos);
		
		// ComparadorArticulos comparaArt=new ComparadorArticulos();
		
		TreeSet<Articulo2> ordenaArticulos2=new TreeSet<Articulo2>(new Comparator<Articulo2>() {
				
			@Override
			public int compare(Articulo2 o1, Articulo2 o2) {
				// TODO Auto-generated method stub
				String desc1=o1.getDescripcion();
				String desc2=o2.getDescripcion();
				
				return desc1.compareTo(desc2);

			}
				
		});
		
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercer);
		
		for(Articulo2 art: ordenaArticulos2) {
			System.out.println(art.getDescripcion());
		}
		

	}
	//----------------------------------------------------------------------------------------
	
}



class Articulo2 implements Comparable<Articulo2>{
	
	
	public Articulo2(int num, String desc) {
		
		numeroArticulo=num;
		descripcion=desc;
		
	}

	@Override
	public int compareTo(Articulo2 o) {
		// TODO Auto-generated method stub
		return numeroArticulo - o.numeroArticulo; //restamos el numero de un ARticulo que da el contructor con otro(compara articulos para ordenarolos por numero y no alfabeticamente)
	}
	
	public String getDescripcion() {
		
		return descripcion;
	}
	
	
	
	private int numeroArticulo;
	private String descripcion;
	
	
}

