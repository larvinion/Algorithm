package kyu5_doublecola;

public class Solution {
	public static String WhoIsNext(String[] names, int n){
		String solution = "";
		int shift = 1;
		int shiftCount = 0;
		int person = 0;
		int queue = names.length;
		
		person = shift<<shiftCount;
		queue = person * names.length;
		
		while(queue < n) {
			n -= queue;
			shiftCount++;
			person = shift<<shiftCount;
			queue = person * 5;
		}
		for(int i=0; i<names.length; i++) {
			if(person < n)
				n -= person;
			else {
				solution = names[i];
				break;
			}
		}
		return solution;
	}
}
