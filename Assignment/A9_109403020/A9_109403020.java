/* Assignment 9
 Name : 王廷傑
 ID : 109403020
 Course : 2023-CE1002
 */
package A9_109403020;
import java.util.ArrayList;
import java.util.Scanner;
public class A9_109403020 {
	public static void main(String[] args) {
		ArrayList<Token> tks = new ArrayList<Token>();
		Scanner s = new Scanner(System.in); 
		while(s.hasNext()) 
		{ 
			String input = s.nextLine();
			if(input.equals("END_OF_FILE"))
			{
				break;
			}
			char [] charArray= input.toCharArray();	
			int start = FindFirstIndex(input);
			for(int i = start ; i < charArray.length;i++)
			{
				if(Character.toString(charArray[i]).matches("\\W"))
				{
					if(!Character.isWhitespace(charArray[i]))
					{
						String sub = input.substring(start,i);
						Token t = new Token();
						t.get_token(sub);
						t.get_token_type();
						if(sub!="")
						{
							tks.add(t);
						}
						if((charArray[i]=='>'&&charArray[i+1]=='=')||(charArray[i]=='+'&&charArray[i+1]=='+')||(charArray[i]=='-'&&charArray[i+1]=='-')||(charArray[i]=='+'&&charArray[i+1]=='=')||(charArray[i]=='<'&&charArray[i+1]=='=')||(charArray[i]=='='&&charArray[i+1]=='=')||(charArray[i]=='!'&&charArray[i+1]=='=')||(charArray[i]=='&'&&charArray[i+1]=='&')||(charArray[i]=='|'&&charArray[i+1]=='|'))
						{
							String op = input.substring(i,i+2);
							Token o = new Token();
							o.get_token(op);
							o.get_token_type();
							tks.add(o);
							start = i+2;
							i = i+1;
						}
						else
						{
							String op = input.substring(i,i+1);
							Token o = new Token();
							o.get_token(op);
							o.get_token_type();
							tks.add(o);
							start = i+1;
						}

						
					}
					else //space
					{
						String sub = input.substring(start,i);
						Token t = new Token();
						t.get_token(sub);
						t.get_token_type();
						if(sub!="")
						{
							tks.add(t);
						}
						start = i+1;
					}
					
				}
				else if(i<charArray.length-1&&Character.isDigit(charArray[i])&&charArray[i+1]=='_')
				{
						
						String sub = input.substring(start,i+1);
						Token t = new Token();
						t.get_token(sub);
						t.get_token_type();
						if(sub!="")
						{
							tks.add(t);
						}
						start = i+1;
						
				}
				else if(i==charArray.length-1)
				{
					String sub = input.substring(start,i+1);
					Token m = new Token();
					m.get_token(sub);
					m.get_token_type();
					tks.add(m);
				}
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
				System.out.println("Invalid command.");
			}

			}
				}
	static int FindFirstIndex(String s)
	{
		char [] tmp= s.toCharArray();
		for(int i = 0 ; i <s.length();i++)
		{
			if(!Character.isWhitespace(tmp[i]))
			{
				return i;
			}

		}
		return 0;
	}
	
	} 
class Token
{
	private String token; 
	private String type;
	public void get_token(String st) 
	{				
			this.token = st;
		
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