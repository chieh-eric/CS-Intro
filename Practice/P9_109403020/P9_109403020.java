/* Practice 9
 Name : 王廷傑
 ID : 109403020
 Course : 2023-CE1004
 */
package P9_109403020;
import java.util.ArrayList;
import java.util.Scanner;
public class P9_109403020 {
	Scanner s = new Scanner(System.in); 
	public static void main(String[] args) {
		ArrayList<Token> tks = new ArrayList<Token>();
		
		while(true) 
		{ 
			Token t = new Token();
			t.get_token(); 
			if(t.getToken().equals("END_OF_FILE")) 
			{ 
					break; 
			}
			else
			{
				t.get_token_type(); 
				tks.add(t);
			}
			 
		} 
		while(true) 
		{
			Scanner u = new Scanner(System.in);
			int act = u.nextInt(); 
			if(act==0) 
			{
				break; 
			} 
			else if (act==1)
			{
				System.out.println("Total number of tokens: "+tks.size()); 
			} 
			else if (act==2) 
			{ 
				for(Token tmp :tks) 
				{ 
					System.out.println("["+tmp.getToken()+"]"); 
				} 
			} 
			else if (act==3) 
			{ 
				int cas1=0,cas2=0,cas3=0; 
				for(Token tmp :tks)
				{
					if(tmp.getType()=="Identifier") 
					{
						cas1++; 
					} 
					else if (tmp.getType()=="Number") 
					{
					cas2++; 
					}
					else if(tmp.getType()=="Special Symbol") 
					{
					cas3++; 
					}
				}
				System.out.println("Identifier: "+cas1+", Number: "+cas2+", Special Symbol: "+cas3); } 
			else
			{
				System.out.println("Invalid command");
			}

			}
				}
	} 
class Token
{
	private String token; 
	private String type;
	public void get_token() 
	{
		Scanner y = new Scanner(System.in); 
		
			
			this.token = y.nextLine();
		
		
	} public void get_token_type() 
	{
		if (token.matches("[a-zA-Z_][a-zA-Z_0-9]*")) { type = "Identifier"; 
		}
		else if (token.matches("\\d+")) 
		{
			type = "Number"; 
		} 
		else if (token.matches("[+\\-*/><%=|&^\"'.,\\(\\)\\[\\]\\{\\}:;!]+")) 
		{
			type = "Special Symbol"; 
		}
	}
	public String getType() 
	{
		return type;
	}
	public String getToken() 
	{
		return token; 
	}
}