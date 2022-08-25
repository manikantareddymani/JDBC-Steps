package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Quary {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSL=false");
			Statement st=cn.createStatement();
			Scanner in=new Scanner(System.in);
			System.out.println("Enter a Id");
			int id=in.nextInt();
			//String qury="delete from jspiders.project where id="+id;
			//
			String qury1="select * from jspiders.students where id="+id;
			st.execute(qury1);
			//System.out.println("delected");
		System.out.println("id projectname inventorname");
		System.out.println("--------------");
//			while(rs.next())
//			{
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
//			}
			
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}

}
