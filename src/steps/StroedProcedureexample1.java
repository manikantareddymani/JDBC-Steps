package steps;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StroedProcedureexample1 {

	public static void main(String[] args) {
		Connection cn=null;
		CallableStatement cst=null;
		ResultSet rs=null;
		Scanner t=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSl=false");
			cst=cn.prepareCall("Cal jspiders.all");
			
			while(rs.next()) {
				System.out.println();
			}
					
	
				

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
		    try {
		    	if(rs!=null) {
			     rs.close();
			     cst.close();
			     cn.close();
		    	}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	}

}
