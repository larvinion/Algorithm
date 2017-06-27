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
			
			switch(temp){
				case "antelope":
					list.add(temp);
					continue;
				case "grass":
					list.add(temp);
					continue;
				case "big-fish":
					list.add(temp);
					continue;
				case "little-fish":
					list.add(temp);
					continue;
				case "bug":
					list.add(temp);
					continue;
				case "leaves":
					list.add(temp);
					continue;
				case "bear":
					list.add(temp);
					continue;
				case "chicken":
					list.add(temp);
					continue;
				case "cow":
					list.add(temp);
					continue;
				case "fox":
					list.add(temp);
					continue;
				case "giraffe":
					list.add(temp);
					continue;
				case "lion":
					list.add(temp);
					continue;
				case "panda":
					list.add(temp);
					continue;
				case "sheep":
					list.add(temp);
					continue;
				default :
					solution.add(zoo);
					solution.add(zoo);
					
					String[] result = solution.toArray(new String[solution.size()]);
					
					return result;
			}
		}
	
		solution.add(zoo);
		
		while(!list.isEmpty()){
			if(list.size() == 1){
				solution.add(list.remove(0));
				break;
			}
			
			if(count == 0){
				if(predation(solution, list.get(count), list.get(count+1))){
					list.remove(count+1);
					count = 0;
					continue;
				}
			}else if(count == list.size()-1){
				if(predation(solution, list.get(count), list.get(count-1))){
					list.remove(count-1);
					count = 0;
					continue;
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
			}else if(predation(solution, list.get(count), list.get(count-1))){
				list.remove(count-1);
				count = 0;
				continue;
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
			
		}
		return false;
	}
}
