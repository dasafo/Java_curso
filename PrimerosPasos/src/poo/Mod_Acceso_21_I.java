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

public class Mod_Acceso_21_I {
	
	protected int mivar=5; //Con protected permitimos que esta variable pueda ser usada por una subclase perteneciente a otro paquete(que no sea poo)
							//Sino pusieramos protected, estaría por defecto, y en ese caso Java no permite hacer eso, solo permite para variables u objetos dentro del mismo paquete
	int mivar2=7;
	
	public String mimetodo() {	//GETTER
		
		return "El valor de mivar2 es: " + mivar2;
	}

}
