package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class TrabajandoFuentes_29_II {

	public static void main(String[] args) {
		
		//para saber las fuentes que tenemos en el ordenador instaladas:
		
		String fuente=JOptionPane.showInputDialog("Introduce fuente");
		
		boolean estalafuente=false;
		
		String [] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String nombredelafuente: nombresDeFuentes) {		
			
			if(nombredelafuente.equals(fuente)) {
				estalafuente=true;
			}
			
		}
		
		if(estalafuente) {
			
			System.out.println("Fuente instalada");
		}else {
			
			System.out.println("Fuente no instalada");
		}
		
	}
}
