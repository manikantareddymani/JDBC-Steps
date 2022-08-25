package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertingExample {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		System.out.println("Enter Driver Name");
		String d=t.nextLine();
		System.out.println("Enter URL");
		String url=t.nextLine();
		try {
			Class.forName(d);
			System.out.println("Loading and Registering complete");
			Connection cn=DriverManager.getConnection(url);
			System.out.println("connection created");
			java.sql.Statement st=cn.createStatement();
			System.out.println("Stament platform created");
			System.out.println("enter id,project name,Inventor name");
			int id=t.nextInt();
			t.nextLine();
			String pn=t.next();
			String inv=t.next();
			
			String qury="insert into jspiders.project values("+id+",'"+pn+"','"+inv+"')";
		
			st.execute(qury);
			System.out.println("data inserted");
			
			
		

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
			
		}
}