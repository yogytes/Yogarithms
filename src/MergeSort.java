import java.util.Arrays;

public class MergeSort {
	static int[] a = { 9, 8, 6, 7, 5, 4, 2, 3, 1, 0 };

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		mergeSort(0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

	private static void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low,mid,high);
		}
	}

	private static void merge(int low, int mid, int high) {
		int[] temp =new  int[10];
		for(int i=low; i<=high; i++ ){
			temp[i] = a[i];
		}
		int i=low;
		int j = mid+1;
		int k = low;
		while(i<=mid && j<=high){
			if(temp[i]<temp[j]){
				a[k] = temp[i];
						i++;
			}else{
				a[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i<=mid){
			a[k]= temp[i];
			i++; k++;
		}
		while(j<=high){
			a[k]=temp[j];
			k++; j++;
		}
	}
	
	

}
