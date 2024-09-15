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

// ********************************
// CLIENTE1 -> SERVIDOR -> CLIENTE2
// *********************************

package david.chat;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ChatServidor_86_II  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{ 
  // Implementamos Runnable para que crear un hilo que este permanentemente
  // a la escucha de los datos que le vienen de los clientes que estan
  // chateando y cuya info pasa serializada por el Servidor

	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread mihilo=new Thread(this); //creamos un hilo para que esté a la escucha(implements Runnable)
		
		mihilo.start();
		
		}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {

        // ---------------------------------------------------------------
        // -------------------- CLIENTE1 -> SERVIDOR ---------------------
        // ---------------------------------------------------------------


			
			ServerSocket servidor=new ServerSocket(9999); //ponemos el puerto 9999 del servidor a la escucha  
			
			String nick, ip, mensaje; //creamos las variables donde se guardará la info que llegue
			
			ArrayList<String> listaIp=new ArrayList<String>(); //creamos lista para almacenar ip's de frma dinamica
			
			PaqueteEnvio paqueteRecibido; //paquete que recibirá la info del Cliente
			
			
			
			while(true) { //creamos un bucle infinito para poder escribir cuantas veces queramos, y este todo el rato a la escucha
			
				Socket misocket=servidor.accept(); //le hemos dicho que acepte las conexiones que vienen con misocket
			
											
				ObjectInputStream paqueteDatos=new ObjectInputStream(misocket.getInputStream()); //creamos flujo para recibir los datos que se encuentran serializados (0s y 1s)
				
				paqueteRecibido=(PaqueteEnvio)paqueteDatos.readObject(); //lee y mete el paqueteDatos recibido del cliente mediante el flujo, en paqueteRecibido
				
        // Ahora extraemos la info guardada en paqueteRecibido haciendo uso de los
        // getters de la clase PaqueteEnvio creada en el Cliente
				nick=paqueteRecibido.getNick(); 
				ip=paqueteRecibido.getIp();
				mensaje=paqueteRecibido.getMensaje();
				

			// Si el mensaje que recibe del cliente es diferente al paquete " online"
      // entonces significa que ya se conecto antes por primera vez, entonces... 
			if(!mensaje.equals(" online")) {
									
				areatexto.append("\n" + nick + ": " + mensaje + " para " + ip); //que lo ponga en el cuadro de texto
				
				// ---------------------------------------------------------------
        // -------------------- SERVIDOR -> CLIENTE2 ---------------------
        // ---------------------------------------------------------------

				//-----creamos conexion del Servidor con otro cliente-----
				Socket enviaDestinatario=new Socket(ip, 9099); 
          //creamos puente con el otro Cliente(detinatario final) usamos la ip y
          //el puente del otro cliente 9099, la id del cliente es la misma porque
          //lo reenviamos al mismo cliente
				
				ObjectOutputStream paqueteReenvio=new ObjectOutputStream(enviaDestinatario.getOutputStream()); //reeviamos el paquete por el flujo(stocket) enviaDestinatario
				
				paqueteReenvio.writeObject(paqueteRecibido); //metemos la infromacion que hemos recibido(paqueteRecibido) en el flujo creado y dentro de paqueteReenvio
				
				paqueteReenvio.close();//cerramos el paquete
				
				enviaDestinatario.close();//cerramos el puente
				
			}else { // En cambio si es la primera vez q se conecta....
					
					// Ahora necesitamos que nuestro Server detecte las ips que estan activas
          // ----------------------------------------------------------------------

          // Guardamos en un objeto de la clase InetAddress usando su metodo
          // getInetAddress que lo que hace es devolver la direccion a la que 
          // el socket esta conectado
					InetAddress localizacion=misocket.getInetAddress();
					
          // Como lo anterior nos devuelve un objeto y nosotros trabajamos con
          // String, vamos a crear una variable de tipo String y usando un metodo
          // getHostAddress de la clase InetAddress, obtenemos la direccion
          // ip en formato String del cliente que se acaba de conectar al Server
					String IpRemota=localizacion.getHostAddress();

					// System.out.println("ONLINE " + IpRemota);
					
          // cada vez que entra un nuevo cliente, entra en este 'else' y vamos
          // añadiendo la ip
					listaIp.add(IpRemota); //vamos añadiendo las IP's a listaIp(es un ArrayList)

					//metemos en el paquete el ArrayList de las IP's con ayuda del setter que
          //tenemos definido en la calse de PaqueteEnvio en el Cliente
					paqueteRecibido.setIps(listaIp); 					


          // Ahora se recorrera todo el ArrayList(listaIp) e ira abriendo un socket
          // con cada ip para de esta forma mandar este ArrayList a cada cliente, para que 
          // estos dispongan en su menu desplegable de las ips activas
					for(String z: listaIp) { //recorremos la lista de IP's
						
						System.out.println("Array: " + z);//las imprimimos por consola
						
						//-----creamos conexion del Servidor con otro cliente-----
						Socket enviaDestinatario=new Socket(z, 9090); 
            //creamos puente con el otro Cliente(detinatario final) usamos la ip,
            //que ahora esta almacenado en z, y el puente del otro cliente 9090,
            //la id del cliente es la misma porque lo reenviamos al mismo cliente
						
						ObjectOutputStream paqueteReenvio=new ObjectOutputStream(enviaDestinatario.getOutputStream()); //reeviamos el paquete por el flujo(stocket) enviaDestinatario
						
						paqueteReenvio.writeObject(paqueteRecibido); //metemos la infromacion que hemos recibido(paqueteRecibido) en el flujo creado y dentro de paqueteReenvio
						
						paqueteReenvio.close();//cerramos el paquete
						
						enviaDestinatario.close();//cerramos el puente
						
					}
					
					//-----------------------------------------------
					
					
				}
				
				//-----------------------------------------------------------
				
				
				misocket.close(); //cerramos la conexion(socket)
			
				}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private	JTextArea areatexto;
}

