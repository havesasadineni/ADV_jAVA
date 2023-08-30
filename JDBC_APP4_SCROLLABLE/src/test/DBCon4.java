package test;
import java.sql.*;
public class DBCon4 {
public static void main(String[] args) {
try {
	Connection con = DriverManager.getConnection
        	("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
System.out.println("****Statement*****");
ResultSet rs1 = stm.executeQuery("select * from Employee54");
rs1.afterLast();//cursor moved to after the last row
while(rs1.previous()) {
System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getInt(4)+"\t"+rs1.getFloat(5));
}
PreparedStatement ps = con.prepareStatement("select * from Product54",1004,1007);
System.out.println("****PreparedStatement****");
ResultSet rs2 = ps.executeQuery();

System.out.println("----absolute(5)-----");
rs2.absolute(5);
System.out.println(rs2.getString(1)+
"\t"+rs2.getString(2)+
"\t"+rs2.getFloat(3)+
"\t"+rs2.getInt(4));
System.out.println("----relative(+2)------");
rs2.relative(+2);
System.out.println(rs2.getString(1)+
"\t"+rs2.getString(2)+
"\t"+rs2.getFloat(3)+
"\t"+rs2.getInt(4));
System.out.println("----first()----");
rs2.first();
System.out.println(rs2.getString(1)+
"\t"+rs2.getString(2)+
"\t"+rs2.getFloat(3)+
"\t"+rs2.getInt(4));
System.out.println("----last()-----");
rs2.last();
System.out.println(rs2.getString(1)+
"\t"+rs2.getString(2)+
"\t"+rs2.getFloat(3)+
"\t"+rs2.getInt(4));
}catch(Exception e) {e.printStackTrace();}
}
}