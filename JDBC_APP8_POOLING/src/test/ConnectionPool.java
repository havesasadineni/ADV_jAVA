
package test;
import java.util.*;
import java.sql.*;
public class ConnectionPool {
public String url,uName,pWord;
public Vector<Connection> v = new Vector<Connection>();
//Vector Object will unlimited Connection-Objects
public ConnectionPool(String url,String uName,String pWord) {
this.url=url;

this.uName=uName;
this.pWord=pWord;
}
//Method adding DBConnections to Pool
public void addConnectionsToPool() {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
while(v.size()<5) {
System.out.println("Pool is not full....");
Connection con = DriverManager.getConnection

(url,uName,pWord);

v.addElement(con);//Adding Connection to Pool
System.out.println(con);
}//end of loop
if(v.size()==5) {
System.out.println("Pool is full...");
}
}catch(Exception e) {e.printStackTrace();}
}//end of method
public Connection getConnectionFromPool() {
Connection con = v.elementAt(0);
v.removeElementAt(0);

return con;
}//end of method
public void returnConnetionToPool(Connection con) {
v.addElement(con);
System.out.println("Connection added back to pool..");
}

}