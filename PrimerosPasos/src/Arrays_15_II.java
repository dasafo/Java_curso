import javax.swing.*;

public class Arrays_15_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] paises=new String[8];
		 for(int i=0;i<8;i++) {
			 paises[i]=JOptionPane.showInputDialog("Introduce país " + (i+1));
		 }
		
		/*paises[0]="España";
		paises[1]="México";
		paises[2]="Colombia";
		paises[3]="Perú";
		paises[4]="Chile";
		paises[5]="Argentina";
		paises[6]="Ecuador";
		paises[7]="Venezuela";*/
		
		//String [] paises= {"España", "México", "Colombia", "Perú", "Chile", "Argentina", "Ecuador", "Venezuela"};
		
		/*for(int i=0; i<paises.length; i++) {
			
			System.out.println("País " + (i+1) + " " +paises[i]);
		}*/
		
		for(String elemento:paises) {
			
			System.out.println("País: " + elemento);
		}
	}

}
