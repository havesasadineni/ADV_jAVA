package test;
import java.sql.*;
import java.util.*;
public class DBCon6 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;){
try {

Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement ps = con.prepareStatement
("insert into Employee54 values(?,?,?,?,?)");
System.out.println("Enter the number of employees to be added:");
int n = Integer.parseInt(s.nextLine());
System.out.println("Enter "+n+" employee details...");
for(int i=1;i<=n;i++) {
System.out.println("====Employee-"+i+"====");
System.out.println("Enter the empId:");
String eId = s.nextLine();
System.out.println("Enter the empName:");
String eName = s.nextLine();
System.out.println("Enter the empDesg:");
String eDesg = s.nextLine();
System.out.println("Enter the empBSal:");
int bSal = Integer.parseInt(s.nextLine());
float totSal = bSal+(0.93F*bSal)+(0.63F*bSal);

ps.setString(1, eId);
ps.setString(2, eName);
ps.setString(3, eDesg);

ps.setInt(4, bSal);
ps.setFloat(5, totSal);

ps.addBatch();
System.out.println("Insert query with values added to batch...");
}//end of loop
int k[] = ps.executeBatch();
for(int i=0;i<k.length;i++) {
System.out.println("Executed Successfully...");
}
}catch(Exception e) {e.printStackTrace();}
}//end of try with resource
}
}