package no42_subarray;

import java.util.ArrayList;
import java.util.List;

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
			int sequenceSize = sc.nextInt();
			int standard = sc.nextInt();
			
			List<Integer> sequence = new ArrayList<Integer>();
			
			for(int i=0; i<sequenceSize; i++){
				int temp = sc.nextInt();
				sequence.add(temp);
				Answer += temp;
			}
			
			if(Answer < standard)
				Answer = 0;
			else{
				Answer = subArray(standard, sequence);
			}
			/////////////////////////////////////////////////////////////////////////////////////////////


			// Print the answer to standard output(screen).
			System.out.println("#testcase"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static int subArray(int standard, List<Integer> list){
		int answer = 0;
		
		int[] array = new int[list.size()];
		
		for(int i=0; i<array.length; i++){
			array[i] = list.get(i);
		}
		
		for(int i=2; i<=array.length; i++){
			for(int j=0; j<=array.length-i; j++){
				int value = array[j];

				value += list.get(j+i-1);
				
				if(value >= standard){
					answer = i;
					return answer;
				}
				
				array[j] = value;
			}
		}
		
		return answer;
	}
}