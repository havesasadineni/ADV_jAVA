package test;
import java.util.*;
import javax.sql.rowset.*;

public class DBCon13 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;){
try {

//RowSetFactory implementation Object
RowSetFactory rsf = RowSetProvider.newFactory();
System.out.println("=====Choice=====");
System.out.println("\t1.JdbcRowSEt"
+ "\n\t2.CachedRowSet");
System.out.println("Enter the Choice:");
int choice = s.nextInt();
switch(choice) {
case 1:
//JdbcRowSet implementation Object
JdbcRowSet jrs = rsf.createJdbcRowSet();
jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
jrs.setUsername("system");
jrs.setPassword("tiger");
jrs.setCommand("select * from Product54");
jrs.execute();
System.out.println("====JdbcRowSet======");

while(jrs.next()) {
System.out.println(jrs.getString(1)+
"\t"+jrs.getString(2)+
"\t"+jrs.getFloat(3)+
"\t"+jrs.getInt(4));
}
jrs.close();
break;
case 2:
//CachedRowSet implementation Object
CachedRowSet crs = rsf.createCachedRowSet();
crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
crs.setUsername("system");
crs.setPassword("tiger");
crs.setCommand("select * from Employee54");
crs.execute();
System.out.println("=====CachedRowSet=====");
while(crs.next()) {
System.out.println(crs.getString(1)+
"\t"+crs.getString(2)+
"\t"+crs.getString(3)+
"\t"+crs.getFloat(4)+

"\t"+crs.getInt(5));
}
crs.close();
break;
default:
System.out.println("Invalid Choice...");
}//end of switch
}catch(Exception e) {e.printStackTrace();}
}//end of try with resource

}}