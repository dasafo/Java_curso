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

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UsoBeanPropio_124 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsoBeanPropio_124 frame = new UsoBeanPropio_124();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsoBeanPropio_124() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 800, 600);
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		VisorDeImagenesBean_123 visorDeImagenesBean_123 = new VisorDeImagenesBean_123();
		visorDeImagenesBean_123.setEscogeImagen("/home/david/Pictures/marx_PavoCallate.jpg");
		visorDeImagenesBean_123.setBounds(128, 12, 560, 312);
		contentPane.add(visorDeImagenesBean_123);
	}
}
