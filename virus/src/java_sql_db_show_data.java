import java.sql.*;
public class java_sql_db_show_data {
    public static void main(String[] args){
          try{
        	  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\Java program\\JavaTest\\src\\database\\ICE_PUST.accdb");//Establishing Connection
             System.out.println("Connected Successfully");
              //Using SQL SELECT Query
              PreparedStatement preparedStatement=connection.prepareStatement("select * from Student");
              //Creaing Java ResultSet object
              ResultSet resultSet=preparedStatement.executeQuery();             
              System.out.println("Name\t"+"Email\t"+"Phone");
              while(resultSet.next()){
                   String name=resultSet.getString("Name");
                   String email=resultSet.getString("Email");
                   String phone=resultSet.getString("Phone");
                   //Printing Results
                   System.out.println(name+"\t"+email+"\t"+phone);
              }
 
          }catch(Exception e){
              System.out.println("Error in connection");
 
          }
 
    }
}