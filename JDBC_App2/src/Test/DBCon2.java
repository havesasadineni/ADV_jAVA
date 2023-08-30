package Test;
import java.util.*;
import java.sql.*;

public class DBCon2 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				Connection con = DriverManager.getConnection
			        	("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			        	Statement stm = con.createStatement();
			        	System.out.println("Enter the ProdCode:");
		        	   	String code = s.nextLine();
		        	   	System.out.println("Enter the ProdName:");
		        	   	String name = s.nextLine();
		        	   	System.out.println("Enter the ProdPrice:");
		        	   	float price = s.nextFloat();
		        	   	System.out.println("Enter the ProdQty:");
		        	   	int qty = s.nextInt();
		        	   	
		        	   	int k = stm.executeUpdate("insert into Product54 values('"+code+"','"+name+"',"+price+","+qty+")");
		        	   	
		        	   	if(k>0) {
		        	   		System.out.println("Product details inserted Successfully");
		        	   	}
		        	   	con.close();
		        	   	
		        	   	

				        
			}catch(Exception e) {e.printStackTrace();}
		}//end of try with resource
	}

}
