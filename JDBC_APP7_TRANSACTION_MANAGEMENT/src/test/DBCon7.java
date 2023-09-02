package test;
import java.sql.*;
import java.util.*;
public class DBCon7 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;){
   try {
	   
	   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			   System.out.println("Commit-Status:"+con.getAutoCommit());
			   con.setAutoCommit(false);
			   System.out.println("Commit-Status:"+con.getAutoCommit());
			   PreparedStatement ps1 = con.prepareStatement("select * from Bank54 where accno=?");
			   PreparedStatement ps2 = con.prepareStatement("update Bank54 set bal=bal+? where accno=?");
			   Savepoint sp = con.setSavepoint();
			   System.out.println("Enter HomeAccNo:");
			   long hAccNo = s.nextLong();
			   ps1.setLong(1, hAccNo);
			   ResultSet rs1 = ps1.executeQuery();
			   if(rs1.next())
			   {
				   float bl = rs1.getFloat(3);//bl=10000/-
				   System.out.println("Enter benefecieryAccNo:");
				   long bAccNo = s.nextLong();
				   ps1.setLong(1, bAccNo);
				   ResultSet rs2 = ps1.executeQuery();
				   if(rs2.next()) 
				   {
					   System.out.println("Enter the amt to be transferred:");
					   float amt = s.nextFloat();
					   if(amt<=bl) 
					   {
						   ps2.setFloat(1, -amt);
						   ps2.setLong(2, hAccNo);
						   int p = ps2.executeUpdate();//Buffer Updated
						   ps2.setFloat(1, +amt);
						   ps2.setLong(2, bAccNo);
						   int q = ps2.executeUpdate();//Buffer Updated
						   if(p==1 && q==1) 
						   {
							   con.commit();//Update database permanently
							   System.out.println("Transaction Successfull");
						   
						   }
						   else 
						   {
							   System.out.println("Transaction Failed..");
							   con.rollback(sp);
					       }
					   }
					   else 
					   {
					   System.out.println("Insufficient fund...");
				       }
				   }
				   else 
				   {
				   System.out.println("Invalid bAccNo...");
			       }
			   }
			   else 
			   {
			   System.out.println("Invalid HomeAccNo...");
			   }


       }catch(Exception e) {e.printStackTrace();}
}//end of try with resource
}
}