package no02_1stcount;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
	static int Answer;

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
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			int people = sc.nextInt();
			int maxCasePoint = people;
			
			int minFirstPrizePoint = 0;
			
			int prizePeople = 0;
			
			int[] point = new int[people];
			
			for(int cursor = 0; cursor < people; cursor++){
				point[cursor] = sc.nextInt();
			}
            
			Arrays.sort(point);
			
			for(int cursor = 0; cursor < people; cursor++){
				if(point[cursor] + maxCasePoint-cursor >= minFirstPrizePoint)
					minFirstPrizePoint = point[cursor] + maxCasePoint-cursor;
			}
			
			for(int cursor = 0; cursor < people; cursor++){
				if(point[cursor]+maxCasePoint >= minFirstPrizePoint)
					prizePeople++;
			}

			Answer = prizePeople;

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}