/*************************************ArrayList******************************************
 * 
 * - Son listas dinamicas compuestas por Objetos.
 * 
 * - C_ ArrayList
 * 		->M_ iterator()
 * 			|
 * 			--> I_Iterator
 * 				---> M_hasNext() : Nos dice s hay mas elementos o no en el <ArrayList>
 *  		    ---> M_next() : Devuelve el siguiente elemento de la iteracion
 * 				---> M_remove() : Elimina el elemento que estemos mirando
 * 
 ****************************************************************************************/


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

		String nombrePersona=(String)archivos.get(4); 
		/*
		Nos da error la linea de arriba porque el ArrayList no está configurado 
		para admitir archovos File.
		
		Para evitar ese error habría que renombrar el ArraList de arriba:
		
		ArrayList <String> archivos=new ArrayList<String>();
		*/
		
		
		System.out.println(nombrePersona);

	}

}
