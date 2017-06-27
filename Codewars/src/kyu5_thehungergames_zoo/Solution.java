package kyu5_thehungergames_zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static String[] whoEatsWho(final String zoo){
		StringTokenizer st = new StringTokenizer(zoo);
		
		List<String> list = new ArrayList<String>();
		List<String> solution = new ArrayList<String>();
		
		String temp = "";
		int count = 0;
		
		while(st.hasMoreTokens()){
			temp = st.nextToken(",");
			
			list.add(temp);
		}
	
		solution.add(zoo);
		
		// �Է¹��� ����Ʈ�� ����������� �ݺ�
		// ���� �� ��� ����Ʈ�� ù��° ���Һ��� �ٽ� ���� �Ǵ��� ��
		while(!list.isEmpty()){
			// ����Ʈ�� ũ�Ⱑ 1�� ��� (���� 1��)
			if(list.size() == 1){
				solution.add(list.remove(0));
				break;
			}
			
			// ����Ʈ�� ù ��° ���Ҹ� ����ų ���
			if(count == 0){
				// ������ ���� �������� �Ǵ�
				if(predation(solution, list.get(count), list.get(count+1))){
					list.remove(count+1);
					count = 0;
					continue;
				}
			// ����Ʈ�� ������ ���Ҹ� ����ų ���
			}else if(count == list.size()-1){
				// ���� ���� �������� �Ǵ�
				if(predation(solution, list.get(count), list.get(count-1))){
					list.remove(count-1);
					count = 0;
					continue;
				// �ƴ� ��� ��ü ����Ʈ ��ȯ
				}else{
					// �̺κп��� ��ü�� �ϳ��ϳ� �߰��ϴ°� �ƴ� ��ü �迭�� �ٷ� �־�� ��
					// list.remove�� �ϳ��� ���� �ְԵǸ� �迭 ������ ��ü�� Ŀ���Ƿ� �ϳ��� ���ҷ� �־ �迭 ������ 1�� Ŀ������
					String str = "";
					while(!list.isEmpty()){
						str += list.remove(0) + ",";
					}
					solution.add(str.substring(0, str.length()-1));
					break;
				}
			// ����Ʈ�� ù��°, ������ ���Ұ� �ƴ� ��� ���� ���� �Ǵ�
			}else if(predation(solution, list.get(count), list.get(count-1))){
				list.remove(count-1);
				count = 0;
				continue;
			// ����Ʈ�� ù��°, ������ ���Ұ� �ƴ� ��� ������ ���� �Ǵ�
			}else if(predation(solution, list.get(count), list.get(count+1))){
				list.remove(count+1);
				count = 0;
				continue;
			}
			count++;
		}

		String[] result = solution.toArray(new String[solution.size()]);
		
		return result;
	}
	
	public static boolean predation(List<String> list, String predator, String prey){
		switch(predator){
			case "antelope":
				if(prey.equals("grass"))
					return list.add(predator + " eats " + prey);
				break;
			case "big-fish":
				if(prey.equals("little-fish"))
					return list.add(predator + " eats " + prey);
				break;
			case "bug":
				if(prey.equals("leaves"))
					return list.add(predator + " eats " + prey);
				break;
			case "bear":
				if(prey.equals("big-fish") || prey.equals("bug") || prey.equals("chicken") || prey.equals("cow") || prey.equals("leaves") || prey.equals("sheep"))
					return list.add(predator + " eats " + prey);
				break;
			case "chicken":
				if(prey.equals("bug"))
					return list.add(predator + " eats " + prey);
				break;
			case "cow":
				if(prey.equals("grass"))
					return list.add(predator + " eats " + prey);
				break;
			case "fox":
				if(prey.equals("chicken") || prey.equals("sheep"))
					return list.add(predator + " eats " + prey);
				break;
			case "giraffe":
				if(prey.equals("leaves"))
					return list.add(predator + " eats " + prey);
				break;
			case "lion":
				if(prey.equals("antelope") || prey.equals("cow"))
					return list.add(predator + " eats " + prey);
				break;
			case "panda":
				if(prey.equals("leaves"))
					return list.add(predator + " eats " + prey);
				break;
			case "sheep":
				if(prey.equals("grass"))
					return list.add(predator + " eats " + prey);
				break;
			default :
				break;
			
		}
		return false;
	}
}
