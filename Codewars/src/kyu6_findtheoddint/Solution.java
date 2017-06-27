package kyu6_findtheoddint;

public class Solution {
	public static int findIt(int[] A){
		int result = 0;
		
		for(int i=0; i<A.length; i++){
			result ^= A[i];
		}
		
		return result;
	}
}
