
public class Arrays_15_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int [][] matrix=new int [4][5];
		
		matrix[0][0]=-65;
		matrix[0][1]=8;
		matrix[0][2]=-1;
		matrix[0][3]=6;
		matrix[0][4]=74;
		
		matrix[1][0]=15;
		matrix[1][1]=21;
		matrix[1][2]=18;
		matrix[1][3]=9;
		matrix[1][4]=15;
		
		matrix[2][0]=10;
		matrix[2][1]=52;
		matrix[2][2]=17;
		matrix[2][3]=19;
		matrix[2][4]=7;
		
		matrix[3][0]=19;
		matrix[3][1]=2;
		matrix[3][2]=19;
		matrix[3][3]=17;
		matrix[3][4]=7;
		
		
		
		for(int i=0;i<4;i++) {    //REcorre la primera dimensión(columnas)
			
			System.out.println();
			
			 for(int j=0;j<5;j++) { //REcorre la segunda dimensión(filas)
				 
				 System.out.print(matrix[i][j] + " ");
				 
			 }
		}*/
		
	int [][] matrix= {
			{-65,8,-1,6,74},
			{15,21,18,9,15},
			{10,52,17,19,7},
			{19,2,19,17,7}
		};
	
	for(int[]fila:matrix) {
		
		System.out.println();

		for(int z: fila) {
			System.out.print(z + " ");
		}
		
	}
		
		
	}

}
