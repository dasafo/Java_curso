package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Layouts_Calculadora_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCalculadora mimarco=new MarcoCalculadora();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
		
	}

}


class MarcoCalculadora extends JFrame{
	
	public MarcoCalculadora() {
		
		 setTitle("Calculadora");
		 setBounds(500,300,450,300);
		 
		 laminaCalculadora milamina=new laminaCalculadora();
		 
		 add(milamina);
		 //pack(); //para que las celdas se adapten a lo que contienen
		
	}
	
}


class laminaCalculadora extends JPanel{
	
	public laminaCalculadora() {
		
		principio=true;
		
		setLayout(new BorderLayout());
		
		pantalla=new JButton("0");
		
		pantalla.setEnabled(false); //deshabilitamos el botón para que no sea igual que el resto la pantalla donde se visualizan las operaciones
		
		add(pantalla, BorderLayout.NORTH);
		
		milamina2=new JPanel();
		
		milamina2.setLayout(new GridLayout(4,4));
		
		ActionListener insertar=new InsertaNumero();
		ActionListener orden=new AccionOrden();
		
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		ponerBoton("/", orden);
		
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		ponerBoton("*", orden);
		
		ponerBoton("1",insertar);
		ponerBoton("2",insertar);
		ponerBoton("3",insertar);
		ponerBoton("-", orden);
		
		ponerBoton("0",insertar);
		ponerBoton(".",insertar);
		ponerBoton("=", orden);
		ponerBoton("+", orden);

		
		add(milamina2,BorderLayout.CENTER);
		
		ultimaOperacion="0";
		
	}
	
	private void ponerBoton(String rotulo, ActionListener oyente) { //método para agregar botones y ponerlos a la escucha
		
		JButton boton=new JButton(rotulo); //en el constructor de JButton le decimos que va a recibir 'rotulo'
		
		boton.addActionListener(oyente); //ponemos la instancia 'boton' a la escucha
		
		milamina2.add(boton);
		
	}
	
	private class InsertaNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String entrada=e.getActionCommand(); //getActionCommand devuelve el string de esa accion, y lo metemos en 'entrada'
			
			if(principio) {		//para que quite el primer 0 al pulsar las teclas
				pantalla.setText("");
				principio=false;
			}
			// en la pantalla tienes que poner un texto(getText) y tiene que ser igual a lo que halla ya en la pantalla(getText()) + el nuevo número
			pantalla.setText(pantalla.getText() + entrada); 
		}
		
		
	}
	
	private class AccionOrden implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String operacion=e.getActionCommand(); //almacenamos en 'operacion' lo que captura el boton
			
			calcular(Double.parseDouble(pantalla.getText())); //pasamos lo que capura por pantalla(un string) a double
															  // el metodo parseDouble(q es static) por eso hay que poner delante la clase a la q pertenece Double
			ultimaOperacion=operacion;
			
			principio=true; //para que limpie la pantalla cada vez que sea llamado este método 
			
			
		}
		
		public void calcular(double x) {
			
			if(ultimaOperacion.equals("+")) {
				
				resultado+=x;
			}
			else if(ultimaOperacion.equals("-")) {
				
				resultado-=x;
			}
			else if(ultimaOperacion.equals("*")) {
				
				resultado*=x;
			}
			else if(ultimaOperacion.equals("/")) {
	
				resultado/=x;
			}
			else if(ultimaOperacion.equals("=")) {
				
				resultado=x;
			}
			
			pantalla.setText("" + resultado);
		}
		
		
	}
	
	private JPanel milamina2;
	private JButton pantalla;
	private boolean principio; 
	private double resultado;
	private String ultimaOperacion;
}


