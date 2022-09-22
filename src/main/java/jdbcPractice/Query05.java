package jdbsPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "3541Kevser.");
        Statement st=con.createStatement();
        /*
        Soru= ogrenciler tablosuna yeni bir kayit ekleyin(300,'Sene Can',12,'K')
   //      */
   //
   //    int s1=st.executeUpdate("insert into ogrenciler values(305,'Sene Can',12,'K')");
//
   //     System.out.println(s1+" satir database'e eklendi.");
//
//
   //     /*
   //     Soru=ogrencıler tablosuna birden fazla veri ekleyin
   //     (400,'Sene Can',12,'K')
   //     (401,'Sene Can',12,'K')
   //     (402,'Sene Can',12,'K')
   //      */
   //     String [] veri={"insert into ogrenciler values(400,'Sene Can',12,'K')",
   //             "insert into ogrenciler values(401,'Sene Can',12,'K')",
   //            "insert into ogrenciler values(402,'Sene Can',12,'K')"};
   //     int count=0;
   //     for (String each:veri){
   //         st.executeUpdate(each);//count=count+ st.executeUpdate(each); boylede olur
   //         count++;
   //     }
   //     System.out.println(count+" satir database'de data guncellendi.");//count yerine veri.lenght de yapilabilir
   //

        //2.yol
        String [] veri2={"insert into ogrenciler values(500,'Sene Can',12,'K')",
                "insert into ogrenciler values(501,'Sene Can',12,'K')",
                "insert into ogrenciler values(502,'Sene Can',12,'K')"};

        for (String each:veri2){
            st.addBatch(each);//yukaridaki datalarin hepsini birlestirir.
        }
        st.executeBatch();  //datalari tek seferde gonderiyor


    }
}
