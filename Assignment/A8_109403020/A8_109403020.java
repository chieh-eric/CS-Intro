/*
 Assignment 8
 Name : 王廷傑
 ID : 109403020
 Course 2023-CE1002
 */

package A8_109403020;
import java.util.Scanner; 
import java.util.ArrayList;
public class A8_109403020 {
	

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		Scanner s = new Scanner(System.in);
		while(true)
		{	
		System.out.println("----------Menu----------\n"
				+ "1. Create a user\n"
				+ "2. Create a sheet\n"
				+ "3. Check a sheet\n"
				+ "4. Change a value in a sheet\n"
				+ "5. Change a sheet's access right\n"
				+ "6. Collaborate with an other user\n"
				+ "7. Exit\n"
				+ "-------------------------"
				);
		int input=s.nextInt();
		if(input==1)
		{
			Scanner n = new Scanner(System.in);
			String name = n.nextLine();
			User user = new User(name);
			users.add(user);
		}
		else if (input==2)
		{
			Scanner t = new Scanner(System.in);
			String user_name = t.next();
			String sheet_name = t.next();
			for(User i : users)
			{
				if(user_name.equals(i.getName()))
				{
					Form form = new Form(sheet_name);
					i.addForm(form);
					System.out.println("");
					System.out.println("Create a sheet named \""+i.getSheet(sheet_name).getName()+"\" for \""+i.getName()+"\"");
					System.out.println("");
				}
			}
		}
		else if (input==3)
		{
			Scanner u = new Scanner(System.in);
			String user_name = u.next();
			String sheet_name = u.next();
			for(User i : users)
			{
				if(user_name.equals(i.getName())&&i.existSheet(sheet_name))
				{
					Form f = i.getSheet(sheet_name);
					System.out.println("");
					f.display();
					System.out.println("");

				}
			}
			
		}
		else if (input ==4)
		{	        
			Scanner r = new Scanner(System.in);
			String user_name = r.next();
			String sheet_name = r.next();
			for(User i : users)
			{
				if(user_name.equals(i.getName())&&i.existSheet(sheet_name))
				{
					Form f = i.getSheet(sheet_name);
					System.out.println("");
					f.display();
					System.out.println("");

				}
			}
			double result=0;
			int row = r.nextInt();
			int col = r.nextInt();
			String val = r.nextLine();
			String[] array = val.split("\\+|-|\\*|/");
			if(array.length==2)
			{
				double operand1 = Double.parseDouble(array[0]);
		        double operand2 = Double.parseDouble(array[1]);
		        char operator = val.charAt(array[0].length());
		        switch (operator) {
	            case '+':
	                result = operand1 + operand2;
	                break;
	            case '-':
	                result = operand1 - operand2;
	                break;
	            case '*':
	                result = operand1 * operand2;
	                break;
	            case '/':
	                result = operand1 / operand2;
	                break;
		        	}
			}
			else
			{
				result = Double.parseDouble(array[0]);
			}
			

			for(User i : users)
			{
				if(user_name.equals(i.getName())&&i.existSheet(sheet_name))
				{
					Form f = i.getSheet(sheet_name);
					if(f.getStatus().equals("Editable"))
					{
					f.setValue(row,col,result);
					System.out.println("");
					f.display();
					System.out.println("");
					}
					else
					{
						System.out.println("");
						System.out.println("This sheet is not accessible");
						System.out.println("");
						f.display();
						System.out.println("");
					}
				}
			}

			
		}
		else if(input == 5)
		{
			Scanner y = new Scanner(System.in);
			String user_name = y.next();
			String sheet_name = y.next();
			for(User i : users)
			{
				if(user_name.equals(i.getName())&&i.existSheet(sheet_name))
				{
					Form f = i.getSheet(sheet_name);
					f.setStatus();
					System.out.println("");
					System.out.println(i.getName()+" "+f.getName()+" "+f.getStatus());
					System.out.println("");
				}
			}
		}
		else if(input ==6)
		{
			Scanner u = new Scanner(System.in);
			String user_name = u.next();
			String sheet_name = u.next();
			String share_name = u.next();
			for(User i : users)
			{
				if(user_name.equals(i.getName())&&i.existSheet(sheet_name))
				{
					Form f = i.getSheet(sheet_name);
					for(User j : users)
					{
						if(share_name.equals(j.getName()))
						{
							j.addForm(f);
							System.out.println("");
							System.out.println("Share "+i.getName()+"'s "+f.getName()+" with "+j.getName());
							System.out.println("");
						}
					}


				}
			}
		}
		else if(input ==7)
		{
			break;
		}
	}


}
}
class User {
    private String name;
    private ArrayList<Form> forms;
   
    public Form getSheet(String name)
    {
    	for(Form f : forms)
    	{
    		if(name.equals(f.getName()))
    		{
    			return f;
    		}
    	}
    	return null;
    }
    public boolean existSheet(String name)
    {
    	for(Form f : forms)
    	{
    		if(name.equals(f.getName()))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    public void addForm(Form form)
    {
    	forms.add(form);
    }
    public User(String name) {
    	this.forms = new ArrayList<>();
        this.name = name;
        System.out.println("");
        System.out.println("Create a user named \""+name+"\"\n");
    }

    public String getName()
    {
    	return name;
    }
}
class Form{
private double[][] form;
private String name;
private String status;

public Form(String name) {
    this.name = name;
    this.status = "Editable";
    this.form = new double[5][5];
}
public void setName(String name)
{
	this.name = name;
}

public String getName()
{
	return name;
}
public void setValue(int row, int col, double value) {
	
    form[row][col] = value;
}

public void display() {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
        	if(form[i][j]==(int)form[i][j])
        	{
                System.out.print((int)form[i][j] + ", ");

        	}
        	else
        	{
                System.out.printf("%.2f, ",form[i][j]);
        	}
        	
        }
        System.out.println();
    }
}
public String getStatus()
{
	return status;
}
	public void setStatus() {
		if (status.equals("Editable"))
		{
			status = "ReadOnly";
		}
		else if (status.equals("ReadOnly"))
		{
			status = "Editable";
		}
	}
	public String geStatus()
	{
		return status;
	}
}

