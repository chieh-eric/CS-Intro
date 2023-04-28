/*
 Assignment 3
 Name : 王廷傑
 ID : 109403020
 Course 2023-CE1002
 */

package A3_109403020;
import java.util.ArrayList;  
import java.util.Scanner;

public class A3_109403020 {
	public static void main(String [] args)
	{
		store store_item = new store();
		Scanner s = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.add goods 2.sell 3.show all item in store 4.show income 5.exit:");
			
			int input = s.nextInt();
			if(input == 5)
			{
				break;
			}

			else if(input == 1 )
			{
				Scanner t = new Scanner(System.in);
				goods good = new goods();
				System.out.println("please input goods info id/name/price/amount:");
				String temp = t.nextLine();
				String [] res = temp.split(" ");
				int price = Integer.parseInt(res[2]);
				int amount = Integer.parseInt(res[3]);
				good.id = res[0];
				good.setName(res[1]);
				good.setPrice(price);
				good.amount = amount;
				store_item.addItem(good);
			}
			else if(input == 2)
			{
				System.out.println("please input goods id and the sell amount:");
				Scanner w = new Scanner(System.in);
				String temp = w.nextLine();
				String [] res = temp.split(" ");
				int amount = Integer.parseInt(res[1]);
				store_item.sell(res[0],amount);
			}
			else if(input == 3)
			{
				store_item.showAll();
			}
			else if(input == 4)
			{
				store_item.showIncome();
			}
			
		}
	}
}

class goods {
	public String id;
	private String name;
	private int price;
	public int amount ;
	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return price;
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
class store {
	private ArrayList<goods> goodList = new ArrayList<>();
	private int money = 0;
	public void addItem(goods item)
	{
		goodList.add(item);
	}
	public void sell(String id , int amount)
	{
		for(goods i:goodList)
		{
			

			if(id.equals(i.id))
			{
				i.amount = i.amount - amount;
				money += amount * i.getPrice();
			}
			if(i.amount==0)
			{
				goodList.remove(goodList.indexOf(i));
			}
		}
	}
	public void showAll()
	{
		for(goods i :goodList)
		{
			System.out.println(i.id+" "+i.getName()+" "+i.getPrice()+" "+i.amount);
		}
	}
	public void showIncome()
	{
		System.out.println(money);
	}
}