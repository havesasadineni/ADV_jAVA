package test;
import java.util.*;
import java.sql.*;
import java.io.*;
public class DBCon15 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				Connection con = DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
						PreparedStatement ps = con.prepareStatement("insert into StreamTab54 values(?,?)");
						System.out.println("Enter the Id:");
						String id = s.nextLine();
						ps.setString(1, id);

						System.out.println("Enter fPath&amp;fName(Source):");
						File f = new File(s.nextLine());//file path in File-Object
						if(f.exists()) {
						FileInputStream fis = new FileInputStream(f);
						ps.setBinaryStream(2, fis, f.length());
						int k = ps.executeUpdate();
						if(k>0) {
						System.out.println("Image Stored to databaseSuccessfully");
						}
						}else {
						System.out.println("Invalid fPath or fName...");
						}
						con.close();
				
				}catch(Exception e) {e.printStackTrace();}
		
		}//end of try with resource
	}

}