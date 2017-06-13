package no4_dartgame;

import java.util.Scanner;
import java.io.FileInputStream;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class Solution {
	public static void main(String args[]) throws Exception	{
		int T;
        int test_case;
        /* �Ʒ� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
           ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� �߰��ϸ�,
           �� �Ʒ����� �Է��� ������ �� ǥ�� �Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
           ���� ������ PC ���� �׽�Ʈ �� ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �˴ϴ�.
           ��, �� �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�. */
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
			//	�� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			
			int totalPoint = 0; // ����
			int casePoint = 0; // �� ��Ʈ�� ����
			
			// ( 0 ~ Double End )������ Single�� �� �� Single �ȿ��� if���� ���� Bull, Triple, Double �� ����
			// A Bull ������
			int BullStart = 0;
			int BullEnd = sc.nextInt();
			
			// B Triple Start ������
			// C Triple End ������
			int TripleStart = sc.nextInt();
			int TripleEnd = sc.nextInt();

			// D Double Start ������
			// E Double End ������
			// ( Double�� End ������ ��Ʈ���� �����ڸ�, �� �� �ٱ��� 0��)
			int DoubleStart = sc.nextInt();
			int DoubleEnd = sc.nextInt();
			
			
			// ��Ʈ�� ����
			int TotalDot = sc.nextInt();
			
			Dot[] Dot = new Dot[TotalDot];
			
			// ��Ʈ�� ��ġ( x�� / y�� )
			for(int dotCursor = 0; dotCursor < TotalDot; dotCursor++){
				Dot[dotCursor] = new Dot(sc.nextInt(),sc.nextInt());
				casePoint = calculationDot(BullEnd,TripleStart,TripleEnd,DoubleStart,DoubleEnd,Dot[dotCursor].x,Dot[dotCursor].y);
				totalPoint += casePoint;
			}
			
			//	�� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(totalPoint);
			
		}
	}
	public static int calculationDot(int A, int B, int C, int D, int E, int x, int y){
		// A Bull ������
		int BullStart = 0;
		int BullEnd = A;

		// B Triple Start ������
		// C Triple End ������
		int TripleStart = B;
		int TripleEnd = C;
		/*
		double disTripleStart = Math.sqrt((0*0)+(C*C));
		double disTripleEnd = Math.sqrt((0*0)+(D*D));
		System.out.println("disTripleStart : " + disTripleStart);
		System.out.println("disTripleEnd : " + disTripleEnd);
		*/	

		// D Double Start ������
		// E Double End ������
		// ( Double�� End ������ ��Ʈ���� �����ڸ�, �� �� �ٱ��� 0��)
		int DoubleStart = D;
		int DoubleEnd = E;
		
		double disDot = Math.sqrt((x*x)+(y*y));
		int dotPoint = 0;
	
		// ��ǥ�� ���� �ش� ��ǥ�� �⺻ ������ �Ǵ� 
		// ���⿡ ��Ʈ�� ��ǥ�� �ش��ϴ� ���� �Է�....
		/*
		if(BullStart <= x && x <= DoubleEnd){ // 1,4 ��и鿡 ��ġ�� X��ǥ (������)
			// 20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3
			
		}else if(-DoubleEnd <= x && x <= BullStart){ // 2,3 ��и鿡 ��ġ�� X (����)
			// 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3
			
		}else{ // �� �ٱ��� ��ġ�� X
			dotPoint = 0;
		}
		
		if(BullStart <= y && y <= DoubleEnd){ // 1,2 ��и鿡 ��ġ�� Y��ǥ (��)
			// 11, 14, 9, 12, 5, 20, 1, 18, 4, 13, 6
			
		}else if(-DoubleEnd <= y && y <= BullStart){ // 3,4 ��и鿡 ��ġ�� Y (�Ʒ�)
			// 11, 8, 16, 7, 19, 3, 17, 2, 15, 10, 6
			
		}else{ // �� �ٱ��� ��ġ�� Y
			dotPoint = 0;
		}
		*/
		// ������ �ʿ������... �׳� �ش� ��ǥ�� ���� Cos ���� ���� ������ ������ ���� ���� �����ϸ� �� ��

		double temp = Math.acos(x/disDot);
		double degree = Math.toDegrees(temp);
		
		int sign = 0; // 0 == ��� , 1 == ����
		// ���� ����� �ȳ���.... �긤...
		// �� �Ʒ��� ���� ������ ���� ( y���� ��ȣ�� ���� 2���� ���� ����) => cos���� ���� ������ ���� �����ʿ��� ���� ���Ʒ� ���� �� ����(���Ʒ� ����)
		if(y > 0){ // y���� ���� ����� ���
			sign = 0;
		}else{ // y���� ���� ������ ���
			sign = 1;
		}
		
		// �� ��� ������ ��ġ�ϰ� �ִ� ��� ���ٰ� �����ϹǷ�!!
		
		if(sign == 0){ // y�� ���� ����� ��� == ���� ��� 1,4 ��и�
			// �� ��Ʈ���� �����κ� 18�� 
			// ù �κа� �� �κ��� 9����
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
		}else{ // y�� ���� ������ ��� == �Ʒ��� ��� 2,3 ��и�
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
		

		// �Ÿ��� Bull(A), Triple(B~C), Double(D~E), �⺻(0~E), �� �� 0�� �Ǵ� �� ��
		// �Ÿ��� ��� ���� ������ ������(0������ �Ÿ�)�̹Ƿ� �ش� ��ǥ�� ��(x,y)�� �ش��ϴ� �Ÿ��� ����ϸ� Ok
		if(BullStart <= disDot && disDot <= BullEnd){ // 1,2,3,4��и� Bull 
			dotPoint = 50;
		}else if(TripleStart <= disDot && disDot <= TripleEnd){ // 1,2,3,4��и� Triple
			dotPoint *= 3;
		}else if(DoubleStart <= disDot && disDot <= DoubleEnd){ // 1,2,3,4��и� Double
			dotPoint *= 2;
		}else if(BullStart <= disDot && disDot <= DoubleEnd){ // 1,2,3,4��и� �⺻ ����
			dotPoint *= 1;
		}else{ // �� �� �κ�(��Ʈ�� ��)
			dotPoint = 0;
		}
		
		return dotPoint;
	}
}