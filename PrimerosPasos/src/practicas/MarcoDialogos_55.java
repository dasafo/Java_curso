package practicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Date;




// **** CLASE PRINCIPAL para crear el Frame principal donde iran las laminas ****
// ******************************************************************************

public class MarcoDialogos_55 extends JFrame {

	public MarcoDialogos_55() {
		
		setTitle("Prueba diálogos");
		setBounds(500,300,600,450);
		
		//-- Creamos la LAMINA SUPERIOR de tipo GridLayout en la parte superior ---
    //--------------------------------------------------------------------------
		JPanel laminaCuadricula=new JPanel();
		laminaCuadricula.setLayout(new GridLayout(2,3));
		
		
		//creamos un array para los titulos del PRIMER BoxLayout(cuya plantilla está en LaminaBotones_55)
		String primero[]= {"Mensaje", "Confirmar", "Opción", "Entrada"}; 
		laminaTipo=new LaminaBotones_55("Tipo",primero); //hacemos uso de esa plantilla de LaminaBotones_55
		
		//Creamos otro array para el SEGUNDO BoxLayout pero de otra forma mas simplificada
		//(hace los mismo que arriba)
		laminaTipoMensajes=new LaminaBotones_55("Tipo de Mensaje", new String[] { 
				
				"ERROR_MESSAGE",
				"INFORMATION_MESSAGE",
				"WARNING_MESSAGE",
				"QUESTION_MESAGGE",
				"PLAIN_MESSAGE"
		});
		
		//Creamos otro array para el TERCER BoxLayout
		laminaMensaje=new LaminaBotones_55("Mensaje", new String[] { //hace lo mismo que en laminaTipo pero mas simplificado
				
				"Cadena",
				"Icono",
				"Componente",
				"Otros",
				"Objects[ ]"
		});
		
		//Creamos otro array para el CUARTO BoxLayout
		laminaTipoOpcion=new LaminaBotones_55("Mensaje", new String[] { //hace lo mismo que en laminaTipo pero mas simplificado
				
				"DEFAULT_OPTION",
				"YES_NO_OPTION",
				"YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION"
		});

		//Creamos otro array para el QUINTO BoxLayout
		laminaOpciones=new LaminaBotones_55("Mensaje", new String[] { //hace lo mismo que en laminaTipo pero mas simplificado
		
				"String[ ]",
				"Icon[ ]",
				"Objects[ ]"
		});

		//Creamos otro array para el SEXTO BoxLayout
		laminaEntrada=new LaminaBotones_55("Entrada", new String[] { //hace lo mismo que en laminaTipo pero mas simplificado
		
				"Campo de texto",
				"Combo"
		});
		
		setLayout(new BorderLayout()); //Ponemos un BorderLayout dentro del marco para poder agregar la laminaMostrar que ira debajdo de laminaCuadricula
		
		
		laminaCuadricula.add(laminaTipo); //añadimos al GridLayout laminaTipo
		laminaCuadricula.add(laminaTipoMensajes);
		laminaCuadricula.add(laminaMensaje);
		laminaCuadricula.add(laminaTipoOpcion);
		laminaCuadricula.add(laminaOpciones);
		laminaCuadricula.add(laminaEntrada);

    //ponemos el gridLayout en el centro de un BorderLayout
		add(laminaCuadricula, BorderLayout.CENTER); 



		//------ Contruimos la LAMINA INFERIOR -----
    //------------------------------------------

		JPanel laminaMostrar=new JPanel(); //Creamos la lamina donde ira el boton Mostrar
		
		JButton botonMostrar=new JButton("Mostrar"); //Creamos el boton Mostrar
		
		botonMostrar.addActionListener(new AccionMostrar()); //Dejamos el boton a la escucha de la clase AccionMostrar()
		
		laminaMostrar.add(botonMostrar); //añadimos el boton a la lamina
		
		add(laminaMostrar, BorderLayout.SOUTH); //ponemos la lamina al Sur del BorderLayout global
		
		//-------------------------------------------

				
	}
	
	
	//-------------- Metodo que PROPORCIONA EL MENSAJE -------------------------
  //--------------------------------------------------------------------------
	
	public Object dameMensaje() { // Creamos un metodo de tipo object
		
		String s=laminaMensaje.dameSeleccion(); //alamcenamos la opcion seleccionada
		
		if(s.equals("Cadena")) {
			
			return cadenaMensaje;
			
		}else if(s.equals("Icono")){
			
			return iconoMensaje;
			
		}else if(s.equals("Componente")){
			
			return componenteMensaje;
			
		}else if(s.equals("Otros")){
			
			return objetoMensaje;
			
		}else if(s.equals("Objects[ ]")){
			
			return new Object[] {
					
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
			
		}else {
			
			return null;
		}
				
	}
	
	//---- Metodo que DEVUELVE TIPO MENSAJES y numero de botones en CONFIRMAR -------
  //---- Es el tipo de icono que sale, el tipo de error/icono viene dado por un ---
  //---- entero en el return ------------------------------------------------------
  //-------------------------------------------------------------------------------
	
	public int dameTipo(LaminaBotones_55 lamina) {
		
		String s=lamina.dameSeleccion(); //almacena en s lo que el usuario ha escogido en la caja Tipo Mensajes
		
		if(s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) {
			
			return 0;
			
		}else if(s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {
		
			return 1;
			
		}else if(s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) {
		
			return 2;
			
		}else if(s.equals("QUESTION_MESSAGE")) {
		
			return 3;
			
		}else if(s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")) {
		
			return -1;
		}else {
			
			return 0;
		}
		
	}
	
	//------------ Metdo que DA OPCIONES A LA LAMINA OPCION ---------------------
  //---------------------------------------------------------------------------
	
	public Object[] dameOpciones(LaminaBotones_55 lamina) {
		
		String s=lamina.dameSeleccion();
		
		if(s.equals("String[ ]")) {
			
			return new String[] {"Amarillo", "Azul", "Rojo"};
		
		}else if(s.equals("Icon[ ]")) {
			
			return new Object[] {new ImageIcon("src/graficos/bolaAzul.gif"), new ImageIcon("src/graficos/bolaAmarilla.gif"), new ImageIcon("src/graficos/bolaRoja.gif")};
		
		}else if(s.equals("Objects[ ]")){
			
			return new Object[] {
					
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
		
		}else {
			
			return null;
		}
		
	}
	
	
	
	
	//---- CLASE INTERNA de MarcoDialogos_55 para gestionar los eventos ----
  //**********************************************************************
  private class AccionMostrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//System.out.println(laminaTipo.dameSeleccion()); //para que nos diga el texto que hay seleccionado(el nombre del radiobutton de la primera lamina(laminTipo))
			
			/*
			 Queremos que nos muestre un el tipo JOptionPane seleccionado de los 4 que 
			 hay(showMessageDialog, showInputDialog,showConfirmDialog,showOptionDialog)
			*/
			if(laminaTipo.dameSeleccion().equals("Mensaje")) {
				
				JOptionPane.showMessageDialog(MarcoDialogos_55.this, dameMensaje(), "Título", dameTipo(laminaTipoMensajes)); //This para indicar el marco padre
				
			}else if(laminaTipo.dameSeleccion().equals("Confirmar")) {
				
				JOptionPane.showConfirmDialog(MarcoDialogos_55.this, dameMensaje(), "Título", dameTipo(laminaTipoOpcion), dameTipo(laminaTipoMensajes));
				
			}else if(laminaTipo.dameSeleccion().equals("Entrada")) {
				
				if(laminaEntrada.dameSeleccion().equals("Campo de texto")) {
				
				JOptionPane.showInputDialog(MarcoDialogos_55.this, dameMensaje(), "Título", dameTipo(laminaTipoMensajes));
				
				}else {
					
					JOptionPane.showInputDialog(MarcoDialogos_55.this, dameMensaje(), "Título", dameTipo(laminaTipoMensajes), null, new String[] {"Amarillo", "Azul", "Rojo"}, "Azul");
				}
			
			}else if(laminaTipo.dameSeleccion().equals("Opción")) {
				
				JOptionPane.showOptionDialog(MarcoDialogos_55.this, dameMensaje(), "Título", 1, dameTipo(laminaTipoMensajes), null, dameOpciones(laminaOpciones), null);
			}
			
			
			
		}
		
		
	}
	
	private LaminaBotones_55 laminaTipo; //nombre de la primera caja
	private LaminaBotones_55 laminaTipoMensajes;
	private LaminaBotones_55 laminaMensaje;
	private LaminaBotones_55 laminaTipoOpcion;
	private LaminaBotones_55 laminaOpciones;
	private LaminaBotones_55 laminaEntrada;

  // Variables para crear objetos en el panel de Mensaje
	private String cadenaMensaje="Mensaje";
	private Icon iconoMensaje=new ImageIcon("icons.png");
	private Object objetoMensaje=new Date();
	private Component componenteMensaje=new LaminaEjemplo();
	
	
	
}

//Creamos una clase para que dibuje una lamina coloreada en amarillo
//******************************************************************
class LaminaEjemplo extends JPanel{
	
	public void paintComponent(Graphics g) {

		// Llamamos al metodo padre de paintComponent
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g; //castin
		
		//para que tenga las mismas dimensiones que la lamina (getWidth(), getHeight
		Rectangle2D rectangulo=new Rectangle2D.Double(0,0, getWidth(), getHeight()); 
		
		g2.setPaint(Color.YELLOW);
		
		g2.fill(rectangulo);
	}
}





