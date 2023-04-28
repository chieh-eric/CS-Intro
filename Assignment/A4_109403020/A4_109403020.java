/*
 Assignment 4
 Name : 王廷傑
 ID : 109403020
 Course 2023-CE1002
 */
package A4_109403020;
import java.util.ArrayList;  
import java.util.Scanner;

public class A4_109403020 {
	public static void main(String [] args)
	{
		Department CSIE = new Department();
		Department EE = new Department();
		Department MATH = new Department();

		Institute EECS = new Institute();
		Institute SCI = new Institute();

		Scanner in = new Scanner(System.in);
		Scanner key = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.add student 2.show the number of students in a department 3.show all the students in a department 4.show the number of students in an institute 5.exit:");
			int input = in.nextInt();
			if(input == 1)
			{
				System.out.println("Please input the student info name/id/department:");
				String name = key.next();
				int id = key.nextInt();
				String dep = key.next();
				Student std = new Student(name,id,dep);
				if(dep.equals("CSIE"))
				{
					EECS.addDepart(CSIE);
					CSIE.addStudent(std);
				}
				else if (dep.equals("EE"))
				{
					EECS.addDepart(EE);
					EE.addStudent(std);
				}
				else
				{
					SCI.addDepart(MATH);
					MATH.addStudent(std);
				}
			}
			else if (input == 2)
			{
				System.out.println("Please input the department:");
				String dept = key.next();
				if(dept.equals("CSIE"))
				{
					System.out.println(CSIE.getTotalStudentsInDep());
				}
				else if (dept.equals("EE"))
				{
					System.out.println(EE.getTotalStudentsInDep());
				}
				else
				{
					System.out.println(MATH.getTotalStudentsInDep());
				}
			}
			else if (input == 3 )
			{
				System.out.println("Please input the department:");
				String dept = key.next();
				if(dept.equals("CSIE"))
				{
					CSIE.showDepStudents();
				}
				else if (dept.equals("EE"))
				{
					EE.showDepStudents();		
				}
				else
				{
					MATH.showDepStudents();
				}
			}
			else if(input == 4)
			{
				System.out.println("Please input the institute");
				String ins = key.next();
				if(ins.equals("EECS"))
				{
					System.out.println(EECS.getTotalStudentsInInstitute());
				}
				else
				{
					System.out.println(SCI.getTotalStudentsInInstitute());
				}		
			}
			else
			{
				break;
			}
			
		}
	}
	}
class Student
{
	
	private String name;
	public int id;
	private String dept;
	Student(String name , int id,String dept)
	{
		this.name = name;
		this.id = id;
		this.dept = dept;
	}
	public String getName()
	{
		return name;
	}
	
}
class Department
{
	private ArrayList<Student> students = new ArrayList<>();
	private String name;
	public ArrayList<Student> getStudents()
	{
		 return students;
	}
	public int getTotalStudentsInDep()
	{
		return students.size();
	}
	public void showDepStudents()
	{
		for (Student i : students)
		{
			System.out.println(i.getName());
		}
	}
	public void addStudent(Student std)
	{
		students.add(std);
	}
}
class Institute 
{
	private ArrayList<Department> departments  = new ArrayList<>();
	private String name;
	public int getTotalStudentsInInstitute() {
		return departments.size();
	}
	public void addDepart(Department dep)
	{
		departments.add(dep);
	}
}
