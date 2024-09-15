package conectaBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AplicacionConsulta_90 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
    
	  // Ponemos el boton Consulta a la escucha	
		botonConsulta.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		//---------------------- CONEXION BASE DE DATOS(ver arvhicos justo anteriores para ver) -------------------------
		
		try {
						
			// 1. Crear Conexion
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );
			
			// 2. Crear objeto Statement
			Statement sentencia=miConexion.createStatement();
			
			//------------Primer JComboBox(Secciones) de BorderLayout.North--------------
			String consulta="SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS"; //EN sqL ponemos DitinctRow para que no repita secciones 
			
			// 3. Ejecutar SQL
			ResultSet rs=sentencia.executeQuery(consulta);
			
			// 4. REcorrer el REsultSet
			while(rs.next()) {
				
				secciones.addItem(rs.getString(1)); 
        //añadir al primer ComboBox de BorderLayout.North la primera columna
        //de PRODUCTOS-Seccion. Secciones es el nombre del primer ComboBox
			}
			
			rs.close();
			
			//------------Segundo JComboBox(Paises DE ORIGEN) de BorderLayout.North--------------

			consulta="SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS"; //EN sqL ponemos DitinctRow para que no repita secciones 
			
			rs=sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				
				paises.addItem(rs.getString(1)); 
        //añadir al primer ComboBox de BorderLayout.North la primera columna
        //de PRODUCTOS-Seccion. 'paises' es el nombre del segundo ComboBox
			}
			
			rs.close();
			//-----------------------------------------------------------------------

		}catch(Exception e) {
			System.out.println("No hay conexion!!");
		}
		
		
	}//aqui termina el Constructor	
	
	
	private void ejecutaConsulta() {
		
		ResultSet rs=null;
	
		try {
			
			resultado.setText(""); //cada vez que pulsamos Consulta el flujo pasa primero por aqui y 'limpia' la pantalla primero
		
			String seccion=(String)secciones.getSelectedItem(); //guaramos en la variable seccion el elemento seleccionado en el desplegable
			String pais=(String)paises.getSelectedItem();
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) { 	//si NO está seleccionado Todos en seccion pero SI en paises, haz...

			   // Creamos una consulta preparada y almacenar esa consulta preparada en consultaPreparada
				// y pasar como paramentro la variable parametrizada consultaSeccion
				enviaConsultaSeccion=miConexion.prepareStatement(consultaSeccion); 

        //pasamos por parametro el valor del primer ?
        //y el valor seleccionado en el desplegable, valor guardado en la variable seccion
				enviaConsultaSeccion.setString(1, seccion); 
			
				rs=enviaConsultaSeccion.executeQuery(); //ejecutamos la consulta
			
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) { //sino, si SI esta seleccionado Todos en seccion y NO esta seleccionado en paises, haz...
				
				enviaConsultaPais=miConexion.prepareStatement(consultaPais); //creamos una consulta preparada y almacenar esa consulta preparada en consultaPreparada
				   															 //y pasar como paramentro la variable parametrizada consultaPais
				enviaConsultaPais.setString(1, pais); //pasamos por parametro el valor

				rs=enviaConsultaPais.executeQuery(); //ejecutamos la consulta

				
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")) { //sino, si ambos deplegables son diferentes de Todos, haz...
				
				enviaConsultaTodos=miConexion.prepareStatement(consultaTodos); //creamos una consulta preparada y almacenar esa consulta preparada en consultaPreparada
					 															//y pasar como paramentro la variable parametrizada consultaPais
				enviaConsultaTodos.setString(1, seccion); //pasamos por parametro el valor
				enviaConsultaTodos.setString(2, pais);

				rs=enviaConsultaTodos.executeQuery(); //ejecutamos la consulta
				
				
			}
			
			while(rs.next()) {//recorremos el ResultSet para que nos añada la primera fila
				
				//vamos añadiento a JTextArea(resultado): 
				resultado.append(rs.getString(1)); //me agregas lo que hay en la primera columna(NOMBREARTICULO)
				resultado.append(", ");
				resultado.append(rs.getString(2)); //SECCION
				resultado.append(", ");
				resultado.append(rs.getString(3)); //PRECIO
				resultado.append(", ");
				resultado.append(rs.getString(4)); //PAISDEORIGEN
				resultado.append("\n"); //salto de línea

				
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Error en la consulta");
		}
	
		
		
	}
	
		
	private Connection miConexion;

	private PreparedStatement enviaConsultaSeccion;
	
	private PreparedStatement enviaConsultaPais;
	
	private PreparedStatement enviaConsultaTodos;

	private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	
	private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	
	private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";

	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	

	
}


