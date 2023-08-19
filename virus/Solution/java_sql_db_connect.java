import java.sql.*; 
public class java_sql_db_connect {
    public static void main(String[] args){
          try{
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\Database\\Lab_18.accdb");//Establishing Connection
             System.out.println("Connected Successfully");
 
          }catch(Exception e){
              System.out.println("Error in connection"+e);
 
          }
 
    }
}