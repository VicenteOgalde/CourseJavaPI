package Examples;

public class ExampleArray2D {

	public static void main(String[] args) {
		/*
		int array2d [][] = new int [4][4];
		double tax=1;
		double tax2=tax;
		int rowCount=0;
		double base=10000;
		
		for(int row[]:array2d) {
			tax=tax+0.1;
			
			for(double i:row) {
				if(rowCount==0) {
					i=base;
				}else {
					i=i+(base*tax);
					base=i;
				}
				
				System.out.print(i+" ");
			}
			System.out.println();
			rowCount++;
		}*/
		
		double sum;
		double interes=0.10;
		double [][] total= new double [5][5];
		for(int i =0;i<5;i++) {
			total[i][0]=1000;
			sum=1000;
			for(int j=1;j<5;j++) {
				sum=sum+(sum*interes);
				total[i][j]=sum;
				
			}
			interes=interes+0.01;
			
		}
		for(double i[]:total) {
			for(double j:i) {
				System.out.printf("%1.2f",j);
				System.out.print(" ");
			}
			System.out.println();
		}
		

	}

}
