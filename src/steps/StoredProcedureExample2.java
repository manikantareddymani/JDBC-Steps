package steps;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StoredProcedureExample2 {

	public static void main(String[] args) {
	       Scanner t=new Scanner(System.in);
	       
			Connection cn=null;
			CallableStatement cst=null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSl=false");
				cst=cn.prepareCall("Call jspiders.inserting (?,?,?,?)");// calling stored procedure
			    System.out.println("Enter id ,name ,marks and city");
			    cst.setInt(1, t.nextInt());
			    cst.setString(2, t.next());
			    cst.setDouble(3, t.nextDouble());
			    cst.setString(4, t.next());
			    
			      
			    cst.executeUpdate();
			    

				
					System.out.println("data inserted");	
		
					

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
