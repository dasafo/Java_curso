package vista;

import java.awt.*;

import javax.swing.*;

import controlador.*;

public class MarcoAplicacion2 extends JFrame {
	
	public MarcoAplicacion2(){
		
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
		
		add(botonConsulta, BorderLayout.SOUTH);
		
    //Ponemos el boton de Constulta a la escucha
		botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
		
    // Para que este a la escucha de lo que viene de ControladorCargaMenus
    // que es un evento de ventana, aqui this hace referencia al parametro elmarco
		addWindowListener(new ControladorCargaMenus(this));

	}
	
	public JComboBox secciones;
	
	public JComboBox paises;
	
	public JTextArea resultado;
}
