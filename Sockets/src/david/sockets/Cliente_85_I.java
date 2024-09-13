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
 * Realizamos un mini chat primitivo desde 85_I se crea un CLIENTE que manda a un Servidor
 * situado en 85_II el texto que se introduce 
 */

/*
 * El CLIENTE es el encargado de crear el puente/socket hacia el Servidor
 * y crear el flujo/stream de infromacion
 * */

package david.sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import java.io.*;

public class Cliente_85_I {

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
		}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente(){
	
		JLabel texto=new JLabel("CLIENTE");
		
		add(texto);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		EnviaTexto evento=new EnviaTexto();
		
		miboton.addActionListener(evento); //ponemos el boton a la escucha del evento
		
		add(miboton);	
		
	}
	
// Esta clase se encargara de administrar los eventos 	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// System.out.println(campo1.getText()); //para que escriba en consola lo que ponemos en la celda
		
			try {
				
				//Creamos el puente entre cliente-servidor, el Socket
				Socket misocket=new Socket("192.168.178.24", 9999); //instanciamos el flujo(Socket) dadno la IP y el puerto
				
				//Creamos el flujo de datos de salida y lo hacemos circular por misocket
				DataOutputStream flujoSalida=new DataOutputStream(misocket.getOutputStream());  
				
				flujoSalida.writeUTF(campo1.getText()); //le decimos que en el flujo de salida viajará lo que hay en el campo1(entrada de texto del panel)
				flujoSalida.close(); //cerramos el flujo de salida
				
				
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage()); 			}
		
		}
		
		
	}
		
		
		
	private JTextField campo1;
	
	private JButton miboton;
	
}
