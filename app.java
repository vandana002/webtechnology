import java.sql.*;
import java.util.Scanner;

public class App {
    static String tableName;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        MyDriver driver = new MyDriver();
        driver.connection();
        System.out.println("\nConnection Established.");
        while(true){
            System.out.println("\n1. Create Table \\ Change Table .\n2. Show Table Details.\n3. Insert."+
                                "\n4. Delete.\n5. Update\n6. Exit.\nEnter your choice : ");
            switch(Integer.valueOf(sc.nextLine().trim())){
                case 1:{
                    System.out.println("Enter the table Name : ");
                    tableName = sc.nextLine().trim();
                    driver.createTable(tableName);
                }break;
                case 2: {
                    System.out.println("Enter the table name : ");
                    driver.selectAll(sc.nextLine().trim());
                };break;
                case 3: {
                    System.out.println("Enter your roll No : ");
                    int rollNo = Integer.valueOf(sc.nextLine().trim());
                    System.out.println("Enter your name : ");
                    String name = sc.nextLine().trim();
                    System.out.println("Enter your branch : ");
                    String branch = sc.nextLine().trim();
                    Student s = new Student(rollNo,name,branch);
                    driver.insert(tableName,s);
                }break;
                case 4:{
                    System.out.println("Enter your roll No : ");
                    int rollNo = Integer.valueOf(sc.nextLine().trim());
                    driver.delete(tableName,rollNo);
                }break;
                case 5 :{
                    System.out.print("Enter the rollNo to update name : ");
                    int r = Integer.valueOf(sc.nextLine().trim());
                    System.out.print("Enter the name : ");
                    String name = sc.nextLine().trim();
                    driver.update(tableName, r, name);                    
                };break;
                default:{System.exit(0);};
            }
        }
    }
}

class MyDriver{
    final String url = "jdbc:mysql://localhost:3306/javalab";
    final String userName = "root";
    final String password = "yourpassword";
    Connection con;

    public void connection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, userName, password);
    }

    public void createTable(String tableName) throws Exception {
        String createTable = "create table if not exists `"
                                +tableName+
                                "`( `id` numeric unique not null, `name` varchar(20) not null,`branch` varchar(3) not null);";
        Statement st = con.createStatement();
        st.executeUpdate(createTable);
    }

    public void selectAll(String tableName) throws Exception{
        String select = "select * from `"+tableName+"`";
        Statement st = con.createStatement();
        try{
            ResultSet rs = st.executeQuery(select);
            System.out.println("\n*******************************\n");
            while(rs.next())
                System.out.println(rs.getInt(1)+"   :   "+rs.getString(2)+"    :    "+rs.getString(3));
            System.out.println("\n*******************************\n");
        }catch(Exception ex){
            System.out.println("\n"+ex.getMessage()+"\n");
        }
    }

    public void insert(String tableName,Student s) throws Exception {
        String insert = "insert into `"+tableName+"` values(?,?,?)";
        PreparedStatement pst = con.prepareStatement(insert);
        pst.setInt(1, s.rollNo);
        pst.setString(2, s.name);
        pst.setString(3, s.branch);
        try{
            pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void delete(String tableName,int rollNo) throws Exception{
        String delete = "delete from `"+tableName+"` where id = "+rollNo;
        Statement st = con.createStatement();
        try{
            st.executeUpdate(delete);
        }catch(Exception ex){
            System.out.print(ex.getLocalizedMessage());
        }
    }

    public void update(String tableName,int rollNo,String name) throws Exception{
        String update = "update "+tableName+" set name = \""+name+"\" where id = "+rollNo;
        Statement st = con.createStatement();
        st.executeUpdate(update);
    }
}

class Student{
    int rollNo;
    String name;
    String branch;
    Student(int rollNo,String name,String branch){
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
    }
}
