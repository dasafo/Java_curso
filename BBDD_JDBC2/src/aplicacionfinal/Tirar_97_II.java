package aplicacionfinal;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Tirar_97_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco mimarco=new Marco();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//---Este trozo de código esta copiado de la API de JFileChooser y ha sido modificado por nosotros----
		
		JFileChooser chooser = new JFileChooser();
		
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	    		
	        "Archivos de Texto", "txt"); //queremos que busque archivos de texto .txt
	    
	    chooser.setFileFilter(filter);
	    
	    int returnVal = chooser.showOpenDialog(mimarco);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	
	       System.out.println("You chose to open this file: " +
	       
	            chooser.getSelectedFile().getAbsolutePath()); //ponemos getAbsolutPath para que guarde la ruta completa del lugar del archivo, que es lo que buscamos
	    }
	    //----------------------------------------------------------------------
	}

}



class Marco extends JFrame{
	
	public Marco() {
		
		setBounds(300, 300, 300, 300);
		
		setVisible(true);
		
		}
}
