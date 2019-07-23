package david.sockets;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Servidor_85_II  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{ 
	
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
		
		// System.out.println("Estoy a la escucha"); //Para que imprima esto en consola cuando escribimos algo en Servidor
		
		try {
			
			ServerSocket servidor=new ServerSocket(9999); //ponemos el puerto 9999 del servidor a la escucha  
			
			
			while(true) { //creamos un bucle infinito para poder escribir cuantas veces queramos,
			
				Socket misocket=servidor.accept(); //le hemos dicho que acepte las conexiones que vienen con misocket
			
				DataInputStream flujoEntrada=new DataInputStream(misocket.getInputStream()); //Creamos un flujo de datos de entrada para que sea capaz de recogerlo
				
				String mensajeTexto=flujoEntrada.readUTF(); //almacenamos en mensajeTexto el flujo que llega al servidor
			
				areatexto.append("\n" + mensajeTexto);	//Ahora que lo añada a nuestro areatexto del Servidor para que lo veamos
			
				misocket.close(); //cerramos la conexion(socket)
			
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private	JTextArea areatexto;
}
