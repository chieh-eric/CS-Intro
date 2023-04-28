/*
 Practice 3
 Name : 王廷傑
 ID : 109403020
 Course 2023-CE1004
 */
package P3_109403020;
import java.util.Scanner;

public class P3_109403020 {
	public static void main(String [] args)
	{
		goods good = new goods();
		System.out.println("please input the goods info id/name/price:");
		Scanner s = new Scanner(System.in);
		String temp = s.nextLine();
		String [] input = temp.split(" ");
		int price = Integer.parseInt(input[2]);
		good.setId(input[0]);
		good.setName(input[1]);
		good.setPrice(price);
		while(true)
		{
			System.out.println("1.show the current price 2.change the price 3.exit the system:");
			int outcome = s.nextInt();
			if(outcome ==1 )
			{
				System.out.println("the current price is "+good.getPrice());
			}
			else if(outcome == 2)
			{
				System.out.println("please input the new price:");
				int chp = s.nextInt();
				good.changePrice(chp);
			}
			else if (outcome ==3)
			{
				break;
			}
		}
	}
	}
class goods{
	private String id;
	private String name;
	private int price;
	public int getPrice()
	{
		return price;
	}
	public void changePrice(int price)
	{
		this.price = price;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
}