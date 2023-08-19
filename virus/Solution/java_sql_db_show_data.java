import java.sql.*;
public class java_sql_db_show_data {
    public static void main(String[] args){
          try{
        	  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\Database\\Lab_18.accdb");//Establishing Connection
             System.out.println("Connected Successfully");
              //Using SQL SELECT Query
              PreparedStatement preparedStatement=connection.prepareStatement("select * from Practice");
              //Creaing Java ResultSet object
              ResultSet resultSet=preparedStatement.executeQuery();
              System.out.println(resultSet);
              System.out.println("Name     "+"Email  "+"Phone");
              while(resultSet.next()){
                   String name=resultSet.getString("Name");
                   String email=resultSet.getString("Email");
                   String phone=resultSet.getString("Phone");
                   //Printing Results
                   System.out.println(name+" "+email+" "+phone);
              }
 
          }catch(Exception e){
              System.out.println("Error in connection");
 
          }
 
    }
}