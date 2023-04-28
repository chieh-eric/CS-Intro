/*
 Assignment 1
 Name : 王廷傑
 Student Number : 109403020
 Course 2023-CE1002
 */
package A1_109403020;
import java.util.Scanner;
public class A1_109403020 {
	public static void main(String [] args)
	{	
	double h,w,bmi;
	Scanner s = new Scanner(System.in);
	h = s.nextInt();
	w = s.nextInt();
	bmi = w/h/h*10000;
	System.out.println(bmi);
	
	if (18.5<=bmi&&bmi<24)
	{
		System.out.println("正常");
	}
	else if (24<=bmi && bmi<27)
	{
		System.out.println("過重");
	}
	else if(27<=bmi && bmi<30)
	{
		System.out.println("輕度肥胖");
	}
	else if (30<=bmi && bmi<35)
	{
		System.out.println("中度肥胖");
	}
	else if (bmi>=35)
	{
		System.out.println("重度肥胖");
	}
	}
}