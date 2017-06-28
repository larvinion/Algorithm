package kyu6_decodethemorsecode;

import java.util.StringTokenizer;

public class Solution {
	public static String decode(String morseCode){
		StringTokenizer st = new StringTokenizer(morseCode, " ", true);
		// StringTokenizer(String str,String delim, boolean returnDelims), if returnDelims is true, then delim is token
		
		StringBuilder solution = new StringBuilder();
		StringBuilder special  = new StringBuilder();
		int solution_length = 0;
		int special_length = 0;
		boolean flag = false;

		while(st.hasMoreTokens()){
			switch(st.nextToken()){
			case "...---...":
				special.append("SOS");
				special_length += 3;
				break;
			case "-.-.--":
				special.append("!");
				break;
			case ".-.-.-":
				solution.append(".");
				solution_length++;
				break;
			case " ":
				if(solution.toString().isEmpty())
					break;
				if(flag == true){
					solution.append(" ");
					flag = false;
					solution_length++;
				} else
					flag = true;
				 break;
			case ".-":
				solution.append("A");
				flag = false;
				solution_length++; break;
			case "-...":
				solution.append("B");
				flag = false;
				solution_length++; break;
			case "-.-.":
				solution.append("C");
				flag = false;
				solution_length++; break;
			case "-..":
				solution.append("D");
				flag = false;
				solution_length++; break;
			case ".":
				solution.append("E");
				flag = false;
				solution_length++; break;
			case "..-.":
				solution.append("F");
				flag = false;
				solution_length++; break;
			case "--.":
				solution.append("G");
				flag = false;
				solution_length++; break;
			case "....":
				solution.append("H");
				flag = false;
				solution_length++; break;
			case "..":
				solution.append("I");
				flag = false;
				solution_length++; break;
			case ".---":
				solution.append("J");
				flag = false;
				solution_length++; break;
			case "-.-":
				solution.append("K");
				flag = false;
				solution_length++; break;
			case ".-..":
				solution.append("L");
				flag = false;
				solution_length++; break;
			case "--":
				solution.append("M");
				flag = false;
				solution_length++; break;
			case "-.":
				solution.append("N");
				flag = false;
				solution_length++; break;
			case "---":
				solution.append("O");
				flag = false;
				solution_length++; break;
			case ".--.":
				solution.append("P");
				flag = false;
				solution_length++; break;
			case "--.-":
				solution.append("Q");
				flag = false;
				solution_length++; break;
			case ".-.":
				solution.append("R");
				flag = false;
				solution_length++; break;
			case "...":
				solution.append("S");
				flag = false;
				solution_length++; break;
			case "-":
				solution.append("T");
				flag = false;
				solution_length++; break;
			case "..-":
				solution.append("U");
				flag = false;
				solution_length++; break;
			case "...-":
				solution.append("V");
				flag = false;
				solution_length++; break;
			case ".--":
				solution.append("W");
				flag = false;
				solution_length++; break;
			case "-..-":
				solution.append("X");
				flag = false;
				solution_length++; break;
			case "-.--":
				solution.append("Y");
				flag = false;
				solution_length++; break;
			case "--..":
				solution.append("Z");
				flag = false;
				solution_length++; break;
				
			case ".----":
				solution.append("1");
				flag = false;
				solution_length++; break;
			case "..---":
				solution.append("2");
				flag = false;
				solution_length++; break;
			case "...--":
				solution.append("3");
				flag = false;
				solution_length++; break;
			case "....-":
				solution.append("4");
				flag = false;
				solution_length++; break;
			case ".....":
				solution.append("5");
				flag = false;
				solution_length++; break;
			case "-....":
				solution.append("6");
				flag = false;
				solution_length++; break;
			case "--...":
				solution.append("7");
				flag = false;
				solution_length++; break;
			case "---..":
				solution.append("8");
				flag = false;
				solution_length++; break;
			case "----.":
				solution.append("9");
				flag = false;
				solution_length++; break;
			case "-----":
				solution.append("0");
				flag = false;
				solution_length++; break;
			}
		}

		boolean blank = true;
		
		if(!solution.toString().equals("")){
			while(blank){
				switch(solution.charAt(solution_length-1)){
					case ' ':
						solution.deleteCharAt(solution_length-1);
						solution_length--;
						break;
					default:
						blank = false;
						break;
				}
			}
		}
		blank = true;
		
		if(!special.toString().equals("")){
			while(blank){
				switch(special.charAt(special_length-1)){
					case ' ':
						special.deleteCharAt(special_length-1);
						special_length--;
						break;
					default:
						blank = false;
						break;
				}
			}
		}

		if(special.toString().equals(""))
	        return solution.toString();
		else if(solution.toString().equals(""))
			return special.toString();
		else
	        return special.toString() + " " + solution.toString();

    }
}
