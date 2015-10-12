package HE;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass2 {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	String ln = br.readLine();
        	int x = Integer.parseInt(ln);
        	int count = 0;
        	if(x >= 4){
        		for(int a=1; a<=x/4; a++){
        			for(int b = a ; b<=x/3+1; b++){
        				for(int c = b ; c <= x/2+1; c++){
        					for(int d=x/4 ; d<=x-3; d++){
        						if(a+b+c+d == x){
        							System.out.println(a+"+"+b+"+"+c+"+"+d);
        							count++;
        						}
        					}
        				}
        			}
        		}
        		
        		
        	}
        	System.out.println(count);
          
        }      
    }
}

