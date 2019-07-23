package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class EventosFoco_35_II extends JFrame implements WindowFocusListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventosFoco_35_II miv=new EventosFoco_35_II();
		
		miv.iniciar();
		
		
	}
	
	public void iniciar() {
		
		marco1=new EventosFoco_35_II();
		marco2=new EventosFoco_35_II();
		
		marco1.setVisible(true);
		marco2.setVisible(true);
		
		marco1.setBounds(300, 100, 600, 350);
		marco2.setBounds(1200, 100, 600, 350);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);
		
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==marco1) {
			
			marco1.setTitle("Tengo el foco!!");
		}else {
			
			marco2.setTitle("Tengo el foco!!");
		}
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==marco1) {
			
			marco1.setTitle("");
		}else {
			
			marco2.setTitle("");
		}
	}

	EventosFoco_35_II marco1;
	EventosFoco_35_II marco2;
	
	
}
