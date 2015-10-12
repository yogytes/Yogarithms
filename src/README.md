### Problem details
#####	1.	Investor's dilemma
	
	-	Solution is achieved by dynamic programming with memorization attempting to increase the profit with given investment cap [1000 rs]
	-	Time complexity = O(nC) , where C is maximum capital and n is number of stocks to consider
	-	Space complexity = O(nC) for memorization table. The other two tables can be omitted, they are there to provide the solution along with the 	information on stocks to be selected.

	-	Sample Input/Output
	-	enter details in following order
	-	Capital | No.of.Companies(n) | followed by n triples<company_name current_price future_price> 
	-	1000
	-	5
	-	A 300 550
	-	B 250 500
	-	C 750 1050
	-	D 200 600
	-	E 200 100
	-	==================================
	-	Selected Stocks
	-	Number	Name	buy@	profit
	-	1	A	300	250
	-	2	B	250	250
	-	4	D	200	400
	-	===================================
	-	Cost of investment 750
	-	Achievable Profit 900
	 
#####	2.	Linking Loader
	-	Solution is achieved by going through each code module sequentially and assign memory addresses wherever feasible and then calculate the checksumm 		in separate iteration.
	-	O(CN)C- input cases, N number of lines in each case.
	-	Sample I/O
	- 	=====================================
	-	D MAIN 0
	- 	D END 5
	-	C 03 01 02 03
	-	C 03 04 05 06
	-	Z
	-	$
	-	D ENTRY 4
	-	E SUBX
	-	E SUBY
	-	C 10 1 2 3 4 5 $ 0 6 7 8 9 A B C D E
	-	C 8 10 20 30 40 50 60 70 80
	-	C 8 90 A0 B0 C0 D0 E0 $ 1
	-	C 5 $ 0 FF EE DD
	-	Z
	-	D SUBX 01
	-	C 06 A B C D E F
	-	Z
	-	D SUBX 05
	-	C 06 51 52 53 54 55 56
	-	Z
	-	$
	-	$
	-	=================================
	- 	Case  1  : Checksum =  0078
	-  	SYMBOL	ADDRESS
	-	
	-	MAIN 	 100
	-	END 	 105

	-	Case  2  : Checksum =  548c
	-	SYMBOL	ADDRESS
	-
	-	ENTRY 	 104
	-	SUBX 	 126 M
	-	SUBY	???? 
	-	====================================
#####	3.	Huffman
	-	From the give input the Huffman tree is constructed. Then the attempt is to recursively distribute the frequencies from root to level down and 	calculate the possibilities by multiplying the different distributions on left tree and right tree.
	- Unfortunately the output isn't matching the expected output and I am not sure on where exactly am I supposed to prune the distribution for it to be 	correct 