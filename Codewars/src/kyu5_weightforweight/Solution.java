package kyu5_weightforweight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	/*
	 * 풀이순서
	 * 1. 첫번째 몸무게 부터 읽기 시작
	 * 2. HashMap에 몸무게의 각 자리수 숫자의 합을 Key에 두고 몸무게를 List에 추가하여 Value값에 저장
	 * (		
		// 각 자리수 숫자의 합이 같은 경우 
		// 1. 합도 같고 숫자도 같은 경우
		//		그대로 add
		// 2. 합은 같으나 숫자가 다른 경우
		//		작은 숫자부터 add
	 * )
	 * 3. 1 ~ 2의 과정을 숫자 끝까지 반복
	 * 4. HashMap의 첫번째 Key의 Value 값들을 반환
	 */
	
	public static String orderWeight(String strng) {
		StringBuilder solution = new StringBuilder();
		StringTokenizer st = new StringTokenizer(strng);
		
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		List<Integer> keys = new ArrayList<Integer>();

		String token = "";
		int key = 0;
		long value = 0;
		String temp = "";
		
		if(!st.hasMoreTokens()){
			solution.append("");
			return solution.toString();
		}
		
		while(st.hasMoreTokens()){
			List<String> values = new ArrayList<String>();
			
			token = st.nextToken();
			value = Long.parseLong(token);
			
			for(;value > 0;){
				key += value % 10;
				value /= 10;
			}
			
			if(map.containsKey(key))
				values = map.get(key);
			else{
				keys.add(key);
				values.clear();
			}
				
			values.add(token);
			
			map.put(key, values);
			
			key = 0;
		}

		// 키 순서 정렬
		Collections.sort(keys);

		// 키 순서대로 뽑아 value list의 값들을 순서대로 문자열에 추가
		while(!keys.isEmpty()){
			List<String> values = new ArrayList<String>();
			
			values = map.get(keys.remove(0));
			
			Collections.sort(values);
			
			// 이미 정렬 되어 있음 (같은 weight값을 key로 같는 list의 원소들)
			// values 정렬방법 조금 다름 오름차순이 아닌 앞자리 숫자의 크기로 오름차순
			// 10으로 나누었을때 몫의 크기로 정렬 (내림차순) 큰 몫 -> 작은 몫
			for(int i=0; i<values.size()-1;){
				if(weight(values.get(i), values.get(i+1))){
					i++;
					continue;
				}else{
					temp = values.get(i);
					values.set(i, values.get(i+1));
					values.set(i+1, temp);
					i = 0;
				}
			}
			
			while(!values.isEmpty())
				solution.append(values.remove(0) + " ");	
		}
		
		// 문자열 끝 " " 삭제
		solution.deleteCharAt(solution.length()-1);
		
		return solution.toString();
	}
	
	// weight 계산 (이미 values 오름차순으로 정렬되어 있음)
	public static boolean weight(String nowValue, String nextvalue){
		int length = 0;
		
		if(nowValue.length() <= nextvalue.length())
			length = nowValue.length();
		else
			length = nextvalue.length();
		
		for(int i=0; i<length; i++){
			if(nowValue.charAt(i) < nextvalue.charAt(i))
				return true;
			else if(nowValue.charAt(i) == nextvalue.charAt(i))
				continue;
			else
				return false;
		}
		
		return true;
	}
}
