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
 * 1- Desde el Cliente mandaremos un objeto(PaqueteEnvio) con la ip, nick y texto que se envia, para ello
 * 	  lo Serializamos(pasamos a bytes)
 * 
 * 2- En el Servidor creamos otro objeto(PaqueteREcibido) para que recoja el paquete serializado que le llega
 * 	  desde el Cliente
 * 
 * 3- HAcer lo mismo que en 2, pero para el Cliente que recibe finalmente el mensaje
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
		
		addWindowListener(new EnvioOnline()); //Asi nada mas se abra la ventana se ejecuta windowOpened(avisa de que está online)
		}	
	
}


//----------------ENVIO DE SEÑAL ONLINE--------------------
class EnvioOnline extends WindowAdapter{ //clase adaptadora que implementa todos los metodos de una interfaz, en este caso de WindowListener
	
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket misocket=new Socket("192.168.1.90",9999); //establecemos una conexion(socket) con el servidor
			
			PaqueteEnvio datos=new PaqueteEnvio();
			
			datos.setMensaje(" online");
			
			ObjectOutputStream paqueteDatos=new ObjectOutputStream(misocket.getOutputStream()); //creamos flujo de datos
			
			paqueteDatos.writeObject(datos);
			
			misocket.close();
			
		}catch(Exception e2) {}
	}
	
}

//---------------------------------------------------------



class LaminaMarcoCliente extends JPanel implements Runnable{ //implementamos Runnable para crear un hilo para que esté permanentemente a la escucha
															 //para que reciba los datos reenviados por parte del Servidor
	
	public LaminaMarcoCliente(){
		
		String nick_usuario=JOptionPane.showInputDialog("Nick: ");
		
		JLabel n_nick=new JLabel("Nick: ");
		
		add(n_nick);
		
		nick=new JLabel();
		
		nick.setText(nick_usuario);
		
		add(nick);
		
		JLabel texto=new JLabel("Online: ");
		
		add(texto);
		
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
		
		Thread mihilo=new Thread(this); //creamos el hilo que estará a la escuhca constantemente esperando info del Servidor
		
		mihilo.start(); //arrancamos el hilo
		
		
	}
	
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
					
			try {
				Socket misocket=new Socket("192.168.1.90", 9999); //instanciamos el flujo(Socket)
				
				//creamos un paquete 'datos'(Object) y enpaquetamos el nick, ip y el mensaje del cuadro de texto
				PaqueteEnvio datos=new PaqueteEnvio(); 
				
				//el cuadro de texto se llamaba nick(JTextField), lo caputra(getText()) y se lo manda a la variable 
				//nick(no confundir con el JTextField con el mismo nombre)
				datos.setNick(nick.getText()); 
				datos.setIp(ip.getSelectedItem().toString()); //lo mismo para la ip
				datos.setMensaje(campo1.getText()); //lo mismo para el cuadro de texto
				
				//Creamos el flujo de salida paqueteDatos para enviar el paquete 'datos'
				ObjectOutputStream paqueteDatos=new ObjectOutputStream(misocket.getOutputStream()); 
				//le decimos que el paquete datos es el que viajará a través del flujo de salida paqueteDatos
				paqueteDatos.writeObject(datos); 
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
		// TODO Auto-generated method stub
		
		try {
			
			ServerSocket servidorCliente=new ServerSocket(9099); //creamos un flujo que conecte el puerto 9090 del Servidor con nuestro cliente
			
			Socket cliente;
			PaqueteEnvio paqueteRecibido;
			
			while(true) { //para que este siempre a la escucha, bucle infinito
				
				cliente=servidorCliente.accept(); //para que acepte todas las conexiones que le lleguen del exterior
				
				ObjectInputStream flujoEntrada=new ObjectInputStream(cliente.getInputStream()); //creamos un flujo de entrada capaz de trasportar objetos(paquete de datos)
				
				paqueteRecibido=(PaqueteEnvio)flujoEntrada.readObject(); //para que almacene en paqueteRecibido el paquete que le llega
				
				if(!paqueteRecibido.getMensaje().equals(" online")) { //si NO has recibido el mensaje "online", es que ya estabas chateando
					
					campochat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());

				}else { //sino es que un cliente se acaba de conectar, y me agregas la ip
					
					
					// campochat.append("\n" + paqueteRecibido.getIps());

					ArrayList<String> IpsMenu=new ArrayList<String>();
					
					IpsMenu=paqueteRecibido.getIps();
					
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

//creamos una clase para que envie al servidor el ip, el texto y el nick empaquetados
class PaqueteEnvio implements Serializable{ 
											
	public ArrayList<String> getIps() {
		return Ips;
	}

	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}

	//Implementamos Serializable(ver Seriarilar) para que todas las instancias de PAquete envio 
	//se puedan converir en bytes al ser enviadas por la Red
	private String nick, ip, mensaje;

	private ArrayList<String> Ips; //creamos otro elemento para mandar en el paquete de envio, 
									//enviamos tambien las ip's activas
	
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
	
}




