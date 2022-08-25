package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class loginValdation {

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
	
			pst=cn.prepareStatement("select * from jspiders.registration where email=?");
			System.out.println("press 1 to insert one more  to logini");

			System.out.println("Enter the id ,name,mobile,email,password and city for registration");
			int id=t.nextInt();
			String name=t.next();
			long mobile=t.nextLong();
			String email=t.next();
			String password=t.next();
			String city=t.next();
		
			
			System.out.println("Enter the email");
			String email1=t.next();
			
			
			System.out.println("Enter password");
			String password1=t.next();
			pst.setString(1, email1);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				String dbpass=rs.getString("password");
				if(dbpass.equals(password1)) {
					System.out.println("Welecome");
					
				}
				else {
					System.out.println("please check your password");
				}
				
			}
			else {
				System.out.println("please do singup to login");
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
