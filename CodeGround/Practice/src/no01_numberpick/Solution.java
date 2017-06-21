package no01_numberpick;

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
		for(test_case = 1; test_case <= T; test_case++) {
			//	�� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
            int countNum; // TestCase ���� ���� ����
			countNum = sc.nextInt(); // (TestCase �� ������ ���� �Է�)
	        int tempVari;
			int[] objectsArr = new int[countNum];	// 300����(objects[0 ~ 2999999])
													// �־����� ���ڴ� 300 �� ������ �ڿ��� �̹Ƿ� �ڿ���-1 ��°�� �迭�� �Է�
			int[] cursorArr = new int[countNum];	// �־����� ������ ������ŭ�� �迭�� ������ �� �� ���� �迭������ ���� ( index �� ���� �迭�� �ݺ��� ���̱� ���� ) 
			int result = 0;
			int cursor = 0;

			for(int case_interCount=0; case_interCount < countNum; case_interCount++){ // Testcase �� ��� ���� ����
				tempVari = sc.nextInt(); // ���ڰ� �Է�
				objectsArr[case_interCount] ++; // �ش簪�� ��Ī�ϴ� �迭�� �ߺ�Ƚ�� ī��Ʈ
				cursorArr[case_interCount] = tempVari; // �ش� ���� �迭�� ������ ����
			}
			
			for(int case_interCount=0; case_interCount < countNum; case_interCount++){ // Testcase �� ��� ���� ����
				cursor = cursorArr[case_interCount];
				if(objectsArr[case_interCount] % 2 != 0){ // �־����� ������ �ߺ� Ƚ���� Ȧ�� �� ��
					result = result^cursor;
				}
			}
			//	�� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}
}