package kyu4_next_bigger_number_with_the_same_digits;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
	public static long nextBiggerNumber(long n) {
      String longValue = Long.toString(n);
  		char[] values = longValue.toCharArray();
  
  		Set<Long> solutionSet = new TreeSet<Long>();
  		Set<String> keySet = new TreeSet<String>();
  		
  		int countDigit = 0;
  		int lengthDigit = values.length;
  		
  		Map<String, List<Character>> initMap = new TreeMap<String, List<Character>>();
  		StringBuilder sb = new StringBuilder();
  		
  		while(countDigit < lengthDigit) {
  			List<Character> list = new ArrayList<Character>();
  			List<Character> subList = new ArrayList<Character>();
  			Map<String, List<Character>> subMap = new TreeMap<String, List<Character>>();
  			
  			StringBuilder standard = new StringBuilder();
  			for(int i=0; i<countDigit; i++) {
  				standard.append(values[i]);
  			}
  			
  			if(initMap.isEmpty()) {
  				for(int i=0; i<values.length; i++) {
  					char value = values[i];
  					sb = new StringBuilder();
  					sb.append(value);
  					list = new ArrayList<Character>();
  					
  					for(int j=0; j<values.length; j++) {
  						if(i != j)
  							list.add(values[j]);
  					}
  					
  					initMap.put(sb.toString(), list);
  				}
  			}else {
  				keySet = new TreeSet<String>(initMap.keySet());
  				subMap = new TreeMap<String, List<Character>>();
  				
  				for(String key : keySet) {
  					if(Long.parseLong(key) < Long.parseLong(standard.toString())) {
  						initMap.remove(key);
  						continue;
  					}
  					
  					list = initMap.get(key);
  					
  					for(int i=0; i<list.size(); i++) {
  						Character cha = list.get(i);
  						sb = new StringBuilder(key);
  						sb.append(cha);
  						subList = new ArrayList<Character>();
  						
  						for(int j=0; j<list.size(); j++) {
  							if(i != j) {
  								subList.add(list.get(j));
  							}
  						}
  						subMap.put(sb.toString(), subList);
  					}
  				}
  				initMap = new TreeMap<String, List<Character>>(subMap);
  			}
  			
  			countDigit++;
  		}
  		
  		for(String str : initMap.keySet()) {
  			solutionSet.add(Long.parseLong(str));
  		}
  		
  		for(long solution : solutionSet) {
  			if(solution > n)
  				return solution;
  		}
  		
  		n = -1;
  		
  		return n;
    }
}
