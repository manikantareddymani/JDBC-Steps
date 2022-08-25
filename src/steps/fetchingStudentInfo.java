package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class fetchingStudentInfo {

	public static void main(String[] args) {
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Scanner t=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSl=false");
			pst=cn.prepareStatement("Select *from jspiders.student where id=?");
			System.out.println("Enter the id of the student");
			int id=t.nextInt();
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				System.out.println("student id="+rs.getInt("id")+"\n Name="+rs.getString("name")+"\n marks "+rs.getDouble(3)+"\n city "+rs.getString(4));
			}
			else
			{
			System.out.println("student with id="+id+"is not present");	
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
		    try {
		    	if(rs!=null) {
			     rs.close();
			     pst.close();
			     cn.close();
		    	}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
}


