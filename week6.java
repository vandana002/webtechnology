//create a table
import java.sql.*;
public class App {
public static void main(String[] args) throws Exception {
Connection connect = null;
Class.forName("com.mysql.cj.jdbc.Driver");
connect =
DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root",
"Eags@4135");
Statement statement = connect.createStatement();
// creating...
statement.execute("create table Webtoon (Charcater_no varchar(5), Name
varchar(20), Category varchar(5) )");
statement.execute("insert into Webtoon values(01,'Cha Hyejin','3')");
statement.execute("insert into Webtoon values(02,'Chu Haejun','3')");
statement.execute("insert into Webtoon values(03,'Kiyu','3')");
statement.execute("insert into Webtoon values(04,'Lily','3')");
 ResultSet resultSet = statement.executeQuery("select * from
Webtoon");
while(resultSet.next()){
System.out.println("Character no: "+resultSet.getString(1));
System.out.println("Name: "+resultSet.getString(2));
System.out.println("Category: "+resultSet.getString(3));
System.out.println();
}
resultSet.close();
statement.close();
connect.close();
}
}
                                       
//inserting 
import java.sql.*;
public class App {
public static void main(String[] args) throws Exception {
Connection connect = null;
Class.forName(className:"com.mysql.cj.jdbc.Driver");
connect =
DriverManager.getConnection(url:"jdbc:mysql://localhost:3306/world",user: "root",
password:"Eags@4135");
Statement statement = connect.createStatement();
// creating...
statement.execute("create table Webtoon (Charcater_no varchar(5), Name
varchar(20), Category varchar(5) )");
statement.execute(sql:"insert into Webtoon values(01,'Cha Hyejin','3')");
statement.execute(sql:"insert into Webtoon values(02,'Chu Haejun','3')");
statement.execute(sql:"insert into Webtoon values(03,'Kiyu','3')");
statement.execute(sql:"insert into Webtoon values(04,'Lily','3')");
  //insert
statement.execute(sql:"insert into Webtoon values(05,'vandana','3')");
 ResultSet resultSet = statement.executeQuery(sql:"select * from
Webtoon");
while(resultSet.next()){
System.out.println("Character no: "+resultSet.getString(cloumnIndex:1));
System.out.println("Name: "+resultSet.getString(cloumnIndex:2));
System.out.println("Category: "+resultSet.getString(cloumnIndex:3));
System.out.println();
}
resultSet.close();
statement.close();
connect.close();
}
}
