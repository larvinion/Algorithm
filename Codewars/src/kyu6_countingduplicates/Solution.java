package kyu6_countingduplicates;

import java.util.HashMap;
import java.util.Map;

public class Solution{
	public static int duplicateCount(String text) {
	    // Write your code here
		StringBuilder sb = new StringBuilder(text.toLowerCase());
		
		Map<Character, Boolean> map= new HashMap<Character, Boolean>();
		int count = 0;
		
		for(int i=0; i<sb.length(); i++){
			char key = sb.charAt(i);
			if(map.get(key) == null)
				map.put(key, false);
			else if(map.get(key) == false){
				map.put(key, true);
				count++;
			}
		}
		
		return count;
	}
}
