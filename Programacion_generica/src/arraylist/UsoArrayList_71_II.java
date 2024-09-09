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

    // Usamos el ArrayList manual creado en UsoArrayList_71_I.java
		ArrayList_71_I archivos=new ArrayList_71_I(5);
		
		archivos.add("Juan");
		archivos.add("Maria");
		archivos.add("Ana");
		archivos.add("Samdra");
		
		archivos.add(new File("gestionPedidos.sdasd"));
    File nombrePersona = (File)archivos.get(0);

		String nombrePersona=(String)archivos.get(4); 
		/*
		Nos da error la linea de arriba porque el ArrayList no está configurado 
		para admitir hacer casting de tipo String en archivos File, solo admite
    segun la definicion que hemos hecho de nuestro ArrayList manual
    elementos de tipo Object. 
		
		Para evitar ese error habría que renombrar el ArraList de arriba, Que es uso 
    de un ArrayList de verdadm que viene a partir de la vesion 5 de JAva:
		
		ArrayList <String> archivos=new ArrayList<String>();
		*/
		
		
		System.out.println(nombrePersona);

	}

}
