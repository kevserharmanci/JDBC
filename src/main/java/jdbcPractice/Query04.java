package jdbsPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                                                    "postgres",
                                                    "3541Kevser.");

        PreparedStatement ps=con.prepareStatement("insert into ogrenciler values(?,?,?,?)");
           /*
           preparedstatament ve statament arasındaki farklar
          1)prepared statament daha dınamıktır
          2)hafızada daha az yer kaplar*/

        ps.setInt(1,200);
        ps.setString(2,"Veli Can");
        ps.setString(3,"12");
        ps.setString(4,"E");

        ps.executeUpdate();//int dondurur yani kac update yaptigini gosterir

        System.out.println("veri girisi yapildi");


        con.close();
        ps.close();
    }
}
