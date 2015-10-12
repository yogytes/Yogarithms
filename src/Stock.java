package amagi;

import java.util.Scanner;
/**
 * Input : capital, No. of companies, n triples <name, currentPrice, futurePrice >
 * Assumption : Only one stock of the company is bought as per the statement
 * 
 * @author Yogesha K S
 *
 */

public class Stock {
		int cur_p; // Current price
		int fut_p; // Future Price
		int profit; // Profit achievable
		String name; // Name of the stock

	    public static void main(String[] args) {
	    	System.out.println("enter details in following order");
	    	System.out.println("Capital | No.of.Companies(n) | followed by n triples<company_name current_price future_price> ");
	    	
	    	Scanner in = new Scanner(System.in);
	    	int C = in.nextInt();
	    	int N = in.nextInt();
	    	Stock[] stocks = new Stock[N+1];
	    	for(int i=1; i<=N; i++){
	    		stocks[i] = new Stock();
	    		stocks[i].name = in.next();
	    		stocks[i].cur_p = in.nextInt();
	    		stocks[i].fut_p = in.nextInt();
	    		stocks[i].profit = stocks[i].fut_p - stocks[i].cur_p;
	    	}

	        int[][] sel = new int[N+1][C+1];
	        boolean[][] sol = new boolean[N+1][C+1];

	        for (int n = 1; n <= N; n++) {
	        	System.out.println();
	            for (int c = 1; c <= C; c++) {
	                float option1 = sel[n-1][c];
	                float option2 = Integer.MIN_VALUE;
	                if (stocks[n].cur_p <= c) option2 = stocks[n].profit + sel[n-1][c-stocks[n].cur_p];

	         
	                sel[n][c] = (int) Math.max(option1, option2);
	                sol[n][c] = (option2 > option1);
	               // System.out.print(sel[n][c] + " ");
	            }
	        }

	        boolean[] take = new boolean[N+1];
	        for (int n = N, c = C; n > 0; n--) {
	            if (sol[n][c]) { take[n] = true;  c = c - stocks[n].cur_p; }
	            else           { take[n] = false;                    }
	        }

	        int profitAchieved = 0;
	        int cost = 0;
	        System.out.println("Selectd Stocks");
	        System.out.println("Number"+ "\t" +"Name" + "\t" + "buy@" + "\t" + "profit");
	        for (int n = 1; n <= N; n++) {
	        	if(take[n]){
	        		profitAchieved += stocks[n].profit;
	        		cost += stocks[n].cur_p;
	        		System.out.println(n + "\t" +stocks[n].name + "\t" + stocks[n].cur_p + "\t" + stocks[n].profit);
	        	}
	        }
	        System.out.println("Cost of investment " + cost);
	        System.out.println("Achievable Profit " + profitAchieved);
	    }


}
