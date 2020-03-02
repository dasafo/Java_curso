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


package packGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;

public class pruebaGUI_122 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaGUI_122 frame = new pruebaGUI_122();
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
	public pruebaGUI_122() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JCalendar calendar = new JCalendar();
		contentPane.add(calendar, BorderLayout.NORTH);
	}

}
