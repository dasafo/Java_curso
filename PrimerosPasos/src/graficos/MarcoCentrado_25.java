package graficos;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;

public class MarcoCentrado_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCentrado mimarco=new MarcoCentrado();
		
		mimarco.setVisible(true);	
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	}

}


class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit(); 
		
		Dimension tamanoPantalla=mipantalla.getScreenSize(); //nos devuelve la resolucion de la pantalla
	
		int alturaPantalla=tamanoPantalla.height; //almacenamos el alto en una variable
		
		int anchoPantalla=tamanoPantalla.width; //almacenamos el ancho en otr variable
		
		setSize(anchoPantalla/2, alturaPantalla/2);
		
		setLocation(anchoPantalla/4, alturaPantalla/4);
	
		setTitle("marcoCentrado");
		
		// Image miIcono=mipantalla.getImage("src/graficos/Piolin.gif");
		// setIconImage(miIcono);
		
	}
	




}