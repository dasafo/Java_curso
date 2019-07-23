package arraylist;

import java.io.*;
import java.util.ArrayList;

public class UsoArrayList_71_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList archivos=new ArrayList(5);
		
		archivos.add("Juan");
		archivos.add("Maria");
		archivos.add("Ana");
		archivos.add("Samdra");
		
		archivos.add(new File("gestionPedidos.sdasd"));

		String nombrePersona=(String)archivos.get(4); //nos da error porque el ArrayList no está configurado para admitir archovos File
		
		
		
		System.out.println(nombrePersona);

	}

}
