import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class java_sql_db_update_data {
    public static void main(String[] args){
          try{
        	  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\Java program\\JavaTest\\src\\database\\ICE_PUST.accdb");//Establishing Connection
             System.out.println("Connected Successfully");
              //Crating PreparedStatement object
              PreparedStatement preparedStatement=connection.prepareStatement("update Student set Name=?, Email=? where Phone=?");
              //Setting values for Each Parameter
             preparedStatement.setString(1,"sonia");
             preparedStatement.setString(2,"sonia@gmail.com");
             preparedStatement.setString(3,"01521539767");
       
              preparedStatement.executeUpdate();
              System.out.println("data updated successfully");
 
          }catch(Exception e){
              System.out.println("Error in connection");
 
          }
 
    }
}