package swingAvanzado;


import java.awt.*;

import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class pruebaLista_116_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new MarcoDeLista();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoDeLista extends JFrame{
	
	public MarcoDeLista() {
		
		setTitle("Prueba de lista");
		
		setBounds(400,300,400,300);
		
		String [] meses= {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
							"Septiembre", "Octubre", "Noviembre", "Diciembre"
		};
		
		listaDeMeses=new JList<String>(meses);
		
		listaDeMeses.setVisibleRowCount(4);
		
		JScrollPane laminaDeDesplazamiento=new JScrollPane(listaDeMeses);
		
		laminaDeLista=new JPanel();
		
		laminaDeLista.add(laminaDeDesplazamiento);
		
		listaDeMeses.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				List<String> valores=listaDeMeses.getSelectedValuesList();
				
				StringBuilder texto=new StringBuilder("Mes seleccionado: ");
				
				for(String elemento: valores) {
					
					String palabra=elemento;
					
					texto.append(palabra);
					
					texto.append(" ");
				}
				
				rotulo.setText(texto.toString());
				
			}
		});
		
		laminaDeTexto=new JPanel();
		
		rotulo=new JLabel("Mes seleccionado: ");
		
		laminaDeTexto.add(rotulo);
		
		add(laminaDeLista, BorderLayout.NORTH);
		
		add(laminaDeTexto, BorderLayout.SOUTH);
		
	}
	
	
	private JList<String> listaDeMeses;
	
	private JPanel laminaDeLista, laminaDeTexto;
	
	private JLabel rotulo;
	
	
	
	
}
