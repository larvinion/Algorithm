package kyu5_directionsreduction;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String[] dirReduc(String[] arr) {
    	List<String> solution = new ArrayList<String>();
    	int count = 0;
    	
    	for(String str : arr){
    		if(solution.isEmpty()){
    			solution.add(str);
    			count++;
    		}
    		else{
    			switch(str){
    				case "WEST":
    					if(solution.get(count-1).equals("EAST")){
    						solution.remove(count-1);
    						count--;
    					}else{
    						solution.add(str);
    						count++;
    					}
    					break;
    				case "EAST":
    					if(solution.get(count-1).equals("WEST")){
    						solution.remove(count-1);
    						count--;
    					}else{
    						solution.add(str);
    						count++;
    					}
    					break;
    				case "NORTH":
    					if(solution.get(count-1).equals("SOUTH")){
    						solution.remove(count-1);
    						count--;
    					}else{
    						solution.add(str);
    						count++;
    					}
    					break;
    				case "SOUTH":
    					if(solution.get(count-1).equals("NORTH")){
    						solution.remove(count-1);
    						count--;
    					}else{
    						solution.add(str);
    						count++;
    					}
    					break;
    			}
    		}
    	}
    	
        return solution.toArray((new String[solution.size()]));
    }
}
