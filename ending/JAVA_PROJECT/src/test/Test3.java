package test;

public class Test3 {
	/*
	******
	*****
	****
	***
	**
	*
	**/
	public static void A(){
		for(int i=1;i<=6;i++){
			for(int j=i;j<=6;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	  /*
	   *****
	   ******
	    ******
	     ******
	      ******
	       ******
	       **/
	public static void B(){
		for(int i=1;i<=6;i++){
			for(int j=0;j<=i;j++){
				System.out.print(" ");
			}
			for(int j=1;j<=6;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void C(){
		for(int i=1;i<=6;i++){
			for(int j=i;j>=0;j--){
				System.out.print(" ");
			}
			for(int j=1;j<=6;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		C();
	}

}