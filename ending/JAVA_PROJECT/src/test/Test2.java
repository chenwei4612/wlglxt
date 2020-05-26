package test;

public class Test2 {
	public static void main(String[] args) {
		for(int i=1;i<=1000;i++){
			int a=0;
			for(int j=1;j<=(i/2);j++){
				if(i%j==0){
					a+=j;
				}
			}
			if(i==a){
				System.out.println(i);
			}
		}
	}

}
