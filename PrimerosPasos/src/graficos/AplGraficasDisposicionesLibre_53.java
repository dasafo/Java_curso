package graficos;

import javax.swing.*;
import java.awt.*;

public class AplGraficasDisposicionesLibre_53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoLibre mimarco=new MarcoLibre();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}


class MarcoLibre extends JFrame{
	
	public MarcoLibre() {
		
		setBounds(450,350,600,400);
		
		LaminaLibre milamina=new LaminaLibre();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaLibre extends JPanel{
	
	public LaminaLibre() {
		
		// setLayout(null); //null para indicar que nuestra lamina tendra disposion libre
		setLayout(new EnColumnas()); //le decimos que aplique nuestra disposion personalizada EnColumnas(ver mas abajo)
		
		JLabel nombre=new JLabel("Nombre: ");
		JLabel apellido=new JLabel("Apellido: ");
		JLabel edad=new JLabel("Edad: ");

		JTextField c_nombre=new JTextField();
		JTextField c_apellido=new JTextField();
		JTextField c_edad=new JTextField();

		/*nombre.setBounds(20,20,80,10);
		c_nombre.setBounds(90,15,100,20);
		apellido.setBounds(20,60,80,15);
		c_apellido.setBounds(90,55,100,20);*/
		
		add(nombre);
		add(c_nombre);
		add(apellido);
		add(c_apellido);
		add(edad);
		add(c_edad);

		
		
	}
}



class EnColumnas implements LayoutManager{ //Contruimos una clase para crear nuestra propia disposición de elementos

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container micontenedor) {
		// TODO Auto-generated method stub
		
		int d=micontenedor.getWidth(); //almacenamos el ancho del contenedor
		
		x=d/2; //identificamos el punto medio del contenedor en las x
		
		int contador=0; //para saber cuantos elementos llevamos agregados
		
		int n=micontenedor.getComponentCount(); //indica cuantos componentes(etiquetas, cuadros de texto, desplegables...) hemos agregado al contenedor
		
		for(int i=0;i<n;i++) {
			
			contador++;
			
			Component c=micontenedor.getComponent(i);
			
			c.setBounds(x-100, y, 100, 20); //ponemos x-100 para que nos centre los elementos una vez identificado el centro(d)
			
			x+=100; //para que cada componente lo ponga 100 respecto al anteior
			
			if(contador%2==0) { //cuando el resto de contador/2 sea 0, x vuelve al principio(x=20) e 'y' baja 40
				
				x=d/2;
				y+=40;
			}
		}
		
	}
	
	private int x;
	private int y=20;
	
	
}




