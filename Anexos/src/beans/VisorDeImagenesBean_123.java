/****************************** Los BEANS ***************************************
 * 
 * - Un Bean es un componente creado en Java que puede ser reutilizado y
 *   manipulado visualmente desde un entorno de desarrollo.
 *   
 * - Una vez se tiene acceso al 'bean', se usa arrastrando el componente hasta
 *   la interfaz grafica. Despues se puede adaptar a nuestras necesidades
 *   usando cuadros de dialogo.
 * 
 *****************************************************************************/

package beans;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta clase pretende construir un Bean para incluir imagenes
 * @author david
 *
 */

public class VisorDeImagenesBean_123 extends JLabel{
	
	public VisorDeImagenesBean_123() {
		
		setBorder(BorderFactory.createEtchedBorder());
	}

	/**
	 * 
	 * Metodo clave para escoger imagen desde disco duro
	 * @param elegirImagen. Este parametro te permitira escoge una imagen
	 */
	
	public void setEscogeImagen(String elegirImagen) {
		
		try {
			
			archivo=new File(elegirImagen);
			
			setIcon(new ImageIcon(ImageIO.read(archivo)));
			
			
		}catch(IOException e) {
			
			archivo=null;
			
			setIcon(null);
		}
		
		
		
	}
	
	/**
	 * 
	 * 
	 * @return Devuelve la ruta de la imagen escogida con setEscogeimagen
	 * @param no recibe nada
	 */
	
	public String getEscogeImagen() {
		
		if(archivo==null) return null;
		
		else return archivo.getPath();
	}
	
	public Dimension getPreferredSize() {
		
		return new Dimension(600,400);
	}
	
	/**
	 * El tamaño maximo en Mb de la imagen 
	 */
	
	public static int PruebaConstante=5;
	
	private File archivo=null;
	
}
