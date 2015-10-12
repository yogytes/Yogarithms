package HE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class TestClass {
	static int[] primes = new int[10001];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			System.out.println(System.currentTimeMillis());
			int[] freq = new int[10];
			String ln = br.readLine();
			String[] splits = ln.split(" ");
			int l = Integer.parseInt(splits[0]);
			int r = Integer.parseInt(splits[1]);

			for (int j = l; j <= r; j++) {
				if (isPrime(j)) {
					collectFreq(freq, j);
				}
			}
			int max = 0;
			int idx = -1;
			for (int k = 0; k <= 9; k++) {
				if(max !=0 && freq[k] == max){
					if(k > idx){
						idx =k;
					}
				}
				else if (freq[k] > max) {
					max = freq[k];
					idx = k;
				}
			}
			
				System.out.println(idx);
				System.out.println(System.currentTimeMillis());
		}

	}

	private static void collectFreq(int[] freq, int j) {
		while (j > 0) {
			int idx = j % 10;
			freq[idx]++;
			j = j / 10;
		}

	}

	private static boolean isPrime(int j) {
		if(primes[j] > 0){
			return true;
		}
		if(j == 1){
			return false;
		}
		for (int k = 2; k <= j / 2; k++) {
			
			if(j == 2){
			primes[j] = j;
				return true;
			}
			if (j % k == 0) {
				return false;
			}
		}
		primes[j] = j;
		return true;
	}
}