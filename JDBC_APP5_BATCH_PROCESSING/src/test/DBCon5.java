package test;
import java.sql.*;
import java.util.*;
public class DBCon5 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);

try(s;){
try {
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement stm = con.createStatement();
System.out.println("=====EmployeeDetails======");
System.out.println("Enter the empId:");
String eId = s.nextLine();
System.out.println("Enter the empName:");
String eName = s.nextLine();
System.out.println("Enter the empDesg:");
String eDesg = s.nextLine();
System.out.println("Enter the empBSal:");
int bSal = Integer.parseInt(s.nextLine());
float totSal = bSal+(0.93F*bSal)+(0.63F*bSal);

stm.addBatch("insert into Employee54 values('"+eId+"','"+eName+"','"+eDesg+"',"+bSal+","+totSal+")");
System.out.println("Insert query added to batch...");
System.out.println("----UpdateProductByCode----");
System.out.println("Enter the ProdCode:");
String pCode = s.nextLine();

System.out.println("Enter the Product new price:");
float nPrice = Float.parseFloat(s.nextLine());
stm.addBatch("update Product54 set price="+nPrice+" where code='"+pCode+"'");
System.out.println("Update query added to batch...");
int k[] = stm.executeBatch();
for(int i=0;i<k.length;i++) {
System.out.println("Executed Successfully...");
}
}catch(Exception e) {e.printStackTrace();}
}//end of try with resource
}
}