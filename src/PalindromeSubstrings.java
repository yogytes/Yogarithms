import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromeSubstrings {
	
	/*static int palindrome(String input){
	    Set<CharSequence> out = new HashSet<CharSequence>();
	    int length = input.length();
	    for (int i = 1; i < length - 1; i++) {
	    	out.add(input.subSequence(i, i+1));
	    	if(input.charAt(i) == input.charAt(i+1)){
	    		out.add(input.subSequence(i, i+2));
	    	}
	        for (int j = i - 1, k = i + 1; j >= 0 && k < length; j--, k++) {
	            if (input.charAt(j) == input.charAt(k)) {
	                out.add(input.subSequence(j, k + 1));
	            } else {
	                break;
	            }
	        }
	    }
	    System.out.println(out);
	    return out.size();
	}*/
	
	public static void main(String[] args) {
		palindrome("aabaa");
	}

	static void palindrome(String s) {
		Map<String, Integer> m = new HashMap<>();
		int n = s.length();

		int[][] R = new int[2][n];
		s="$"+ s +"*";
		System.out.println(s.length());

		for (int j = 0; j <= 1; j++) {
			int rp = 0; 
			R[j][0] = 0;
			int i = 1;
			while (i < n) {
				while (s.charAt(i - rp - 1 ) == s.charAt(i + j + rp ))
				{
					System.out.println("i"+ i +"j" + j + "rp" + rp);
					System.out.println(i-rp-1 +" yy " +rp +" xx "+ (i+j+rp) );
					rp++;
				}

				R[j][i] = rp;
				int k = 1;
				while ((R[j][i - k] != rp - k) && (k < rp)) {
					R[j][i + k] = Math.min(R[j][i - k], rp - k );
					k++;
				}
				rp = Math.max(rp - k, 0);
				i += k;
			}
		}

		s = s.substring(1, n);

		m.put(s.substring(0, 1), 1);
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= 1; j++)
				for (int rp = R[j][i]; rp > 0; rp--){
				System.out.println("i-rp-1 " + (i-rp-1) + "2*rp+j "  + (2*rp+j));
					m.put(s.substring(i - rp - 1, 2 * rp + j), 1);
				}

			m.put(s.substring(i, i+1), 1);
		}
		
		for(Map.Entry e : m.entrySet()){
			System.out.println(e.getKey());
		}

	}


}
