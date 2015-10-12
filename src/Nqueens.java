

public class Nqueens {
	static int count =0;
	public static void main(String[] args) {
		int N = 5;
		enumerate(N);
		System.out.println("Number of solutions "+count);
	}

	private static void enumerate(int N) {
		int[] q = new int[N];
		enumerate(q,0);
	}

	private static void enumerate(int[] q, int n) {
		int N = q.length;
		if(n==N){
			count++;
			printQueens(q);
		}
		else{
			for(int i=0;i<N;i++){
				q[n] = i;
				if(isConsistent(q,n)){
					enumerate(q,n+1);
				}
			}
		}
	}

	private static boolean isConsistent(int[] a, int n) {
		for(int i=0;i<n;i++){
			if(a[i] == a[n]) return false;
			if((a[i]-a[n]) == (n-i)) return false;
			if((a[n] - a[i]) == (n-i)) return false;
		}
		return true;
	}

	private static void printQueens(int[] q) {
		int N=q.length;
		for(int i=0;i<N;i++){
			System.out.print(q[i]+" " );
		}
		System.out.println();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(q[i] == j)
					System.out.print("Q ");
				else 
					System.out.print("* ");
			}
			System.out.println();
		}
	}

}
