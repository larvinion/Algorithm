package no11_frogjump;

/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
			int stones = sc.nextInt();
			List<Integer> stone = new ArrayList<>();
			
			for(int i=0; i<stones; i++){
				stone.add(sc.nextInt());
			}
			int canJump = sc.nextInt();

			int nowStone = 0;
			int nextStone = 0;
			int jumpCount = 0;
			
			// List�� �� List�� �� ������ �ݺ�
			while(!stone.isEmpty()){
				nextStone = stone.remove(0);
				
				// �ִ� �������� �Ÿ� �ȿ��� �ǳʶ� �� �ִ� �߰� ������ �н� 
				// stone List�� ���Ұ� �Ѱ��� ��� ���� remove�� ���� Empty�� �����ϹǷ� �ݺ��� ����
				while(!stone.isEmpty()){
					if(stone.get(0) - nowStone <= canJump){
						nextStone = stone.remove(0);
					}else
						break;
				}
				
				// ���� ���� �� �� ���� ��� ����
				if(nextStone - nowStone > canJump){
					jumpCount = -1;
					break;
				}

				// ���� ���� �̵�
				nowStone = nextStone;
				jumpCount++;
			}
			
			Answer = jumpCount;
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}