package maccess;
import test.*;
import java.sql.*;
public class DemoConPool {
public static void main(String[] args) {
try {
ConnectionPool cp = new ConnectionPool
("jdbc:oracle:thin:@localhost:1521:xe",
"system","manager");//Con_Call
System.out.println("*****Pool-Size****");
System.out.println("Pool-Size:"+cp.v.size());
cp.addConnectionsToPool();

System.out.println("*****Pool-Size****");
System.out.println("Pool-Size:"+cp.v.size());
System.out.println("=====User-1=====");
Connection con1 = cp.getConnectionFromPool();
System.out.println("User1-con:"+con1);
System.out.println("Pool-Size:"+cp.v.size());
System.out.println("=====User-2=====");
Connection con2 = cp.getConnectionFromPool();
System.out.println("User2-con:"+con2);
System.out.println("Pool-Size:"+cp.v.size());
System.out.println("=====User-1=====");
cp.returnConnetionToPool(con1);
System.out.println("Pool-Size:"+cp.v.size());
System.out.println("=====User-2=====");
cp.returnConnetionToPool(con2);
System.out.println("Pool-Size:"+cp.v.size());
System.out.println("*****Connection from pool*****");
cp.v.forEach((k)->
{
System.out.println(k);
});
}catch(Exception e) {e.printStackTrace();}

}

}