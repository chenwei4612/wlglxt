package test;

public class Test4 {
	public static void A(int[] a){
		for(int i=0;i<a.length-1;i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void B(int[] a){
		int t;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
	}
	public static void C(int[] a){
		int t;
		for(int i=0;i<a.length-1;i++){
			for(int j=a.length-1;j>0;j--){
				
			}
		}
	}
	public static void main(String[] args) {
		int[] arr= new int[]{-2,232,2,56,28,-55,323,5};
		B(arr);
		A(arr);
	}

}
