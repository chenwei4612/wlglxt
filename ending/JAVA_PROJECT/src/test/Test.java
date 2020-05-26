package test;


public class Test {

	public static void main(String[] args) {
		labb:for(int i=1;i<=4;i++){
			for(int j=1;j<=10;j++){
				if(j%4==0){
					continue labb;
				}
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
