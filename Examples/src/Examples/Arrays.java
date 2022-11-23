package Examples;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int [] meArray= new int[5];
		for(int i=0;i<5;i++) {
			meArray[i]=i+1;
			System.out.println(meArray[i]);
		}
		for(int x :meArray) {
			System.out.println(x+" forEach");
		} */
		
		int matrix [][]=new int [5][5];
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				matrix[i][j]=i+j;
				System.out.println("matrix position i:"+i+" j:"+j+" value "+matrix[i][j]);
			}
		}
		for (int[] row:matrix) {
			for(int i : row) {
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
