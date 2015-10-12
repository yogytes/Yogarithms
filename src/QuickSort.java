import java.util.Arrays;


public class QuickSort {
	
	public static void main(String[] args) {
		int[] a = new int[]{6,5,4,3,2,1};
		System.out.println("Unsorted array "+ Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println("Sorted Array" + Arrays.toString(a));
	}
	
	static void quickSort(int[] a, int low, int high){
		int i = low;
		int j = high;
		int pivot= a[low + (high-low)/2];
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
			quickSort(a,i,high);
		}
	}

	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
