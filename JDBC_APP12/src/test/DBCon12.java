package test;
import java.util.*;
import java.sql.*;
public class DBCon12 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;){
try {
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
PreparedStatement ps = con.prepareStatement
("Select ename,ebsal,etotsal from employee54 where eid=?");

try(ps;con;){
System.out.println("Enter the EmpID:");
ps.setString(1, s.nextLine());
ResultSet rs = ps.executeQuery();
if(rs.next()) {
System.out.println(rs.getString(1)+
"\t"+rs.getInt(2)+
"\t"+rs.getFloat(3));
}else {
System.out.println("Invalid empId...");
}
}//end of try with resource
}catch(Exception e) {
System.out.println(e.getMessage());
}
}//end of try with resource
}
}