package com.ijinus.utilities;

public class IOUtilities {
	
	public static void separator(String separatorText){
		StringBuffer str = new StringBuffer("//////////////////// ////////////////////\n#\n#\t\t");
		str.append(separatorText);
		str.append("\n#\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println(str);
	}
	
	public static void print(String stringToWrite){
		System.out.print(stringToWrite);
	}
	
	public static void println(String stringToWrite){
		System.out.println(stringToWrite);
	}

}
