package com.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Jdbc_Ex_Employee_Database {
		
		public static void main(String[] args) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root", "rootroot");
				while(true) {
				System.out.println("Main Menu");
				System.out.println("1. Insert data \n2. Get data by phnum	\n3. Update email/phnum \n4. Delete record by empid	\n5. Quit");
				
				Scanner sc = new Scanner(System.in); 
				System.out.println("Enter your Choice: "); 
		        int user_input = Integer.parseInt(sc.nextLine());  
//		        for(:) {
		        if(user_input == 5) 
		        {
		        	System.out.println("Nice meeting you. Bye.");
					break;                                                                                                                                                                                           
		        }
		        else 
		        {
			        switch(user_input) 
			        {
			        	case 1:
				        	PreparedStatement pst = con.prepareStatement("insert into emp(emp_name,ph_num,email) values(?,?,?)");
				        	Scanner scan = new Scanner(System.in);
				        	System.out.println("Please Enter Name: ");
				        	String emp_name = scan.nextLine(); 
				        	pst.setString(1,emp_name);
				        	System.out.println("Please Enter PhNum: ");
				        	int ph_num = Integer.parseInt(scan.nextLine()); 
				        	pst.setInt(2,ph_num);
				        	System.out.println("Please Enter Email: ");
				        	String email = scan.nextLine(); 
				        	pst.setString(3,email);
	//			        	pst.addBatch();
	//			        	pst.executeBatch();
				        	Integer result = pst.executeUpdate();
							if (result>=1) 
							{
								System.out.println("Inserted Successfully");
							} 
							else 
							{
									System.out.println("Not Inserted");
							}
							break;
							
			        	case 2:
			        		Scanner scan2 = new Scanner(System.in);
			        		System.out.println("Please Enter PhNum: ");
				        	String ph_num2 = scan2.nextLine();
				        	PreparedStatement pst2 = con.prepareStatement("select * from emp where ph_num = ?"); 
				        	pst2.setString(1, ph_num2);
	//			        	Statement pst2 = con.createStatement();
				        	ResultSet rs = pst2.executeQuery();
				        	
							if(rs.next()) 
							{
								System.out.println("Id: " + rs.getString(1) + "\t emp_name: " + rs.getString(2) + "\t Desg: " + rs.getString(3) + "\t Salary: " + rs.getDouble(4) + "\t Ph_num: " + rs.getString(5) + "\t Email: " + rs.getString(6));
							} 
							else 
							{ 
								System.out.println("No Data Found");
							}
							break;
							
			        	case 3:
			        		Scanner scan3 = new Scanner(System.in);
			        		for(;;) 
			        		{
			        		System.out.println("Which one you want to update \na.email	\nb.ph_num ");
			        		String choice = scan3.nextLine();
			        		
			        		switch(choice) 
			        		{
			        			case "a":
				        			PreparedStatement pst3a = con.prepareStatement("update emp set email = ? where id = ?");
						        	Scanner scan3a = new Scanner(System.in);
						        	System.out.println("Please Emp_Id for which Email is to be updated: ");
						        	int empid3a = Integer.parseInt(scan3a.nextLine());
						        	System.out.println("Please Enter Updated Email: ");
						        	String up_email = scan3a.nextLine(); 
						        	pst3a.setString(1, up_email);
						        	pst3a.setInt(2,empid3a);
						        	Integer result1 = pst3a.executeUpdate();
									if (result1>=1) 
									{
										System.out.println("Email Updated Successfully");
									} 
									else 
									{
											System.out.println("No Data Found for Emp_Id" + empid3a);
									}
									break;
			        			case "b":
				        			PreparedStatement pst3b = con.prepareStatement("update emp set ph_num = ? where id = ? ");
						        	Scanner scan3b = new Scanner(System.in);
						        	System.out.println("Please Emp_Id for which Phone Number is to be updated: ");
						        	int empid3b = Integer.parseInt(scan3b.nextLine());
						        	System.out.println("Please Enter Updated Phone Number: ");
						        	int up_ph_num = Integer.parseInt(scan3b.nextLine()); 
						        	pst3b.setInt(1, up_ph_num);
						        	pst3b.setInt(2,empid3b);
						        	Integer result2 = pst3b.executeUpdate();
									if (result2>=1) 
									{
										System.out.println("Phone Number Updated Successfully");
									} 
									else
									{
											System.out.println("Phone Number Not Updated");
									}
							    default:
							    	System.out.println("Please choose correct option.");
			        		}
			        	}
			        	
			        	case 4:
							
							Scanner scan4 = new Scanner(System.in);
			        		System.out.println("Please Enter Emp_Id to be deleted: ");
				        	int emp_id = Integer.parseInt(scan4.nextLine());
				        	PreparedStatement pst4 = con.prepareStatement("delete from emp where id = ?"); 
				        	pst4.setInt(1, emp_id);
	//			        	Statement pst4 = con.createStatement();
	//			        	ResultSet rs4 = pst4.executeQuery("delete from emp where id = ?");
				        	
				        	Integer result4 = pst4.executeUpdate();
							if (result4>=1) 
							{
	//						if(rs4.next()) {
				        		System.out.println("Emp_Id " + emp_id + " Successfully deleted");
							} 
							else 
							{
									System.out.println("No record found with Emp_Id: " + emp_id);
							}
							break;
			        		
					default:	
						
						System.out.println("Wrong choice.");
			        } 
		        }
			}
		}
			catch (SQLException | ClassNotFoundException e) 
			{
					// TODO Auto-generated catch block
		    }
	}
}
