package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteDeneme {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "3541Kevser.");
        Statement st=con.createStatement();
        //1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
      String sql1="CREATE TABLE workers (worker_id varchar(50),worker_name varchar(50), worker_salary INT)";
      st.execute(sql1);


        //2.Örnek: Table'a worker_address sütunu ekleyerel alter yapın.
        String sql2="ALTER TABLE workers ADD workers_adrees varchar(100)";
       st.execute(sql2);

        //3. Örnek: Drop workers table
        String sql3="DROP TABLE workers";
        st.execute(sql3);

        con.close();
        st.close();


    }
}
