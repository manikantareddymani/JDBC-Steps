package steps;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesWithBatchFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection cn=null;
		PreparedStatement pst=null;
		Properties p=new Properties();

		Scanner t=new Scanner(System.in);
		try {
			InputStream in=new FileInputStream("C:\Users\\manik\eclipse-workspace\JdbcStep\src\steps\configure.properties)");
			
			
			Class.forName(p.getProperty("dr"));
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Mani@123&&useSSl=false");
			pst=cn.prepareStatement("insert into jspiders.student values(?,?,?,?)");
		
			
			int r=0;
			
			do {
				System.out.println("Enter the id,name, marks and city");
				pst.setInt(1, t.nextInt());
				pst.setString(2, t.next());
				pst.setLong(3, (long) t.nextDouble());
				pst.setNString(4, t.next());
				
			pst.addBatch();
			System.out.println("data inserted");
			System.out.println("press 1 insert onr more record ... any other number to exit");
			r=t.nextInt();
			}while (r==1);	
				
	int [] arr= pst.executeBatch();
			for(int x:arr) {
				System.out.println(x);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
		    try {
		    	if(pst!=null) {
			     
			     pst.close();
			     cn.close();
		    	}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	}

}
