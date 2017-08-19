package no56_extremenumber;

import java.math.BigInteger;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
	static BigInteger Answer;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			int basisIndex = sc.nextInt();	
			int geometricSequence = 1;
			int geometricSeries = 0;  // Sum of geometric sequence
			int pre_geometricSeries = 0; // Sum of geometric sequence (pre)
			int figure = 0;  // digit of extreme number
			
			for(;geometricSeries<basisIndex;figure++){
				pre_geometricSeries = geometricSeries;
				geometricSequence *= 2;
				geometricSeries += geometricSequence;
			}
			
			int index_th = basisIndex - pre_geometricSeries;
			
			StringBuilder st = new StringBuilder();
			
			for(int i=0; i<figure; i++){
				geometricSequence /= 2;
				if(index_th <= geometricSequence)
					st.append(4);
				else{
					st.append(7);
					index_th -= geometricSequence;
				}
			}
			
			Answer = new BigInteger(st.toString());
			
			/////////////////////////////////////////////////////////////////////////////////////////////

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);  // 
		}
	}
}