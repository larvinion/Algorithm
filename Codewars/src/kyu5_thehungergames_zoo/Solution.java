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
		
		// 입력받은 리스트가 비어질때까지 반복
		// 포식 할 경우 리스트의 첫번째 원소부터 다시 포식 판단을 함
		while(!list.isEmpty()){
			// 리스트의 크기가 1인 경우 (원소 1개)
			if(list.size() == 1){
				solution.add(list.remove(0));
				break;
			}
			
			// 리스트의 첫 번째 원소를 가리킬 경우
			if(count == 0){
				// 오른쪽 포식 가능한지 판단
				if(predation(solution, list.get(count), list.get(count+1))){
					list.remove(count+1);
					count = 0;
					continue;
				}
			// 리스트의 마지막 원소를 가리킬 경우
			}else if(count == list.size()-1){
				// 왼쪽 포식 가능한지 판단
				if(predation(solution, list.get(count), list.get(count-1))){
					list.remove(count-1);
					count = 0;
					continue;
				// 아닐 경우 전체 리스트 반환
				}else{
					// 이부분에서 전체를 하나하나 추가하는게 아닌 전체 배열을 바로 넣어야 함
					// list.remove로 하나씩 빼서 넣게되면 배열 사이즈 자체가 커지므로 하나의 원소로 넣어서 배열 사이즈 1만 커지도록
					String str = "";
					while(!list.isEmpty()){
						str += list.remove(0) + ",";
					}
					solution.add(str.substring(0, str.length()-1));
					break;
				}
			// 리스트의 첫번째, 마지막 원소가 아닐 경우 왼쪽 포식 판단
			}else if(predation(solution, list.get(count), list.get(count-1))){
				list.remove(count-1);
				count = 0;
				continue;
			// 리스트의 첫번째, 마지막 원소가 아닐 경우 오른쪽 포식 판단
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
