package test;
import java.util.*;
import java.sql.*;
public class DBCon10 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;){
	try {
		Connection con =DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		CallableStatement cs = con.prepareCall
		("{call CustRetrieve54(?,?,?,?,?,?,?)}");
		System.out.println("Enter the CustId:");
		int cId = s.nextInt();
		cs.setInt(1, cId);
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.registerOutParameter(4, Types.VARCHAR);
		cs.registerOutParameter(5, Types.INTEGER);
		cs.registerOutParameter(6, Types.VARCHAR);
		cs.registerOutParameter(7, Types.BIGINT);
		cs.execute();
		System.out.println("*****CustDetails****");
		System.out.println("CustId:"+cId);
		System.out.println("CustName:"+cs.getString(2));
		System.out.println("CustCity:"+cs.getString(3));
		System.out.println("CustState:"+cs.getString(4));
		System.out.println("PinCode:"+cs.getInt(5));
		System.out.println("MailId:"+cs.getString(6));
		System.out.println("PhoneNo:"+cs.getLong(7));
		}
	catch(Exception e) 
	    {
		System.out.println(e.toString());

		}

}//end of try-with-resource
}
}