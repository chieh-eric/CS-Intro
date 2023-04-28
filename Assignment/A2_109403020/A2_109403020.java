/*
 Assignment 2
 Name : 王廷傑
 Student Number : 109403020
 Course 2023-CE1002
 */
package A2_109403020;
import java.util.Scanner;

public class A2_109403020 {
	public static void main(String [] args)
	{
		String input;
		boolean t;
		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		t=checkPalindrome(input);
		if(t)
		{
			System.out.println("Yes");
		}
		else
		{
			for(int i = 0 ; i < input.length();i++)
			{
				String tmp;
				tmp = input.substring(0,i)+input.substring(i+1);
				t = checkPalindrome(tmp);
				if(t)
				{
					System.out.println("Yes if a word is deleted");
					return;
				}
			}
			System.out.println("No");
		}
	}


	public static boolean checkPalindrome(String input)
	{
		String reverse;
		input = input.toLowerCase();
		StringBuilder strb = new StringBuilder(input);
		reverse = strb.reverse().toString().toLowerCase();
		if(input.equals(reverse))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}