
public class StringPerm {
	static int k =0;
	public static void main(String[] args) {
		String s = "ABCDE";
		permutation("", s);
	}

	private static void permutation(String prefix, String suffix) {
		int len = suffix.length();
		
		if(len == 0) {
			++k;
			System.out.println(k + prefix);
		}else{
			for(int i=0; i<len ; i++){
				permutation(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, len));
			}
		}
	}

}
