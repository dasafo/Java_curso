/******************************************************************************
 * - Un Socket es un puente virtual que conecta a un Cliente y un Servidor,
 *   a través del cual circualrá la información entre ambos.
 * - Para construir un Socket necesitamos:
 * 
 * 		1- Aplicación Cliente: OutputStream
 * 		2- Aplicación Servidor: InputStream
 * 		3- Dirección del Servidor (ip o dominio)
 * 		4- Puerto de recepción
 * 
 ******************************************************************************/
/*
 * Ejercicio que consiste en crear un Chat donde un usuario deba introducir su Nick,
 * dirección IP del Cliente destinatario y el mensaje de texto que quiere enviar a esa IP.
 * Este mensaje pase por un servidor y este servidor lo envie al cliente destinatario.
 *
 * 1- Cuando se inicia el cliente, se envia automaticamente dentro de un
 * objeto(PaqueteEnvio) el nick, y un texto(" online"), la ip y el ArrayList
 * estan vacios en principio, dicho paqeute indicara al Server que nuestro
 * cliente esta activo.
 *
 * 2- El Server recibe este paquete y es capaz de identificar la ip de este cliente
 * de esta forma avisa al resto de clientes activos que hay un cliente con dicha ip,
 * El server creara otro socket para enviar a cada cliente activo la lista con las
 * ips activas para que esten en el desplegable del cliente
 *
 * 3- Desde el Cliente mandaremos un objeto(PaqueteEnvio) con la ip, nick y texto
 * que se envia, para ello lo Serializamos(pasamos a bytes)
 * 
 * 4- En el Servidor creamos otro objeto(PaqueteREcibido) para que recoja el paquete
 * serializado que le llega desde el Cliente(como pasa en los pasos previos pero ya 
 * para la comunicacion y no para avisar de que hay un cliente nuevo)
 * 
 * 5- HAcer lo mismo que en 2, pero para el Cliente que recibe finalmente el mensaje
 */
/* habria que hacer un ejecutable de este archivo(File----->export---->Java/Runneable JAR file) 
 * y meterla en otro PC o Maquina virtual y comprobar que funciona
 */


package david.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;
import java.io.*;

public class ChatCliente_86_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		
		addWindowListener(new EnvioOnline()); //Asi nada mas se abra la ventana se ejecuta windowOpened(avisa de que está online enviando el paquete creado en dicha clase abajo)
		}	
	
}


//----------------ENVIO DE SEÑAL ONLINE--------------------
// Esta clase sera la encargada de enviar un paquete al Server
// que permita crear la conexion con este a traves de un Socket, en 
// nuestro caso "la señal" sera el momento en que se abre la ventana del 
// chat del cliente. Todo esto se hace para indicar al Server que el cliente
// esta activo y este puede proceder a obtener el IP del cliente activo
class EnvioOnline extends WindowAdapter{ //clase adaptadora que implementa todos los metodos de una interfaz, en este caso de WindowListener
	
	public void windowOpened(WindowEvent e) { //cuando se crea la ventana....
		
		try {
			//establecemos una conexion(socket) con el servidor
			Socket misocket=new Socket("192.168.1.90",9999); 	//Datos del Server(ip, puerto)		

      // Creamos un paquete que sera el q se envie al Server para indicarle
      // que el cliente esta activo
			PaqueteEnvio datos=new PaqueteEnvio();
			
      //Metenmos esta palabra en el paquete que ira al Server
			datos.setMensaje(" online");
			
      //Ahora como siempre una vez creado el socket generamos el flujo/stream 
      //de datos hacia el server para mandar este paquete
			ObjectOutputStream paqueteDatos=new ObjectOutputStream(misocket.getOutputStream()); //creamos flujo de datos
			
      //indicamos que dentro de ese flujo metemos el paquete datos
			paqueteDatos.writeObject(datos);
			
			misocket.close();
			
		}catch(Exception e2) {}
	}
	
}

//---------------------------------------------------------



class LaminaMarcoCliente extends JPanel implements Runnable{ 
  //implementamos Runnable para crear un hilo para que esté permanentemente 
  //a la escucha para que reciba los datos reenviados por parte del Servidor,
  //info que viene del otro cliente con el que estamos chateando
	
	public LaminaMarcoCliente(){

	  //PAra que introduzcamos el nick, saldra al principio una ventana emergente
    //JOptionPane para introducirlo
		String nick_usuario=JOptionPane.showInputDialog("Nick: ");
		
    // Al meter el nick, este aparecera en nuestra cabecera del chat en un JPanel
		JLabel n_nick=new JLabel("Nick: ");
		
		add(n_nick);
		
		nick=new JLabel();
		
    //guardamos en el JPanel del nick el nick del usuario introducido
		nick.setText(nick_usuario);
		
		add(nick);
		
		JLabel texto=new JLabel("Online: ");
		
		add(texto);
		
    // Creamos un un menu desplegable JComboBox para almacenar las ip activas
		ip=new JComboBox();
		
		/*ip.addItem("Usuario1");
		ip.addItem("Usuario2");
		ip.addItem("Usuario3");*/
		
		// ip.addItem("192.168.1.90");
		// ip.addItem("192.168.1.91");

		add(ip);
		
		campochat=new JTextArea(12,20);

		add(campochat);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		EnviaTexto evento=new EnviaTexto();
		
		miboton.addActionListener(evento);
		
		add(miboton);	
		
		Thread mihilo=new Thread(this); //creamos el hilo que estará a la escuhca constantemente esperando info del Servidor. This porque es esta clase la que tiene el hilo
		
		mihilo.start(); //arrancamos el hilo
		
		
	}
	

  // ---------- Esa clase administrara los eventos
  // -------------------------------------------------------------
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				// este metodo es el encargado de la accion de los eventos	

			try {
				Socket misocket=new Socket("192.168.1.90", 9999); //instanciamos el flujo(Socket)
				
				//creamos un paquete 'datos'(Object) y enpaquetamos el nick, ip y
        //el mensaje del cuadro de texto
				PaqueteEnvio datos=new PaqueteEnvio(); 
				
				//el cuadro de texto se llamaba nick(JTextField), lo caputra(getText())
        //y se lo manda a la variable nick(no confundir con el JTextField con
        //el mismo nombre)
				datos.setNick(nick.getText()); 
        // Lo mismo pero ahora con el menu desplegable con las ips, con
        // getSelectedItem le indicamos cual es el elemento seleccionado
        // en el JComboBox/desplegable,esto devuelve un objeto
        // y lo pasamos a String
				datos.setIp(ip.getSelectedItem().toString());

				datos.setMensaje(campo1.getText()); //lo mismo para el cuadro de texto
				
				//Creamos el flujo de salida paqueteDatos para enviar el paquete 'datos'
				ObjectOutputStream paqueteDatos=new ObjectOutputStream(misocket.getOutputStream()); 
				//le decimos que el paquete datos es el que viajará a través del flujo de salida paqueteDatos
				paqueteDatos.writeObject(datos); // metemos la informacion en paqueteDatos 
				misocket.close(); //cerramos el flujo de salida
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage()); 			}
		
		}
		
	}
		
		
		
	private JTextField campo1;
	private JComboBox ip;
	private JLabel nick;
	private JTextArea campochat;
	private JButton miboton;

	
	
	@Override
	public void run() { 
    //este metodo viene de la Interfaz Runnable (por lo tanto obligatorio)
    //y al igual que se hace en el Server, este tendra que estar a la escucha
    //para recoger la info que le venga del Server, q a su vez viene del otro
    //cliente que es con quien realmente chateamos
		
		try {
			
			ServerSocket servidorCliente=new ServerSocket(9099); //creamos un flujo que conecte el puerto 9099 del Servidor con nuestro cliente
			
			Socket cliente; // creamos un socket por donde vendra el paquete del Server
			PaqueteEnvio paqueteRecibido; //aqui almacenaremos el paquete recibido
			
			while(true) { //para que este siempre a la escucha, bucle infinito
				
				cliente=servidorCliente.accept(); //para que acepte todas las conexiones que le lleguen del exterior(en nuestro caso del Server)
				
				ObjectInputStream flujoEntrada=new ObjectInputStream(cliente.getInputStream()); //creamos un flujo de entrada capaz de trasportar objetos(paquete de datos)
				
				paqueteRecibido=(PaqueteEnvio)flujoEntrada.readObject(); //para que almacene en paqueteRecibido el paquete que le llega
				

        // Ahora vamos a diferenciar al igual que hemos hecho en el Server, cuando el 
        // paquete recibido es el primero que nos manda el Server, lo que significa
        // que es cuando el cliente acaba de conectarse y le ha manadado un paquete con
        // el mensaje " online", o es otro paquete, lo que significa que ya se esta
        // chateando y ese mensaje ya se mando
				if(!paqueteRecibido.getMensaje().equals(" online")) { //si NO has recibido el mensaje "online", es que ya estabas chateando, entonces....
					
					campochat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje()); //para que muestre el paquete recibido en el campochat

				}else { //SINO es que un cliente se acaba de conectar, y me agregas el ArrayList de las ips
					
					// campochat.append("\n" + paqueteRecibido.getIps());

          // Creamos un ArrayList donde iran las ips del desplegable
					ArrayList<String> IpsMenu=new ArrayList<String>();
					
          //le decimos que ese ArrayList almacene el ArrayList que el cliente ha 
          //recibido del Server con las ips
					IpsMenu=paqueteRecibido.getIps();
					
          //removemos la lista para que no vaya añadiendo y repitiendo las ips cada
          //vez que un cliente se conecta, ya que el ArrayList que viene del servidor
          //nos trae todas las ips
					ip.removeAllItems();
					
					for(String z: IpsMenu) {
						
						ip.addItem(z);
					}
					
				}
				
				
				
			}
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}



// Creamos una clase para que envie al servidor el ip, el texto, el nick y un ArrayList
// con las ips activas. Todo empaquetado.
// Esta clase tiene que ser serializada (convertida en 0s y 1s) para poder ser enviada 
// al Servidor
//-------------------------------------------------------------------------------------
class PaqueteEnvio implements Serializable{ 
		//Implementamos Serializable(ver Seriarilar) para que todas las instancias
  //de PAquete envio se puedan converir en bytes al ser enviadas por la Red
										
  // getter y setter para el ArrayList de las ips
	public ArrayList<String> getIps() {
		return Ips;
	}

	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}

		//-----Hemos creado estos getter and setters para nick, ip y mensaje con click 
	//derecho ratón---->Source---->Generate Getters and Setters
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	//-------------------------------------------------------------------------

	private String nick, ip, mensaje;
	private ArrayList<String> Ips; 
  //creamos otro elemento para mandar en el paquete de envio,
  //enviamos tambien las ip's activas
	

}




