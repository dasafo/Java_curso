
public class Ejemplo_Array2D_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double acumulado;
		double interes=0.10;
		
		double [][] saldo=new double[6][5];
		
		for(int i=0;i<6;i++) {
		
		saldo[i][0]=20000;  //ponemos la primera columna(0) a 20000
		acumulado=10000;
		
		for(int j=1;j<5;j++) { 
			acumulado=acumulado+(acumulado*interes);
			saldo[i][j]=acumulado;		//Ponemos el resto de filas y columnas con el acumulado*interes 
		
		}
		//Cuando termine con la primera culumna(primera iteracion)el interés va cambiando +0.01
		interes=interes+0.01;
		}
		
		for(int z=0;z<6;z++) {
			
			System.out.println();
			
			for(int h=0;h<5;h++) {
				
				System.out.printf("%1.2f", saldo[z][h]); //iteramos todas las posiciones de la matriz para mostrarlas
				System.out.print(" ");
			}
		}
		
		
	}

}
