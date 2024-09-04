package practicas;

import javax.swing.*;

/*
 * - Aqui vamos a construir la plantilla de los BoxLayout para los botones
 * que van en el GridLayout(metemos este GRidLayout dentro de un BorderLAyout, y lo ponemos
 * en el centro del marco.
 * - Añadimos el boton 'Mostrar' al sur de un BorderLAyout
 */

public class LaminaBotones_55 extends JPanel { //con esta clase hacemos nuestra 'caja plantilla' que extendermos al resto de celdas
	
	//las cajas tienen en común que tienen un titulo y que tienen radiobuttons, por eso metemos 2 argumentos
	public LaminaBotones_55(String titulo, String [] opciones) { 
		
		//Para dibujar los bordes que rodean a los BoxLayout con C_BorderFactory
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo)); 
		
		//Creamos los BoxLayuot_(contenedor padre, distribucion elementos)
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Dispocion tipo caja, en esta lamina(this) y distribuidos en el eje Y
		
		grupo=new ButtonGroup(); //Para agrupar los elementos, para que solo se pueda seleccionar un RadioButton en cada grupo
		
		
		//En 'opciones' va el nº de elementos(radiobuttons) en forma de Strings, 
		//Con for lo recorremos, i es cada elemento
		for(int i=0;i<opciones.length;i++) { 
			
			//construimos los radiobutton con un texto dado en el argumento del constructor(String [] opciones)
			JRadioButton bot=new JRadioButton(opciones[i]);
			
			bot.setActionCommand(opciones[i]); //para cada boton el texto seleccionado corresponda a ese boton
			
			add(bot); // Añadimos el boton a la lamina
			
			grupo.add(bot); //Lo metemos en el objeto grupo creado antes para agrupar
			
			bot.setSelected(i==0); //para que por defecto seleccione el primer elemento de la caja
			
		}
		
	}
	
	public String dameSeleccion() {
		
		/*
		ButtonModel miboton=grupo.getSelection(); //almacena el radiobutton seleccionado en miboton
		String s=miboton.getActionCommand(); //nos devuelve el String del elemento almacenado en miboton y se almacena en s
		return s; //Para que devuelva el String seleccionado en el radiobutton
		*/
		
		return grupo.getSelection().getActionCommand(); //hace lo mismo que lo comentado arriba
	}
	
	private ButtonGroup grupo;

}
