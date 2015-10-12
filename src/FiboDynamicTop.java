import java.math.BigInteger;


public class FiboDynamicTop {
	
	static BigInteger[] lookup;
	public static void main(String[] args) {
		int N =  5000;
		lookup = new BigInteger[N +1];
		for(int i=0; i<N+1 ; i ++){
			lookup[i] = BigInteger.ZERO;
		}
		System.out.println(System.currentTimeMillis());
		System.out.println(fiboBottom(5000));
		System.out.println(System.currentTimeMillis());
		
		System.out.println(System.currentTimeMillis());
		System.out.println(fiboBottom(1000));
		System.out.println(System.currentTimeMillis());
		
		System.out.println(System.currentTimeMillis());
		System.out.println(fiboBottom(100));
		System.out.println(System.currentTimeMillis());
		
		int[] a = new int[10];
		int length = a.length;
		
	}
	
	static BigInteger fibo(int n){
		
		if(lookup[n] != BigInteger.ZERO){
			return lookup[n];
		}
		if(n== 0 || n== 1){
			lookup[n] = BigInteger.ONE;
			return lookup[n];
		}
				
		lookup[n] = fibo(n-1).add(fibo(n-2));
		return lookup[n];
	}
	
	static BigInteger fiboBottom(int n){
		lookup[0] = BigInteger.ZERO;
		lookup[1] = BigInteger.ONE;
		for(int i=2; i<=n; i++){
			lookup[i] = lookup[i-1].add(lookup[i-2]); 
		}
		return lookup[n];
	}

}
