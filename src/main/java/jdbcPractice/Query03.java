package jdbsPractice;



import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "3541Kevser.");

        PreparedStatement ps=con.prepareStatement("select * from ogrenciler");
        //prepared olması daha dınamik ve statamentte gore daha az hafıza kullanır tekrar tekrar kullanılır ama sıgerı her seferinde yeniden olusur
        ResultSet rs=ps.executeQuery();

        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println("Sutun Sayisi: "+rsmd.getColumnCount());

        System.out.println("1.Sutun ism: "+rsmd.getColumnName(1));
        System.out.println("2.Sutun ism: "+rsmd.getColumnName(2));
        System.out.println("3.Sutun ism: "+rsmd.getColumnName(3));
        System.out.println("4.Sutun ism: "+rsmd.getColumnName(4));

        System.out.println();
        System.out.println("1.sutunun data tipi : "+rsmd.getColumnTypeName(1));
        System.out.println("2.sutunun data tipi : "+rsmd.getColumnTypeName(2));
        System.out.println("3.sutunun data tipi : "+rsmd.getColumnTypeName(3));
        System.out.println("4.sutunun data tipi : "+rsmd.getColumnTypeName(4));

        System.out.println();

        System.out.println("tablonun ismi: "+rsmd.getTableName(1));

    }
}
