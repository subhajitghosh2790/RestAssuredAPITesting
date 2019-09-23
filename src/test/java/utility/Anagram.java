package utility;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s1 = "xx feed";

		String s2 = "eeee ldfd";
		
		s1 = s1.replace(" ", ""); //remove white spaces
		s2 = s2.replace(" ", "");//remove white spaces
		
		System.out.println(s1+"   "+s2);
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		
		System.out.println((new String(c1))+"    "+(new String(c2)));
		if((new String(c1).equals(new String(c2))))
			System.out.println("Its anagram");
		else
			System.out.println("Not anagram");
		
	}

}
