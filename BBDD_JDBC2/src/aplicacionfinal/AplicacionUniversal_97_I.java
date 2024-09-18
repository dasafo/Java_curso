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
		
    // Para que nada mas abrir la lamina se conecte a la BBDD y nos de las
    // tablas disponibles, llamamos a los metodos que hacen eso
    //hacemos las llamadas de BBDD y Tablas antes de ActionListener
    //para que al arrancar la ventana el cuadro de texto JTextArea este vacia
    //y no con los datos de la tabla que aparece al principio en el JComboBox
		conectarBBDD(); 
		obtenerTablas();
		
    // Para que se mantenga a la escucha de eventos como cuando se elige
    // una opcion del desplegable de JComboBox
		comboTablas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {//metodo obligatorio de I_ActionListener
				// TODO Auto-generated method stub
				
        //Almazenamos en un String el elemento seleccionado en el JComboBox
				String nombreTabla=(String)comboTablas.getSelectedItem();
				
        //Lamamos al metodo que se encargaba de leer lo que hay dentro de una tabla
				mostrarInfoTabla(nombreTabla);
			}
			
			
		});
		
		add(comboTablas, BorderLayout.NORTH);
		
		}
	
	//-----------------------------------------------------------------------------
  // Creamos un metodo para conecctar con la BBDD cuya info se encuentra en un  
  // archivo .txt
	//-----------------------------------------------------------------------------
	public void conectarBBDD() {
		
		miConexion=null;
		//para que lea el archovo externo de datos(3 posiciones) en el .txt
    //la primera posicion/linea es la ruta a la BBDD
    //la segunda posicion/linea es el nombre de ususario
    //la tercera posicin/linea es la contraseña
		String datos[]=new String[3]; //para que lea el archovo externo de datos(3 posiciones)
		
		try {
			
			entrada=new FileReader("/home/david/Documents/GitHub/Java_curso/BBDD_JDBC2/datos_config.txt");
		
		}catch(IOException e) {
			
      //Queremos que salga una ventana emergente señalando el posible error
			JOptionPane.showMessageDialog(this, "No se encuentra el archivo!!");
			
      //------------------------------------------------------------------------------------------------
      //En caso que no se pueda abrir, vamos a permitir al usuario que eliga en el explorador de arvhios
      //donde se encuentra el archivo .txt con la informacion para acceder a la BBDD
			//---Este trozo de código esta copiado de la API de JFileChooser y ha sido modificado por nosotros----
			
			JFileChooser chooser = new JFileChooser();
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    		
		        "Archivos de Texto", "txt"); //queremos que busque archivos de texto .txt
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
           //ponemos getAbsolutPath para que guarde la ruta completa del lugar del archivo, que es lo que buscamos
		       //System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath()); 
       				
		    	try {
          // le indicamos la entrada/direccion del archivo .txt
					entrada=new FileReader(chooser.getSelectedFile().getAbsolutePath());

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //para que guarde en entrada la ruta del archivo escogido

		    
		    }
		    //-------------------------------------------------------------------------------------------------
						
		}
					
		try {
		  //creamos un flujo de datos/Stream que nos permita traer esos datos a nuestro programa
			BufferedReader mibuffer=new BufferedReader(entrada); 			

			for(int i=0;i<=2;i++) { //recorremos(leemos) los datos y los almacenamos en el array 'datos'
				
				datos[i]=mibuffer.readLine();
			}
			
			miConexion=DriverManager.getConnection(datos[0], datos[1], datos[2] );
			
			entrada.close();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			
		}
	
	
  //------------------------------------------------------------------------
  //Creamos otro metodo que sera la encargado de cargar los datos/tablas en 
  //el menu desplegable/JComboBox nada mas iniciar el programa
  //------------------------------------------------------------------------
	public void obtenerTablas() {
		
		ResultSet miResultSet=null;
		
		try {
			
			
      //Almacenamos los metadatos en la variable datos BBDD
			DatabaseMetaData datosBBDD=miConexion.getMetaData();
			
      //Almacenamos en el ResultSet todas las tablas que tengamos en los metadatos
      // --> Para MYSQL
			//miResultSet=datosBBDD.getTables(null, null, null, null);
      // --> Para PostgreSQL
			miResultSet = datosBBDD.getTables(null, "public", null, new String[]{"TABLE"});

      //Recorremos el ResultSet
			while(miResultSet.next()) {
				
				comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
			}
			
		}catch(Exception e) {
			
			
		}
		
	}
	
	
  //---------------------------------------------------------------------------------------
  //Este metodo que sera el encargado de ejecutar la sentencia SQL en la BBDD para 
  //devolvernos la info del contenido de la tabla seleccionada en el JComboBox/desplegable
  //----------------------------------------------------------------------------------------
	public void mostrarInfoTabla(String tabla) {
		
    // Como cada tablar tiene diferentes campos con diferentes longitudes elegimos un 
    // ArrayList para ir almacenando los campos
		ArrayList<String> campos=new ArrayList();
		
    // Nuestra consulta
		String consulta="SELECT * FROM " + tabla;
		
		try {
			
			areaInformacion.setText(""); //para que resetee el área al comenzar la aplicacion
			
			Statement miStatement=miConexion.createStatement();
			
			ResultSet miResultSet=miStatement.executeQuery(consulta);
			
      //Ahora con el objetivo de saber cuantas columnas tiene ese REsultSet necesitamos obtener cuantas
      //columnas hay y cual es el nombre de esas columnas, para ello obtenemos sus metadatos
			ResultSetMetaData rsBBDD=miResultSet.getMetaData();

			//con este bucle vamos almacenando todas los nombres de los campos de las columnas en el arrayList campos
      //getColumnCount no da en los metadatos cuantas columnas hay en total y getColumnLabel sus nombres
			for(int i=1;i<=rsBBDD.getColumnCount(); i++) { 				
				campos.add(rsBBDD.getColumnLabel(i)); 
        //Vamos almacenando en nuestro ArrayList campos el nombre de esos campos
				
			}
			
			while(miResultSet.next()) { //cuando entra lee el primer registro del REsultSet

				//le decimos que extraiga del array campos el primer campo(CODIGOARTICULO,...), luego el segundo.....
				for(String nombreCampo:campos) { 					
          //Añadimos al area del texto areaInformacion los resultados de las consultas
					areaInformacion.append(miResultSet.getString(nombreCampo) + " | ");
				}
				
        //Salto de linea para que aparezca cada resultado uno debajo del otro
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


		
