package kyu5_weightforweight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	/*
	 * Ǯ�̼���
	 * 1. ù��° ������ ���� �б� ����
	 * 2. HashMap�� �������� �� �ڸ��� ������ ���� Key�� �ΰ� �����Ը� List�� �߰��Ͽ� Value���� ����
	 * (		
		// �� �ڸ��� ������ ���� ���� ��� 
		// 1. �յ� ���� ���ڵ� ���� ���
		//		�״�� add
		// 2. ���� ������ ���ڰ� �ٸ� ���
		//		���� ���ں��� add
	 * )
	 * 3. 1 ~ 2�� ������ ���� ������ �ݺ�
	 * 4. HashMap�� ù��° Key�� Value ������ ��ȯ
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

		// Ű ���� ����
		Collections.sort(keys);

		// Ű ������� �̾� value list�� ������ ������� ���ڿ��� �߰�
		while(!keys.isEmpty()){
			List<String> values = new ArrayList<String>();
			
			values = map.get(keys.remove(0));
			
			Collections.sort(values);
			
			// �̹� ���� �Ǿ� ���� (���� weight���� key�� ���� list�� ���ҵ�)
			// values ���Ĺ�� ���� �ٸ� ���������� �ƴ� ���ڸ� ������ ũ��� ��������
			// 10���� ���������� ���� ũ��� ���� (��������) ū �� -> ���� ��
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
		
		// ���ڿ� �� " " ����
		solution.deleteCharAt(solution.length()-1);
		
		return solution.toString();
	}
	
	// weight ��� (�̹� values ������������ ���ĵǾ� ����)
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
