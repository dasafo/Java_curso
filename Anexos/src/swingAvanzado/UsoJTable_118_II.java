package swingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UsoJTable_118_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new MarcoTablaPersonalizado();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoTablaPersonalizado extends JFrame{
	
	public MarcoTablaPersonalizado() {

		
		setTitle("Tabla Personalizada");
		setBounds(300,300,400,200);
		
		TableModel mimodelo=new ModeloTablaPersonalizada();
		
		JTable mitabla=new JTable(mimodelo);
		
		add(new JScrollPane(mitabla));
		
	}
		
}

class ModeloTablaPersonalizada extends AbstractTableModel{

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 5; 								//devuelve 5 filas
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;							//devuelve 3 columnas
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		int x=rowIndex+1;
		
		int y=columnIndex+2;
		
		return " " + x + ", " + y;
		
	}
	
	public String getColumnName(int c) {
		
		return "Columna " + c;
	}
	
	
}
