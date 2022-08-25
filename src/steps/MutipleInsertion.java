package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MutipleInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			int r=0;
			do {
			System.out.println("enter id,project name,Inventor name");
			int id=t.nextInt();
			t.nextLine();
			String pn=t.next();
			String inv=t.next();
			
			String qury="insert into jspiders.project values("+id+",'"+pn+"','"+inv+"')";
		
			st.execute(qury);
			System.out.println("data inserted");
			System.out.println("press 1 to insert one more record...any other number to exit");
			r=t.nextInt();
			
		

		} 
			while(r==1);
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

		
	
			
		
	

