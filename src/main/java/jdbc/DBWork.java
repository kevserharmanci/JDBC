package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBWork {
    //PostgreSql baglantisi methodu
    public Connection connect_to_db(String dbName,String user,String password) {
        Connection con=null;
        try{
           Class.forName("org.postgresql.Driver");
         con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "3541Kevser.");
               System.out.println("Baglanti saglandi");
        }catch(Exception e){
            System.out.println("Baglanti saglanamadi");
            System.out.println(e);
        }
       return con;
    }

    //Yeni tablo olusturma methodu yapalim
    public void createTable(Connection con,String tableName){
      //Statament objesi olustur
        Statement statement;
        try{
            String query ="CREATE TABLE "+tableName+"(empId SERIAL,name varchar(200),email varchar(200),salary INTEGER,PRIMARY KEY(empId))";
            statement=con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table olusturuldu");
        }catch(Exception e){
            System.out.println(e);

        }


    }

}
