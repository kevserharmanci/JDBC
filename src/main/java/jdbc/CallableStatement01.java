package jdbc;

import java.sql.*;

public class CallableStatement01 {
    /*
    Java'da methodlar return type sahibi olsada void olsada method olarak adlandirilir
    SQL'de ise dat return ediyorsa buna biz "function(fonksiyon)" denir.Return yapmiyorsa "procedure" diye adlandirilir.
     */




    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "3541Kevser.");
        Statement st = con.createStatement();
        //1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.
        //1.adim:fonksiyon kodunu yaz
        String sql1 = "CREATE OR REPLACE FUNCTION toplamF(x NUMERIC,y NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN x+y;\n" +
                "\n" +
                "END\n" +
                "$$\n";
        //2.adim:fonksiyonumuzu calistiracagiz
        st.execute(sql1);

        //3.adim:fonksiyonu cagir
        CallableStatement cst1=con.prepareCall("{? = call toplamF(?,?)}");

        //4.adim:return icin registerOutParameter() methodunu paremetreler icin ise set() methodlarindan uygun olanlari kullan
        cst1.registerOutParameter(1,Types.NUMERIC);//1.soru isareti  return icin

        cst1.setInt(2,15);//ikici soru isareti ilk paremetre
        cst1.setInt(3,25);//ucuncu soru isareti ikinci paremetre


        //5.adim:calşstirmak icin execute() methodunu kullan
        cst1.execute();

        //6.adim:sonucu cagırmak ıntellijde gormek ıcın return data tipine gore "get" methodlarindan uygunolani kullan.
        System.out.println(cst1.getBigDecimal(1));//return paremetre indexsini girdik.




        //2.ORNEK:Koninin hacmini hesaplayan bir function yazin
        String sql2 = "\t   CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC,h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN (3.14*r*r*h)/3;\n" +
                "\n" +
                "END\n" +
                "$$";
        //2.adim:fonksiyonumuzu calistiracagiz
        st.execute(sql2);

        //3.adim:fonksiyonu cagir
        CallableStatement cst2=con.prepareCall("{? = call koniHacmi(?,?)}");

        //4.adim:return icin registerOutParameter() methodunu paremetreler icin ise set() methodlarindan uygun olanlari kullan
        cst2.registerOutParameter(1,Types.NUMERIC);//1.soru isareti  return icin

        cst2.setInt(2,3);//ikici soru isareti ilk paremetre
        cst2.setInt(3,5);//ucuncu soru isareti ikinci paremetre


        //5.adim:calşstirmak icin execute() methodunu kullan
        cst2.execute();

        //6.adim:sonucu cagırmak ıntellijde gormek ıcın return data tipine gore "get" methodlarindan uygunolani kullan.
        System.out.println(cst2.getBigDecimal(1));//return paremetre indexsini girdik.



        //--dikdortgenin cevresini donduren function yazin
        String sgl3="CREATE OR REPLACE FUNCTION dikdortgenCevre(a numeric,b numeric)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql \n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN 2*(a+b);\n" +
                "\n" +
                "END\n" +
                "$$";

        st.execute(sgl3);
        CallableStatement cst3=con.prepareCall("{? = call dikdortgenCevre(?,?)}");
        cst3.registerOutParameter(1,Types.NUMERIC);
        cst3.setInt(2,3);
        cst3.setInt(3,5);
        cst3.execute();
        System.out.println(cst3.getBigDecimal(1));
    }
}
