package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginANDsiginin {
	private static final String password = null;


	public static void main(String[] args) {
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Scanner t=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSl=false");

			pst=cn.prepareStatement("insert into jspiders.registration values(?,?,?,?,? ,?)");
			System.out.println("press 1 to insert one more record...any other number to exit");
	System.out.println("please");

			System.out.println("Enter the id ,name,mobile,email,password and city for registration");
			int id=t.nextInt();
			String name=t.next();
			long mobile=t.nextLong();
			String email=t.next();
			String password=t.next();
			String city=t.next();
			
			pst.setInt(1, id);
			pst.setString(6, city);
			pst.setString(2, name);
			pst.setString(4, email);
			pst.setLong(3, mobile);
			pst.setString(5,password);
			pst.executeUpdate();
			System.out.println("Registration Sucessful");

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
