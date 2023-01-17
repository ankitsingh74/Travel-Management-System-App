package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//main class not required for jdbc connection
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//register the Driver class
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "Ankit@2297");//localhost:3306/(if mysql by default running in same port yoy can remove by extra one /,total /// slashes )
            s = c.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
