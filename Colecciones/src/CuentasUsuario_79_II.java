import java.util.*;

public class CuentasUsuario_79_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente_79_I cl1=new Cliente_79_I("Antonio Contreras", "0001", 200000);
		Cliente_79_I cl2=new Cliente_79_I("Maria Serbina", "0002", 250000);
		Cliente_79_I cl3=new Cliente_79_I("Alvaro Lapuerta", "0003", 300000);
		Cliente_79_I cl4=new Cliente_79_I("Bertin Osborne", "0004", 400000);
		Cliente_79_I cl5=new Cliente_79_I("Antonio Contreras", "0001", 200000);


		Set <Cliente_79_I> clientesBanco=new HashSet<Cliente_79_I>();
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);

		
		/*for (Cliente_79_I cliente_79_I : clientesBanco) {
			
			System.out.println(cliente_79_I.getNombre() + " " 
			
					+ cliente_79_I.getnCuenta() + " " + cliente_79_I.getSaldo());
			
			if(cliente_79_I.getNombre().equals("Julio Iglesias")) { //para remover un objeto(veremos abajo que esto se hace mejor con iteradores)
				
				clientesBanco.remove(cliente_79_I);
			}
			
		}*/
		
		
		//-----------Mejor se elimina con un iterador--------
		
		Iterator<Cliente_79_I> it=clientesBanco.iterator(); 
		
		while(it.hasNext()) {
			
			String nombreCliente=it.next().getNombre();
			
			if(nombreCliente.equals("Julio Iglesias")){ //removemos Julio Iglesias
				
				it.remove();
			}
		}
		
		//------------------------------------------------------
		
		
		for (Cliente_79_I cliente_79_I : clientesBanco) {
			
			System.out.println(cliente_79_I.getNombre() + " " 
			
					+ cliente_79_I.getnCuenta() + " " + cliente_79_I.getSaldo());
			
		}
		
		
		//Ahora hacemos lo misma tarea que con el for-Each de arriba pero con iteradores(más complicado)
		
		/*Iterator<Cliente_79_I> it=clientesBanco.iterator();
		
		while(it.hasNext()) { //hasNext comprueba(true/false) si hay un objeto al que saltar con Next()
			
			String nombreCliente=it.next().getNombre(); //next() da un salto al siguiente 'hueco' de objetos, y así puede esturiar lo que hay en el objeto tiene detras(ananliza a toro pasado)
		
			System.out.println(nombreCliente);
			
			// String nCuenta=it.next().getnCuenta(); //esto nos daría el nCuenta del siguiente ya que aplicamos otra vez Next()(por eso en este caso es mejor usar el For-Each de antes) 
		
		}*/
		
		//----------------------------------------------------------------------------------------------
		
		

		
	}

}
