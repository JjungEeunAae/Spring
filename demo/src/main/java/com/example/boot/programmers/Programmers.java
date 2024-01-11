package com.example.boot.programmers;

public class Programmers {
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
		System.out.println(solution(arr));
	}
	
	public static String solution(int[] numLog) {
        String answer = "";
        
        for(int i = 1 ; i < numLog.length ; i++) {
        	if(numLog[i] - numLog[i-1] == 1) {
        		System.out.println(numLog[i] + ", " + numLog[i-1]);
        		answer += "w";
        	} else if(numLog[i] - numLog[i-1] == 10) {
        		answer += "d";
        	} else if(numLog[i] - numLog[i-1] == -1) {
        		answer += "s";
        	} else {
        		answer += "a";
        	};
        	/*
        	 *  i = 1 : 1 - 0       →   1  →=   w
				i = 2 : 0 - 1       →  -1  →   s
				i = 3 : 10 - 0      →  10  →   d
				i = 4 : 0 - 10      → -10  →   a
				i = 5 : 1 - 0       →   1  →   w
				i = 6 : 0 - 1       →  -1  →   s
				i = 7 : 10 - 0      →  10  →   d
				i = 8 : 0 - 10      → -10  →   a
				i = 9 : -1 - 0      →  -1  →   s
				i = 10 : -2 - -1    →  -1  →   s
				i = 11 : -1 - -2    →   1  →   w
        	 */
        }
        
        return answer;
    }
}
