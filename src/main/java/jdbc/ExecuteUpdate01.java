package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "3541Kevser.");
        Statement st=con.createStatement();

         //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan
        // number_of_employees değerlerini 16000 olarak UPDATE edin.
        String sql1="   UPDATE companies\n" +
                "   SET  number_of_employees=16000\n" +
                "   where  number_of_employees<(select avg(number_of_employees) from companies)";
     int updateSatirSayisi=st.executeUpdate(sql1); //Update edilen satir(row) sayisini return eder
        System.out.println("updateSutunSayisi = " + updateSatirSayisi);

        String sql2="SELECT * FROM companies";
        ResultSet result1=st.executeQuery(sql2);

        while (result1.next()){
            System.out.println(result1.getInt(1)+"-->"+result1.getString(2)+"-->"+result1.getInt(3));
        }
        con.close();
        st.close();
        result1.close();
    }
}
