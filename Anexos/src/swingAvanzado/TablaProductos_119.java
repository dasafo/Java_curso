package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TablaProductos_119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new MarcoProductos();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}

class MarcoProductos extends JFrame{
	
	public MarcoProductos() {
		
		setTitle("Productos");
		
		setBounds(500,300,800,400);
		
		JPanel superior=new JPanel();
		
		nombresDeTablas=new JComboBox();
		
		try {
			
			miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?useSSL=false", "root", "Kromosoma_85" );
			
			datosBBDD=miconexion.getMetaData();
			
			rs=datosBBDD.getTables(null, null, null, null);
			
			while(rs.next()) {
				
				nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		nombresDeTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String tablaSeleccionada=(String)nombresDeTablas.getSelectedItem();
				
				String consulta="SELECT * FROM " + tablaSeleccionada;
				
				try {
				
				sentencia=miconexion.createStatement();
				
				rs=sentencia.executeQuery(consulta);
				
				/*while(rs.next()) {
					
					System.out.println(rs.getString("NOMBREARTÍCULO") + " " + rs.getString("CÓDIGOARTÍCULO"));
				}*/
				
				modelo=new ResultSetModeloTabla(rs);
				
				JTable tabla=new JTable(modelo);
				
				add(new JScrollPane(tabla), BorderLayout.CENTER);
				
				validate(); //para que lo pinte
				
				}catch(Exception e2) {
					
					e2.printStackTrace();
				}
				
			}
			
		});
		
		
		superior.add(nombresDeTablas);
		
		add(superior, BorderLayout.NORTH);
		
	}
	
	private JComboBox nombresDeTablas;
	
	private DatabaseMetaData datosBBDD;
	private ResultSet rs;
	private Connection miconexion;
	
	private Statement sentencia;
	
	private ResultSetModeloTabla modelo;
	
	
}


class ResultSetModeloTabla extends AbstractTableModel{
	
	public ResultSetModeloTabla(ResultSet unResultset) {
		// TODO Auto-generated constructor stub
		
		rsRegistros=unResultset;
		
		try {
			resmd=rsRegistros.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		try {
			rsRegistros.last();
			
			return rsRegistros.getRow();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return resmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		try {
			
			rsRegistros.absolute(rowIndex +1);
			
			return rsRegistros.getObject(rowIndex + 1);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
	}
	
	public String getColumnName(int c) {
		
		try {
			
			return resmd.getColumnName(c+1);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
	}
	
	private ResultSet rsRegistros;
	
	private ResultSetMetaData resmd;
	
	
}





