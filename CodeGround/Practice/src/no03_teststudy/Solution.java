package no03_teststudy;

import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
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
            int totalCase = sc.nextInt(); // ��� ���� ��
			int choiceCase = sc.nextInt(); // ������ �� �ִ� ���� ��
			int maxPoint = 0;
			
			int[] point = new int[totalCase];
			for(int cursor = 0; cursor < totalCase; cursor++){
				point[cursor] = sc.nextInt();
			}
			
			Arrays.sort(point);

			int backCursor = point.length-1;
			
			for(int cursor = 0; cursor < choiceCase; cursor++){
				maxPoint += point[backCursor--];
			}
				
			//	�� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(maxPoint);
		}
	}
}