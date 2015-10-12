import java.util.Arrays;

/**
 * Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.
 * 
 * 
 * @author I069337
 *
 */
public class DistinctBinarystrings {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(countBinaryStrings(n));
	}
	
	static int countBinaryStrings(int n){
		int[] zeroEnd = new int[n];
		int[] oneEnd  = new int[n];
		zeroEnd[0] = oneEnd[0] = 1;
		for(int i=1; i<n ; i++){
			zeroEnd[i] = zeroEnd[i-1] + oneEnd[i-1];
			oneEnd[i] = zeroEnd[i-1];
		}
		System.out.println(Arrays.toString(zeroEnd));
		System.out.println(Arrays.toString(oneEnd));
		return zeroEnd[n-1] + oneEnd[n-1];
	}
}
