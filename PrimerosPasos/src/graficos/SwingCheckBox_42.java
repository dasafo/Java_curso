/************************************************************************************************
 * 
 * 1.- Objeto evento(click ratón, tecla,...)
 * 		-C_EventObject--> C_ActionEvent(para acciones del raton) 
 * 						  C_WindowEvent(eventos de maximizar ventana,minimizar,...)
 * 
 * 2.- Objeto fuente(quien desencadena el evento(botón, radiobutton,..))
 * 		-C_JButton--> M_addActionListener(Object listener)
 * 
 * 3.- Objeto Listener(quien recibe la acción(que zona tiene que cambiar))
 * 		-C_JPanel--> I_ActionListener--> M_actionPerformed(Object evento)
 *   				 I_WindowListener--> Tiene 7 métodos(ver API) que hay que incluir.
 *   									 Pero también podemos usar su clase adaptadora 
 *   									 WindowAdapter.
 *   				 I_WindowStateListener--> M_windowStateChanged(WindowEvent e)
 *					 I_KeyListener--> M_keyPressed(..),M_keyRelased(..) y M_keyTyped(..)
 *									  Tabmién tiene su clase adaptadora KeyAdapter
 *					 I_MouseListener-->Tiene 5 metodos(ver API) pero también podemos
 *									   usar la clase adaptadora MouseAdapter
 *					 I_MouseMotionListener-->M_mouseDragged(..) y M_mouseMoved(..)
 *					 I_FocusListener--> M_focusGained(..) y M_focusLost(..)
 *										Con clase adaptadora FocusAdapter
 *					 I_WindowsFocusListener--> M_windowGainedFocus(..) y M_windowLostFocus(..)
 *											   Con clase adaptadora WindowAdapter
 *					 I_Action --> Tiene 6 métodos(ver API) + otro importado de ActionListener
 *								  (actioPe  rformed). Tiene una clase ABSTRACTA que hace la función
 *								  de adaptadora que es C_AbstractAction
 *
 * I=Interface, M=Metodo, C=Clase
 **************************************************************************************************/


package graficos;


import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

public class SwingCheckBox_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCheck mimarco=new MarcoCheck();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}


class MarcoCheck extends JFrame{
	
	public MarcoCheck() {
		
		setBounds(550,300,550,350);
		setVisible(true);
		LaminaCheck milamina=new LaminaCheck();
		
		add(milamina);
		
	}
}


class LaminaCheck extends JPanel{
	
	public LaminaCheck() {
		
		setLayout(new BorderLayout());
		
		Font miletra=new Font("Serif", Font.PLAIN, 24);
		
		texto=new JLabel("En un lugar de la Mancha...");
		
		texto.setFont(miletra); //establecemos a 'texto' el tipo de letra declarado en el objeto FONT 'miletra'
		
		JPanel laminatexto=new JPanel(); //creamos una lamina
		
		laminatexto.add(texto); //metemos en la laminatexto el texto
		
		add(laminatexto, BorderLayout.CENTER); //situamos laminatexto en el centro de un borderlayout
		
		check1=new JCheckBox("Negrita");
		check2=new JCheckBox("Cursiva");
		
		check1.addActionListener(new ManejaChecks()); //dejamos a la escucha los checkbox de los eventos de la clase ManejaChecks
		check2.addActionListener(new ManejaChecks());
		
		JPanel laminaChecks=new JPanel(); //creamos la lamina para los checks
		
		laminaChecks.add(check1); //añadimos los checks en laminaChecks
		laminaChecks.add(check2);
		
		add(laminaChecks, BorderLayout.SOUTH); //situamos laminachecks en el sur de un borderlayout

	}
	
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int tipo=0;
			
			if(check1.isSelected()) tipo+=Font.BOLD; //si activamos el chekbox es =1(ver API de Font Bold), sino =0
			if(check2.isSelected()) tipo+=Font.ITALIC; //si =2 (ver API de Font Italic)
			
			texto.setFont(new Font("Serif", tipo, 24)); //fuente por defecto
			
		}
		
		
	}
	
	private JLabel texto;
	
	private JCheckBox check1, check2;
	
	
}
