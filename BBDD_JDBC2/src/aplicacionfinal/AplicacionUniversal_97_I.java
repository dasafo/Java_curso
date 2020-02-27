package aplicacionfinal;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;




public class AplicacionUniversal_97_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoBBDD mimarco=new MarcoBBDD();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame{

	public MarcoBBDD(){
		
		setBounds(300,300,700,700);
		
		LaminaBBDD milamina=new LaminaBBDD();
		
		add(milamina);
		
	}	
	
}

class LaminaBBDD extends JPanel{
	
	public LaminaBBDD(){
		
		setLayout(new BorderLayout());
		
		comboTablas=new JComboBox();
		
		areaInformacion=new JTextArea();
		
		add(areaInformacion,BorderLayout.CENTER);		
		
		conectarBBDD(); //hacemos las llamadas de BBDD y Tablas antes de ActionListener
		
		obtenerTablas();
		
		comboTablas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String nombreTabla=(String)comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombreTabla);
			}
			
			
		});
		
		add(comboTablas, BorderLayout.NORTH);
		
		}
	
	
	
	public void conectarBBDD() {
		
		miConexion=null;
		
		String datos[]=new String[3]; //para que lea el archovo externo de datos(3 posiciones)
		
		try {
			
			entrada=new FileReader("/home/david/Documents/Programacion_PildorasInformaticas/Java/eclipse-workspace/BBDD_JDBC2/datos_config.txt");
		
		}catch(IOException e) {
			
			JOptionPane.showMessageDialog(this, "No se encuentra el archivo!!");
			
			//---Este trozo de código esta copiado de la API de JFileChooser y ha sido modificado por nosotros----
			
			JFileChooser chooser = new JFileChooser();
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    		
		        "Archivos de Texto", "txt"); //queremos que busque archivos de texto .txt
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		       //System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath()); //ponemos getAbsolutPath para que guarde la ruta completa del lugar del archivo, que es lo que buscamos
				
		    	try {
					entrada=new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //para que guarde en entrada la ruta del archivo escogido

		    
		    }
		    //----------------------------------------------------------------------
						
		}
					
		try {
					
			BufferedReader mibuffer=new BufferedReader(entrada); //creamos un flujo de datos que nos permita traer esos datos a nuestro programa
			
			for(int i=0;i<=2;i++) { //recorremos(leemos) los datos y los almacenamos en el array 'datos'
				
				datos[i]=mibuffer.readLine();
			}
			
			miConexion=DriverManager.getConnection(datos[0], datos[1], datos[2] );
			
			entrada.close();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			
		}
	
	

	public void obtenerTablas() {
		
		ResultSet miResultSet=null;
		
		try {
			
			
			DatabaseMetaData datosBBDD=miConexion.getMetaData();
			
			miResultSet=datosBBDD.getTables(null, null, null, null);
			
			while(miResultSet.next()) {
				
				comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
			}
			
		}catch(Exception e) {
			
			
		}
		
	}
	
	
	public void mostrarInfoTabla(String tabla) {
		
		ArrayList<String> campos=new ArrayList();
		
		String consulta="SELECT * FROM " + tabla;
		
		try {
			
			areaInformacion.setText(""); //para que resetee el área al comenzar la aplicacion
			
			Statement miStatement=miConexion.createStatement();
			
			ResultSet miResultSet=miStatement.executeQuery(consulta);
			
			ResultSetMetaData rsBBDD=miResultSet.getMetaData();
			
			for(int i=1;i<=rsBBDD.getColumnCount(); i++) { //con este bucle vamos almacenando todas los nombres de los campos de las columnas en el arrayList campos
				
				campos.add(rsBBDD.getColumnLabel(i));
				
			}
			
			while(miResultSet.next()) { //cuando entra lee el primer registro del REsultSet
				
				for(String nombreCampo:campos) { //le decimos que extraiga del array campos el primer campo(CODIGOARTICULO,...), luego el segundo.....
					
					areaInformacion.append(miResultSet.getString(nombreCampo) + " ");
				}
				
				areaInformacion.append("\n");
			}
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	private JComboBox comboTablas;

	private JTextArea areaInformacion;
	
	private Connection miConexion;
	
	private FileReader entrada;
	
	
	
}


		
