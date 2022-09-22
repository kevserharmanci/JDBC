package jdbc;


import java.sql.*;

public class ExecuteDeneme2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "3541Kevser.");
        Statement st = con.createStatement();

         //1.example:region id'si 1 olan "country name" degerlerini cagirirn
        String sql1="SELECT country_name FROM countries WHERE region_id=1";

        ResultSet result=st.executeQuery(sql1);
        while(result.next()){
            System.out.println(result.getString(1));
        }
        System.out.println();
        //2.Example:"regoin_id"'in 2'den buyuk oldugu "country_id" ve "country_name" degerlerini cagırın
        String sql2="SELECT country_id,country_name FROM countries WHERE region_id>2";
        ResultSet result1=st.executeQuery(sql2);

        while(result1.next()){
            System.out.println(result1.getString("country_id")+"-->"+result1.getString("country_name"));
        }
        System.out.println();
        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3="SELECT * from companies WHERE number_of_employees=(select min(number_of_employees) from companies)";

        ResultSet result2=st.executeQuery(sql3);
        while(result2.next()){
            System.out.println(result2.getString(1)+"--"+result2.getString(2)+"--"+result2.getString(3));
        }
        con.close();
        st.close();
    }
}
