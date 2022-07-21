import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {
    // db parameters
    static final String url       = "jdbc:mysql://localhost:3306/newdb";
    static final String user      = "developer";
    static final String password  = "ciao";

    public static void main(String[] args) throws SQLException {
        try(Connection con = DriverManager.getConnection(url,user,password);
            Statement statement = con.createStatement();
        ){

            String ordine = "create table if not exists Students" +
                    "(Id int not null auto_increment, " +
                    "first_name varchar(200), " +
                    "last_name varchar(200), " +
                   // "country varchar (30)," +
                    "PRIMARY KEY (Id))";
            statement.execute(ordine);
            ResultSet rs = statement.executeQuery("Select * from italian_students");
            List<String> italianStudents = new ArrayList<>();

            while(rs.next()){
                System.out.println(rs.getString("first_name"));
                System.out.println(rs.getString("last_name"));
                italianStudents.add(rs.getString("last_name"));
            }

            System.out.println(italianStudents);

            rs = statement.executeQuery("Select * from german_students");
            List<String> germanStudents = new ArrayList<>();

            while(rs.next()){
                System.out.println(rs.getString("first_name"));
                System.out.println(rs.getString("last_name"));
                germanStudents.add(rs.getString("last_name"));
            }

            System.out.println(germanStudents);

        }catch (SQLException e){
            e.printStackTrace();
        }


    }


}


//execute a select using the italian_students /  german_students and put the result in an ArrayList of Student objects called italianStudents /GermanStudents

// List<Students> italian_students = new ArrayList<>();
//while (resultSet.next()){
//italian_students.add(newStudents(Students.getName(resultSet.getString();
//System.out.println(Array.toString(italian_students.toArray()));
//for(i=0, i < italian_students.size(), i++){
//System.out.println("Name: " + italian_students.get(i).getName() + " Surname:  " +  italian_students.get(i).getSurname())
//}
