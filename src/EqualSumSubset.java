/**
 * 
 * 
 * @author I069337
 *
 */
public class EqualSumSubset {
	
	public static void main(String[] args) {
		int[] a = {1, 5, 11, 5};
		System.out.println(recursiveSoln(a));
		System.out.println(dynamicPSoln(a));
	}
	
	static boolean isSubsetSum (int arr[], int n, int sum)
	{
	   if (sum == 0)
	     return true;
	   if (n == 0 && sum != 0)
	     return false;
	 
	   if (arr[n-1] > sum)
	     return isSubsetSum (arr, n-1, sum);
	 
	   /* else, check if sum can be obtained by any of the following
	      (a) including the last element
	      (b) excluding the last element
	   */
	   return isSubsetSum (arr, n-1, sum) || isSubsetSum (arr, n-1, sum-arr[n-1]);
	}
	 
	
	static boolean recursiveSoln(int[] arr){
		 int sum = 0;
		 int n = arr.length;
		    for (int i = 0; i < n; i++)
		       sum += arr[i];
		 
		    // If sum is odd, there cannot be two subsets with equal sum
		    if (sum%2 != 0)
		       return false;
		 
		    // Find if there is subset with sum equal to half of total sum
		    return isSubsetSum(arr, n, sum/2);
	}
	
	static boolean dynamicPSoln(int[] arr){
		int sum = 0;
		int n = arr.length ;
	    for (int i = 0; i < n; i++){
	    	sum += arr[i];
	    }
	     
	    if (sum%2 != 0)  
	       return false;
	   
	    boolean[][] part = new boolean[sum/2+1][n+1];
	     
	    // initialize top row as true
	    for (int i = 0; i <= n; i++)
	      part[0][i] = true;
	       
	    // initialize leftmost column, except part[0][0], as 0
	    for (int i = 1; i <= sum/2; i++)
	      part[i][0] = false;     
	      
	     // Fill the partition table in botton up manner 
	     for (int i = 1; i <= sum/2; i++)  
	     {
	       for (int j = 1; j <= n; j++)  
	       {
	         part[i][j] = part[i][j-1];
	         if (i >= arr[j-1])
	           part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
	       }        
	     }    
	      
	    /* // uncomment this part to print table 
	     for (i = 0; i <= sum/2; i++)  
	     {
	       for (j = 0; j <= n; j++)  
	          printf ("%4d", part[i][j]);
	       printf("\n");
	     } */
	      
	     return part[sum/2][n];
		
	}

}
