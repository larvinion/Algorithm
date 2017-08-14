package no49_hello;

import java.util.HashMap;
import java.util.Map;

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

			// Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			StringBuilder st = new StringBuilder(sc.next());
			
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			
			map.put('h', 0);
			map.put('e', 0);
			map.put('l', 0);
			map.put('o', 0);
			
			for(int i=0; i<st.length(); i++){
				switch(st.charAt(i)){
					case 'h':
						map.put('h', map.get('h')+1);
						break;
					case 'e':
						map.put('e', map.get('e')+1);
						break;
					case 'l':
						map.put('l', map.get('l')+1);
						break;
					case 'o':
						map.put('o', map.get('o')+1);
						break;
				}
			}
			
			if(map.get('h') == 0 || map.get('e') == 0 || map.get('o') == 0 || map.get('l') <= 1 )
				Answer = 0;
			else{
				int min_oneAlpha = Integer.min(Integer.min(map.get('h'), map.get('e')), map.get('o')); 
				int min_twoAlpha = map.get('l')/2;
				
				Answer = Integer.min(min_oneAlpha, min_twoAlpha);
				
			}
			
			/////////////////////////////////////////////////////////////////////////////////////////////


			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}