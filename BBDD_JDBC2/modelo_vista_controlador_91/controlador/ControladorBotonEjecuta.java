/*
 * Esta clase se encarga de manejar los eventos del boton Consultar 
 * En definitiva se encarga de manejar el evento click del raton
 * 
 * */

package controlador;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import vista.*;

public class ControladorBotonEjecuta implements ActionListener{
	
	public ControladorBotonEjecuta(MarcoAplicacion2 elmarco) {
		
		this.elmarco=elmarco;
	}

  //este metodo es obligatorio de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
    //Aqui almacenamos lo que el usuario escoge en los desplegables
		String seleccionSeccion=(String)elmarco.secciones.getSelectedItem();
		String seleccionPais=(String)elmarco.paises.getSelectedItem();
		
		resultadoConsulta=obj.filtraBBDD(seleccionSeccion, seleccionPais);
		
		try {
			
			elmarco.resultado.setText(""); //ponemos el campo del texto sin nada
			
			while(resultadoConsulta.next()) {
				
        //Vamos almacenando en resultado/JText o el campo de texto los resultadoConsulta
        //que seran escritos en dicha area de texto de la ventana
				elmarco.resultado.append(resultadoConsulta.getString(1));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(2));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(3));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(4));
				elmarco.resultado.append("\n");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("aaaaaa");
		}

	}
	
	private MarcoAplicacion2 elmarco;
	
	EjecutaConsultas obj=new EjecutaConsultas();
	
	private ResultSet resultadoConsulta;

}
