package no01_numberpick;

import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception	{
		int T;
        int test_case;
        /* 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
           만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면,
           그 아래에서 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
           따라서 본인의 PC 에서 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다.
           단, 이 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
		Scanner sc = new Scanner(System.in);
        
		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			//	이 부분에서 알고리즘 프로그램을 작성하십시오.
            int countNum; // TestCase 내부 숫자 갯수
			countNum = sc.nextInt(); // (TestCase 내 숫자의 갯수 입력)
	        int tempVari;
			int[] objectsArr = new int[countNum];	// 300만개(objects[0 ~ 2999999])
													// 주어지는 숫자는 300 만 이하의 자연수 이므로 자연수-1 번째의 배열에 입력
			int[] cursorArr = new int[countNum];	// 주어지는 숫자의 갯수만큼의 배열을 생성한 후 그 값을 배열값으로 설정 ( index 를 통해 배열의 반복을 줄이기 위해 ) 
			int result = 0;
			int cursor = 0;

			for(int case_interCount=0; case_interCount < countNum; case_interCount++){ // Testcase 내 모든 변수 개수
				tempVari = sc.nextInt(); // 숫자값 입력
				objectsArr[case_interCount] ++; // 해당값을 지칭하는 배열에 중복횟수 카운트
				cursorArr[case_interCount] = tempVari; // 해당 값을 배열의 값으로 설정
			}
			
			for(int case_interCount=0; case_interCount < countNum; case_interCount++){ // Testcase 내 모든 변수 개수
				cursor = cursorArr[case_interCount];
				if(objectsArr[case_interCount] % 2 != 0){ // 주어지는 숫자의 중복 횟수가 홀수 일 때
					result = result^cursor;
				}
			}
			//	이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}
}