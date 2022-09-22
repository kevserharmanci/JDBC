package jdbsPractice;

import java.sql.*;//herseyi sql den aldıgımız icin

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1)Driver yukle
        Class.forName("org.postgresql.Driver");
        //2)Baglanti olustur
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                                                   "techproed",
                                                  "3541Kevser.");

        //3)Sql kodlarini yazmak icin statement olustur
        Statement st=con.createStatement();

        //4)ResultSet olustur(sorgulama yapınca veriyi dondermek icin)

        ResultSet veri=st.executeQuery("select * from ogrenciler");

        //5)Sonuclari al

        while(veri.next()){
            //1.yol index kullanarak
          //System.out.println(veri.getInt(1)+"-->"+veri.getString(2)+"-->"+
          //        veri.getString(3)+"-->"+veri.getString(4));
            //2.yol column(sutun) ismi ile
            //System.out.println(veri.getInt("okul_no")+"-->"+veri.getString("ogrenci_ismi")
            //       +"-->"+ veri.getString("sinif")+"-->"+veri.getString("cinsiyet"));

       //printf ile
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));

           /*
                                             Tip Karakteri

                               İşlevi                             Tipi
                    %c      ==>tek bir karakter                  (char)
                    %d      ==>işaretli ondalık tamsayı          (int, short)
                    %ld     ==>uzun işaretli ondalık tamsayı     (long)
                    %u      ==>işaretsiz ondalık tamsayı         (unsigned int, unsigned short)
                    %f      ==>Gerçel sayı                       (float, double)
                    %s      ==>karakter dizisi                   (string)(char)
                    %lu     ==>işaretsiz uzun tamsayı            (unsigned long)

            */
        }
        //6)kapatma
        con.close();
        st.close();
        veri.close();

    }
}
