package MyPackage;
import java.rmi.UnexpectedException;
import java.sql.*;


public class JDBC_Commands {
    public void createDataBase() {

        try {
            String url = "jdbc:mysql://localhost:3306";
            String userName = "root";
            String password = "1996";

            Connection conn = DriverManager.getConnection(url, userName,password);
            Statement stm = conn.createStatement();
            System.out.println("Connected");
            String query = "Create database db";
            Boolean bl = stm.execute(query);
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void createTable() {

            try {
                String url = "jdbc:mysql://localhost:3306/JDBC";
                String userName = "root";
                String password = "1996";

                Connection conn = DriverManager.getConnection(url, userName,password);
                Statement stm = conn.createStatement();
                System.out.println("Connected");
                String query = "Create table student(Roll_No int, Name varchar(200), EMail varchar(200), Marks int )";
                Boolean bl = stm.execute(query);
                if (bl == false){
                    System.out.println("Table Created Successfully");
                }
                else {
                    System.out.println("Table Failed");
                }
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }

    public void createData(){

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "JDBC";
            String userName = "root";
            String password = "1996";

            Connection conn = DriverManager.getConnection(url+db, userName,password);
            Statement stm = conn.createStatement();
            String query = "insert into student (Roll_No, Name, EMail, Marks) values (?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, 2);
            pstm.setString(2, "Varun");
            pstm.setString(3, "varun@gmail.com");
            pstm.setInt(4, 98);


            boolean bl = pstm.execute();

            if (bl == false){
                System.out.println("Data Inserted Successfully");
            }

            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void readData() {

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "JDBC";
            String userName = "root";
            String password = "1996";

            Connection conn = DriverManager.getConnection(url+db, userName,password);
            Statement stm = conn.createStatement();
            String query = "select * from student ";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                System.out.println("Roll_No : "+ rs.getInt(1));
                System.out.println("Name : "+ rs.getString(2));
                System.out.println("EMail : "+ rs.getString(3));
                System.out.println("Marks : "+ rs.getInt(4));
                System.out.println("Data Inserted Successfully");
            }
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateData() {

        try {
            String url = "jdbc:mysql://localhost:3306/JDBC";
            String userName = "root";
            String password = "1996";

            Connection conn = DriverManager.getConnection(url, userName,password);
            System.out.println("Connected");
            Statement stm = conn.createStatement();
            String query = "Update student set Name = ? where Roll_No = ?;";
            PreparedStatement pstm = conn.prepareStatement(query);

            pstm.setString(1, "Varun_Dhawan");
            pstm.setInt(2,2);

            pstm.executeUpdate(query);
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void deleteData() {

        try {
            String url = "jdbc:mysql://localhost:3306/JDBC";
            String userName = "root";
            String password = "1996";

            Connection conn = DriverManager.getConnection(url, userName,password);
            System.out.println("Connected");
            Statement stm = conn.createStatement();
            String query = "delete from student where Roll_No = 2;";


            stm.executeUpdate(query);
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

