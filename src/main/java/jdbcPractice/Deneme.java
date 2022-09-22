package jdbsPractice;

import java.sql.*;

public class Deneme {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "techproed",
                "3541Kevser.");
        //SORU:Ogrenciler tablosundaki erkek ogrencileri listeleyiniz
        Statement st=con.createStatement();
        ResultSet rs1=st.executeQuery("select * from ogrenciler where cinsiyet='E'");
       while(rs1.next()){
       System.out.println(rs1.getInt(1)+"-->"+rs1.getString(2)+"-->"+
                   rs1.getString(3)+"-->"+rs1.getString(4));
       }

        System.out.println();
       ResultSetMetaData rsmd=rs1.getMetaData();
        System.out.println(rsmd.getColumnName(1));
        System.out.println(rsmd.getColumnName(2));
        System.out.println(rsmd.getColumnName(3));
        System.out.println(rsmd.getColumnName(4));
        System.out.println();
        System.out.println(rsmd.getTableName(1));
        System.out.println();
        System.out.println(rsmd.getColumnCount());
        System.out.println(rsmd.getColumnTypeName(1));
        System.out.println(rsmd.getColumnTypeName(2));
        System.out.println(rsmd.getColumnTypeName(3));
        System.out.println(rsmd.getColumnTypeName(4));
        System.out.println();
       


    }
}
