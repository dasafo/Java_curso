/*
- Las interfaces solo contienen metodos abstractos y constantes
dichas constantes se ponen en mayusculas por convenio, y palabras
separadas por guion bajo.
- No se pueden instanciar (como le pasa a las clases abstractas)
- EN Java no permite la herencia multiple(no podemos tener una clase de herede de 
2(o mas)a la vez), por eso el concepto de Interface es como una clase externa 
que permite ser heredara por una clase. Esta clase hija, puere heredar tanto de 
una clase padre normal y/o de una o varias interfaces.
- Las interfaces y sus elementos se muestran en cursiva
- se usa la palabra 'implements' para indicar que una clase implementa una 
interface determinada (EJ: public class Impl implements Acceso{...})
- Una interface puede heredar de otra interface
*/

package poo;

public interface Trabajadores_19_II { 	//Creamos interface

	double establece_bonus(double gratificación); //todas en las interfaces son public static abstract
	
	double BONUS_BASE=1500; 
	
}
