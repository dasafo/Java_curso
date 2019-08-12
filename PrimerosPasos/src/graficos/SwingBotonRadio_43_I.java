package graficos;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SwingBotonRadio_43_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoRadioSintaxis mimarco=new MarcoRadioSintaxis();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoRadioSintaxis extends JFrame{
	
	public MarcoRadioSintaxis() {
		
		setVisible(true);
		setBounds(550,300,500,300);
		
		LaminaRadioSintaxis milamina=new LaminaRadioSintaxis();
		
		add(milamina);
		
	}
}


class LaminaRadioSintaxis extends JPanel{
	
	public LaminaRadioSintaxis() {
		
		ButtonGroup migrupo1=new ButtonGroup(); //para agrupar botones de radio(para que solo uno de ellos pueda estar activado)
		
		ButtonGroup migrupo2=new ButtonGroup();  
		
		JRadioButton boton1=new JRadioButton("Azul", false);
		JRadioButton boton2=new JRadioButton("Rojo", true); //dejamos este activado
		JRadioButton boton3=new JRadioButton("Verde", false);
		
		JRadioButton boton4=new JRadioButton("Masculino", false);
		JRadioButton boton5=new JRadioButton("Femenino", false);

		migrupo1.add(boton1);
		migrupo1.add(boton2);
		migrupo1.add(boton3);
		
		migrupo2.add(boton4);
		migrupo2.add(boton5);

		add(boton1);
		add(boton2);
		add(boton3);
		
		add(boton4);
		add(boton5);

		
		
	}
}