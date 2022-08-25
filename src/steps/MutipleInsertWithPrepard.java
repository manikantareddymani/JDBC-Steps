package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MutipleInsertWithPrepard {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSl=false");
			PreparedStatement st=cn.prepareStatement("insert into jspiders.project values(?,?,?)");//compilation
			int r=0;
			do {
			System.out.println("enter id,project name,Inventor name");
			int id=t.nextInt();
			String pn=t.next();
			String inv=t.next();
			st.setInt(1, id);
			st.setString(2, pn);
			st.setString(r, inv);
		
			st.executeUpdate();
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
