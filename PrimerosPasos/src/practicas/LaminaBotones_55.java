package practicas;

import javax.swing.*;

public class LaminaBotones_55 extends JPanel { //con esta clase hacemos nuestra 'caja plantilla' que extendermos al resto de celdas
	
	public LaminaBotones_55(String titulo, String [] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo)); //BorderFactory para añadir marco a la caja
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Dispocion tipo caja, en esta lamina(this) y distribuidos en el eje Y
		
		grupo=new ButtonGroup(); //Para agrupar los elementos, para que solo se pueda seleccionar un RadioButton
		
		for(int i=0;i<opciones.length;i++) { //En opciones va el nº de elementos en forma de Strings, con for lo recorremos, i es cada elemento
			
			JRadioButton bot=new JRadioButton(opciones[i]);
			
			bot.setActionCommand(opciones[i]); //para cada boton el texto seleccionado corresponda a ese boton
			
			add(bot);
			
			grupo.add(bot);
			
			bot.setSelected(i==0); //para que por defecto seleccione el primer elemento de la caja
			
		}
		
	}
	
	public String dameSeleccion() {
		
		/*ButtonModel miboton=grupo.getSelection(); //almacena el radiobutton seleccionado en miboton
		String s=miboton.getActionCommand(); //nos devuelve el String del elemento almacenado en miboton y se almacena en s
		return s;*/
		
		return grupo.getSelection().getActionCommand(); //hace lo mismo que lo comentado arriba
	}
	
	private ButtonGroup grupo;

}
