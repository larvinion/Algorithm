package no4_dartgame;

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
        
		class Dot{
			int x = 0;
			int y = 0;
			
			public Dot(int coordinateX,int coordinateY){
				this.x = coordinateX;
				this.y = coordinateY;
			}
		}
		
		for(test_case = 1; test_case <= T; test_case++) {
			//	이 부분에서 알고리즘 프로그램을 작성하십시오.
			
			int totalPoint = 0; // 총점
			int casePoint = 0; // 한 다트당 점수
			
			// ( 0 ~ Double End )까지를 Single로 한 후 Single 안에서 if문을 통해 Bull, Triple, Double 을 구별
			// A Bull 반지름
			int BullStart = 0;
			int BullEnd = sc.nextInt();
			
			// B Triple Start 반지름
			// C Triple End 반지름
			int TripleStart = sc.nextInt();
			int TripleEnd = sc.nextInt();

			// D Double Start 반지름
			// E Double End 반지름
			// ( Double의 End 까지가 다트판의 가장자리, 그 외 바깥은 0점)
			int DoubleStart = sc.nextInt();
			int DoubleEnd = sc.nextInt();
			
			
			// 다트의 갯수
			int TotalDot = sc.nextInt();
			
			Dot[] Dot = new Dot[TotalDot];
			
			// 다트의 위치( x축 / y축 )
			for(int dotCursor = 0; dotCursor < TotalDot; dotCursor++){
				Dot[dotCursor] = new Dot(sc.nextInt(),sc.nextInt());
				casePoint = calculationDot(BullEnd,TripleStart,TripleEnd,DoubleStart,DoubleEnd,Dot[dotCursor].x,Dot[dotCursor].y);
				totalPoint += casePoint;
			}
			
			//	이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(totalPoint);
			
		}
	}
	public static int calculationDot(int A, int B, int C, int D, int E, int x, int y){
		// A Bull 반지름
		int BullStart = 0;
		int BullEnd = A;

		// B Triple Start 반지름
		// C Triple End 반지름
		int TripleStart = B;
		int TripleEnd = C;
		/*
		double disTripleStart = Math.sqrt((0*0)+(C*C));
		double disTripleEnd = Math.sqrt((0*0)+(D*D));
		System.out.println("disTripleStart : " + disTripleStart);
		System.out.println("disTripleEnd : " + disTripleEnd);
		*/	

		// D Double Start 반지름
		// E Double End 반지름
		// ( Double의 End 까지가 다트판의 가장자리, 그 외 바깥은 0점)
		int DoubleStart = D;
		int DoubleEnd = E;
		
		double disDot = Math.sqrt((x*x)+(y*y));
		int dotPoint = 0;
	
		// 좌표를 통해 해당 좌표의 기본 점수를 판단 
		// 여기에 다트판 좌표에 해당하는 점수 입력....
		/*
		if(BullStart <= x && x <= DoubleEnd){ // 1,4 사분면에 위치한 X좌표 (오른쪽)
			// 20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3
			
		}else if(-DoubleEnd <= x && x <= BullStart){ // 2,3 사분면에 위치한 X (왼쪽)
			// 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3
			
		}else{ // 원 바깥에 위치한 X
			dotPoint = 0;
		}
		
		if(BullStart <= y && y <= DoubleEnd){ // 1,2 사분면에 위치한 Y좌표 (위)
			// 11, 14, 9, 12, 5, 20, 1, 18, 4, 13, 6
			
		}else if(-DoubleEnd <= y && y <= BullStart){ // 3,4 사분면에 위치한 Y (아래)
			// 11, 8, 16, 7, 19, 3, 17, 2, 15, 10, 6
			
		}else{ // 원 바깥에 위치한 Y
			dotPoint = 0;
		}
		*/
		// 위에꺼 필요없을듯... 그냥 해당 좌표에 대한 Cos 각도 구한 다음에 각도에 따라 점수 배정하면 될 듯

		double temp = Math.acos(x/disDot);
		double degree = Math.toDegrees(temp);
		
		int sign = 0; // 0 == 양수 , 1 == 음수
		// 각도 제대로 안나옴.... 쥬륵...
		// 위 아래의 경우로 나누어 생각 ( y축의 부호를 통해 2가지 경우로 나눔) => cos값을 통한 각도의 값이 오른쪽에서 부터 위아래 같은 값 나옴(위아래 반전)
		if(y > 0){ // y축의 값이 양수인 경우
			sign = 0;
		}else{ // y축의 값이 음수인 경우
			sign = 1;
		}
		
		// 각 경계 각도에 위치하고 있는 경우 없다고 가정하므로!!
		
		if(sign == 0){ // y축 값이 양수인 경우 == 위의 경우 1,4 사분면
			// 각 다트판의 점수부분 18도 
			// 첫 부분과 끝 부분은 9도씩
			if(0 <= degree && degree < 9){
				dotPoint = 6;
			}else if(9 < degree && degree < 27){
				dotPoint = 13;
			}else if(27 < degree && degree < 45){
				dotPoint = 4;
			}else if(45 < degree && degree < 63){
				dotPoint = 18;
			}else if(63 < degree && degree < 81){
				dotPoint = 1;
			}else if(81 < degree && degree < 99){
				dotPoint = 20;
			}else if(99 < degree && degree < 117){
				dotPoint = 5;
			}else if(117 < degree && degree < 135){
				dotPoint = 12;
			}else if(135 < degree && degree < 153){
				dotPoint = 9;
			}else if(153 < degree && degree < 171){
				dotPoint = 14;
			}else if(171 < degree && degree <= 180){
				dotPoint = 11;
			}
		}else{ // y축 값이 음수인 경우 == 아래의 경우 2,3 사분면
			if(0 <= degree && degree < 9){
				dotPoint = 6;
			}else if(9 < degree && degree < 27){
				dotPoint = 10;
			}else if(27 < degree && degree < 45){
				dotPoint = 15;
			}else if(45 < degree && degree < 63){
				dotPoint = 2;
			}else if(63 < degree && degree < 81){
				dotPoint = 17;
			}else if(81 < degree && degree < 99){
				dotPoint = 3;
			}else if(99 < degree && degree < 117){
				dotPoint = 19;
			}else if(117 < degree && degree < 135){
				dotPoint = 7;
			}else if(135 < degree && degree < 153){
				dotPoint = 16;
			}else if(153 < degree && degree < 171){
				dotPoint = 8;
			}else if(171 < degree && degree <= 180){
				dotPoint = 11;
			}
		}
		

		// 거리로 Bull(A), Triple(B~C), Double(D~E), 기본(0~E), 그 외 0점 판단 한 후
		// 거리의 경우 위의 경우들이 반지름(0부터의 거리)이므로 해당 좌표의 값(x,y)에 해당하는 거리만 계산하면 Ok
		if(BullStart <= disDot && disDot <= BullEnd){ // 1,2,3,4사분면 Bull 
			dotPoint = 50;
		}else if(TripleStart <= disDot && disDot <= TripleEnd){ // 1,2,3,4사분면 Triple
			dotPoint *= 3;
		}else if(DoubleStart <= disDot && disDot <= DoubleEnd){ // 1,2,3,4사분면 Double
			dotPoint *= 2;
		}else if(BullStart <= disDot && disDot <= DoubleEnd){ // 1,2,3,4사분면 기본 점수
			dotPoint *= 1;
		}else{ // 그 외 부분(다트판 밖)
			dotPoint = 0;
		}
		
		return dotPoint;
	}
}