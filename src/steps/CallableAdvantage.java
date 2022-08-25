package steps;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableAdvantage {

	public static void main(String[] args) {
		Connection cn=null;
		CallableStatement cst=null;

		Scanner t=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSl=false");
			cst=cn.prepareCall("Call jspiders.inserting(?,?,?,?,?,?)");
			
			System.out.println("Enter id,name,marks,city,course name,trainer");
			int id=t.nextInt();
			String na=t.next();
			Double m=t.nextDouble();
			String c=t.next();
			String cname=t.next();
			String tname=t.next();
			
			cst.setInt(1, id);
			cst.setString(2, na);
			cst.setDouble(3, m);
			cst.setString(4, c);
			cst.setString(5, cname);
			cst.setString(6, tname);
			
			cst.executeUpdate();
	
				System.out.println("Data inserted");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
		    try {
		    	if(cst!=null) {
			     cst.close();
			     cn.close();
		    	}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	}

}
