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
			
			// List에 빈 List가 될 때까지 반복
			while(!stone.isEmpty()){
				nextStone = stone.remove(0);
				
				// 최대 점프가능 거리 안에서 건너뛸 수 있는 중간 돌들을 패스 
				// stone List의 원소가 한개인 경우 위의 remove를 통해 Empty가 성립하므로 반복문 종료
				while(!stone.isEmpty()){
					if(stone.get(0) - nowStone <= canJump){
						nextStone = stone.remove(0);
					}else
						break;
				}
				
				// 다음 돌로 뛸 수 없는 경우 종료
				if(nextStone - nowStone > canJump){
					jumpCount = -1;
					break;
				}

				// 다음 돌로 이동
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