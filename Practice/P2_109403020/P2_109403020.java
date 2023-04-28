/*
 Practice 2
 Name : 王廷傑
 ID : 109403020
 Course 2023-CE1004
 */
package P2_109403020;
import java.util.Scanner;

public class P2_109403020 {
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