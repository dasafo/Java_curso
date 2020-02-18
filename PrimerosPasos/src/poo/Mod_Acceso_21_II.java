/*
Modificadores de acceso
(Clase=1, Variable=2, Metodo=3, Constructor=4, Misma Clase=5, Mismo paquete=6,
Subclase(de otro paquete)=7, Todas las demás=8):

-Public(+): se puede aplicar a 1,2,3 y 4. Es accesible desde 5,6,7 y 8.
-Protected(#): Se puede aplicar a 2,3 y 4. Es accesible desde 5,6 y 7
-default*(si no se pone nada): Se puede aplicar a 1,2,3 y 4. Es accesible desde 5 y 6
-Private(-): Se puede aplicar a 2,3 y 4. Es accesible desde 5
*/

package poo;

import paquetepruebas.Clase_21_III;		//Importamos paquete de pruebas para poder utilizarlo en poo

public class Mod_Acceso_21_II {

	public static void main(String[] args) {	//SETTER
		// TODO Auto-generated method stub
		
		Mod_Acceso_21_I miobj=new Mod_Acceso_21_I();
		
		Mod_Acceso_21_II miobj2=new Mod_Acceso_21_II();		//Recordemos que la clase3 hereda de la Clase1
		
		
		

	}

}
