
public class Test {
	public static void main(String[] args) {
		String s = "test";
		int[] a = {9,8,7,4,5,6,3,2,1,0};
		//perm("",s);
		quickSort(a,0,a.length-1);
		printArray(a);
		binarySearch(a,0, a.length-1,2);
	}

	private static void binarySearch(int[] a, int low, int high, int i) {
		int mid = low+(high-low)/2;
		if(a[mid] == i){
			System.out.println("Found "+i+ " at "+mid);
			return;
		}else if(i<a[mid]){
			binarySearch(a, low, mid-1, i);
		}else{
			binarySearch(a, mid+1, high, i);
		}
		
	}

	private static void printArray(int[] a) {
		for(int i=0; i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

	private static void quickSort(int[] a, int low, int high) {
		int pivot = a[low+(high-low)/2];
		int i= low;
		int j=high;
		while(i<=j){
			while(a[i]<pivot){
				i++;
			}
			while(a[j]>pivot){
				j--;
			}
			if(i<=j){
				swap(a,i,j);
				i++;
				j--;
			}
		}
		if(low<j){
			quickSort(a, low, j);
		}
		if(i<high){
			quickSort(a, i, high);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void perm(String prefix, String suffix) {
		
		if(suffix.length() == 0){
			System.out.println(prefix);
		}else{
			for(int i=0;i<suffix.length();i++){
				perm(prefix+suffix.charAt(i), suffix.substring(0,i)+suffix.substring(i+1));
			}
		}
	}
	
	
	
	
}
