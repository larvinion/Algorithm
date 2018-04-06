package no57_bracket;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
	static int Answer;
	
	public enum Bracket {
		LEFT_SMALL('(', true), LEFT_MIDDLE('{', true), LEFT_LARGE('[', true), RIGHT_SMALL(')', false), RIGHT_MIDDLE('}', false), RIGHT_LARGE(']', false);
		
		private final char bracket;
		private final boolean isLeft;
		
		Bracket(char bracket, boolean isLeft) {
			this.bracket = bracket;
			this.isLeft = isLeft;
		}
		
		private static final Map<Character, Bracket> enumMap = new HashMap<Character, Bracket>();
		
		static {
			for(Bracket bracket : Bracket.values()) {
				enumMap.put(bracket.getBracket(), bracket);
			}
		}
		
		public static Bracket getEnum(char bracket) {
			if(!enumMap.containsKey(bracket)) {
				throw new IllegalArgumentException();
			}
			return enumMap.get(bracket);
		}
		
		public char getBracket() {
			return bracket;
		}
		
		public boolean isLeft() {
			return isLeft;
		}
	}

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
			char[] charString = sc.next().toCharArray();
			Stack<Character> brackets = new Stack<Character>();
			List<Boolean> linear = new ArrayList<Boolean>();
			int rightMatchCount = 0;
			Answer = 0;
			
			for(int i=0; i<charString.length; i++) {
				char bracket = charString[i];
				linear.add(false);

				if(Bracket.getEnum(bracket).isLeft()) {
					brackets.push(bracket);
				}
				else{// right bracket
					if(brackets.isEmpty()) {
					}else{
						switch (Bracket.getEnum(bracket).getBracket()) {
							case ')':
								if(brackets.peek() == '(') {
									brackets.pop();
									linear.set(i, true);
									for(int j=i-1; j>=0; j--) {
										if(linear.get(j) == false) {
											linear.set(j, true);
											break;
										}
									}
								}else {
									brackets.clear();
								}
								break;
							case '}':
								if(brackets.peek() == '{') {
									brackets.pop();
									linear.set(i, true);
									for(int j=i-1; j>=0; j--) {
										if(linear.get(j) == false) {
											linear.set(j, true);
											break;
										}
									}
								}else {
									brackets.clear();
								}
								break;
							case ']':
								if(brackets.peek() == '[') {
									brackets.pop();
									linear.set(i, true);
									for(int j=i-1; j>=0; j--) {
										if(linear.get(j) == false) {
											linear.set(j, true);
											break;
										}
									}
								}else {
									brackets.clear();
								}
								break;
						}
					}
				}
			}
			
			for(int i=0; i<linear.size(); i++) {
				if(linear.get(i) == true) {
					rightMatchCount++;
					Answer = Math.max(rightMatchCount, Answer);
				}else {
					Answer = Math.max(rightMatchCount, Answer);
					rightMatchCount = 0;
				}
			}
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}