package steps;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class FirstStepRecommended {
	public static void main(String[] args) {
		
	Scanner t= new Scanner(System.in);
	System.out.println("Enter Driver Name");
	String d=t.next();
try {
	Class.forName(d);
	System.out.println("loading and registering complete");


} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
	}
}
