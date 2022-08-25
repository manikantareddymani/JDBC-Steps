package steps;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class FetchingExample {

	public static void main(String[] args) {
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		
	 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSL=false");
			st=cn.createStatement();
			String qury="select * from jspiders.project";
			rs=st.executeQuery(qury);
			System.out.println("id projectname inventorname");
			System.out.println("--------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();//Syso
		}
		finally {
			    try {
			    	if(rs!=null) {
				     rs.close();
				     st.close();
				     cn.close();
			    	}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
