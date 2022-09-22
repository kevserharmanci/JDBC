package jdbc;

import java.sql.*;

public class ExecuteQueryDeneme3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "3541Kevser.");
        Statement st=con.createStatement();


        //1.Ornek:companies tablosundan en yüksek ikinci number_of_employees değeri olan
        // company ve number_of_employees değerlerini çağırın.
        String sql1="  SELECT company,number_of_employees\n" +
                "\t   from companies\n" +
                "\t   order by number_of_employees desc\n" +
                "\t   limit 1 offset 1";
        ResultSet result1=st.executeQuery(sql1);

        while(result1.next()){
            System.out.println(result1.getString(1)+"-->"+result1.getInt(2));
        }
        con.close();
        st.close();
        result1.close();
    }
}
