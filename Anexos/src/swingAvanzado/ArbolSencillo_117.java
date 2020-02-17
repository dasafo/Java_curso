package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolSencillo_117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoArbol();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoArbol extends JFrame{
	
	public MarcoArbol() {
		
		setTitle("Arbol sencillo");
		
		setBounds(350,300,600,150);
		
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Mundo");
		
		//-----ITALIA-----
		
		DefaultMutableTreeNode pais=new DefaultMutableTreeNode("Italia");
		
		raiz.add(pais);
		
		DefaultMutableTreeNode ciudad=new DefaultMutableTreeNode("Milán");
		
		pais.add(ciudad);
		
		DefaultMutableTreeNode bergamo=new DefaultMutableTreeNode("Bérgamo");
		
		ciudad.add(bergamo);
		
		DefaultMutableTreeNode pavia=new DefaultMutableTreeNode("Pavía");
		
		ciudad.add(pavia);
		
		
		ciudad=new DefaultMutableTreeNode("Turín");
		
		pais.add(ciudad);
		
		DefaultMutableTreeNode chivasso=new DefaultMutableTreeNode("Chivasso");
		
		ciudad.add(chivasso);

		//-----ALEMANIA-----
		
		pais=new DefaultMutableTreeNode("Alemania");
				
		raiz.add(pais);
		
		ciudad=new DefaultMutableTreeNode("Berlín");
		
		pais.add(ciudad);
		
		DefaultMutableTreeNode potsdam=new DefaultMutableTreeNode("Potsdam");
		
		ciudad.add(potsdam);
		
		
		JTree arbol=new JTree(raiz);
		
		Container laminaContendio=getContentPane();
		
		laminaContendio.add(new JScrollPane(arbol));
		
	}
}


