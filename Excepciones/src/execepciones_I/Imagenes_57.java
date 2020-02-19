/**************************************Jerarquía de errores*************************************
 * 
 * -En tiempo de compilación: Errores de sintaxis del programador (falta ;, falta llave,...)
 * -En tiempo de ejecución:
 * 		-> C_Throwable (es la (super)clase que maneja los errores en Java)
 *			--> C_Error (errores de HArdware (poco espacio en en el PC,...))
 *			--> C_Exception:
 *				---> C_IOException: 
 *								Excepciones comprobadas, no son culpa del programador, 
 *								y estamosobligados a caputarlas con un try-catch.
 *								(Alguien ha movido una imagen de una carpeta,...)
 *				---> C_RuntimeException 
 *								Excepciones NO comprobadas, culpa del programador y no estamos
 *								obligados a caputarlas, esto queda a merced del programador.
 * 								(Tamaño del array erróneo,...)
 *  
 *  -throws: Se usa para indicar a un metodo que va a lanzar un error (que se debe o no capturar)
 *  		 Ej: static void metodo() throws NombreDeLaExcepcion{..}			
 *  -throw: (SIN S) Se usa en cualquier parte del codigo para indicar que en ese punto se 
 *  		lanza una excepcion

 * C=Clase
 ***********************************************************************************************/

package execepciones_I;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.InputMismatchException;


public class Imagenes_57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoImagen mimarco=new MarcoImagen();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}


class MarcoImagen extends JFrame{
	
	public MarcoImagen() {
	
	setTitle("Prueba con Imagen");
	setBounds(750, 300, 500, 500);
	
	LaminaConImagen milamina=new LaminaConImagen();
	
	add(milamina);
	
	milamina.setForeground(Color.PINK);  //Para establcer un color unificado en el frame
	
	}	
}


class LaminaConImagen extends JPanel{
	
	public LaminaConImagen() {
		
		//Estamos obligados a lanzar una excepcion
				try {
					//Ponemos mal el nombre del archivo, en este casi es un error no comprobado 
					//que hemos subsanado en el if, else de abajo(mal programado)
				imagen=ImageIO.read(new File("src/execepciones_I/bolaAzullllll.gif")); 
				}
				catch(IOException e) {
					
					System.out.println("La imagen no se encuentra");
				}
				
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		/*Si no encuentra la imagen entonces imagen=null. Enonces nos arrojaría un error tipo
		NullPointerException, que hereda de RuntimeException, que es una excepción no controlada
		por lo que no estamos obligados a caputrar este error. Pero aún así lo vamos a
		hacer manualmente.
		*/
		if(imagen==null) {
			
			g.drawString("No se puede cargar la imágen", 10, 10);
		
		}else {
			
		// File miimagen=new File("src/graficos/redstar.png");
		
		int anchuraImagen=imagen.getWidth(this);
		
		int alturaImagen=imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null);
		
		//hacemos un mosaico con la imagen
		for(int i=0;i<300;i++) {
			
			for(int j=0;j<350;j++) {
				if(i+j>0) {
				
				g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
				}
			}
		 }
		}
		
	}
	
	private Image imagen;
	
	
}
