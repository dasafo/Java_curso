package graficos;

import javax.swing.*;

public class AplGraficasDisposicionesSpring_52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMuelle mimarco=new MarcoMuelle();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoMuelle extends JFrame{
	
	public MarcoMuelle() {
		
		setBounds(300,400,1000,350);
		
		LaminaMuelle milamina=new LaminaMuelle();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaMuelle extends JPanel{
	
	public LaminaMuelle() {
		
		
		JButton boton1=new JButton("Botón 1");
		JButton boton2=new JButton("Botón 2");
		JButton boton3=new JButton("Botón 3");
		
		SpringLayout milayout=new SpringLayout(); //para que las cajas estén en disposición de muelle
		setLayout(milayout);
		
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		Spring mimuelle=Spring.constant(0, 10, 100); //construimos el muelle variable
		Spring muelleRigido=Spring.constant(50); //contruimos un muelle rigido
		
		
		milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this); /*en la última ponemos this porque hacer referencia al borde del contenedor 
																							  de la lamina que es donde empieza nuestro muelle*/
		milayout.putConstraint(SpringLayout.WEST, boton2, muelleRigido, SpringLayout.EAST, boton1); //En este caso empieza en el lado EAST del boton1
		milayout.putConstraint(SpringLayout.WEST, boton3, muelleRigido, SpringLayout.EAST, boton2);
		milayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.EAST, boton3);

	
	
	}
	
}
