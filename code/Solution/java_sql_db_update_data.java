import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class java_sql_db_update_data {
    public static void main(String[] args){
          try{
        	  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\Database\\Lab_18.accdb");//Establishing Connection
             System.out.println("Connected Successfully");
              //Crating PreparedStatement object
              PreparedStatement preparedStatement=connection.prepareStatement("update Practice set Name=? where Phone=?");
              //Setting values for Each Parameter
             preparedStatement.setString(1,"Ahmed");
             preparedStatement.setString(2,"01722633140");
       
              preparedStatement.executeUpdate();
              System.out.println("data updated successfully");
 
          }catch(Exception e){
              System.out.println("Error in connection");
 
          }
 
    }
}