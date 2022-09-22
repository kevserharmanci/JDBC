package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2. Adım: Database'e bağlan yani yetki almis oluyoruz
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","3541Kevser.");

        //3. Adım: Statement oluştur.artık query'lerimizi calıstırabiliyoruz ve boylece pjadminde yapmıs olduklarımızı ıntellıj uzerınden yapmıs oluyoruz buna jdbc denir
        Statement st = con.createStatement();

        //4. Adım: Query çalıştır.

        //1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.

        String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";
        boolean result = st.execute(sql1);
        System.out.println(result);//False return yapar, çünkü data çağrılmadı.

      //2.Örnek: Table'a worker_address sütunu ekleyerel alter yapın.

      String sql2= "ALTER TABLE workers ADD worker_address VARCHAR(80)";
       st.execute(sql2);

       //3. Örnek: Drop workers table
      String sql3="DROP TABLE workers";
       st.execute(sql3);


       //5.Adim:Baglanti ve statament kapat
       con.close();
       st.close();


    }

}