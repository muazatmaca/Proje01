package Project01;
import java.util.Scanner;
public class _01_Project_Again {
    public static void main(String[] args) {
        Scanner okuStr=new Scanner(System.in);
        System.out.print("Adınızı giriniz=");
        String ad="";
        ad=okuStr.next();
        System.out.print(ad.substring(0,1).toUpperCase()+ad.substring(1).toLowerCase()+" hoşgeldin, soyismini girer misin=");
        String soyad="";
        soyad= okuStr.next();
        System.out.println(ad.substring(0,1).toUpperCase()+ad.substring(1).toLowerCase()+" "+soyad.substring(0,1).toUpperCase()+soyad.substring(1).toLowerCase());
        System.out.println("Eğer ekranda görülen isim doğru ise Y tusuna yanlış ise farklı bir tuşa basarak adınızı ve soyadınızı tekrar girebilirsiniz");
        String harf="";
        while (!harf.equalsIgnoreCase("y")){
            harf= okuStr.next();
            if (!harf.equalsIgnoreCase("y")){
                System.out.println("adınızı tekrar giriniz=");
                ad= okuStr.next();
                System.out.println("soyadınızı tekrar giriniz=");
                soyad= okuStr.next();
                System.out.println(ad.substring(0,1).toUpperCase()+ad.substring(1).toLowerCase()+" "+soyad.substring(0,1).toUpperCase()+soyad.substring(1).toLowerCase());
                System.out.println("Eğer ekranda görülen isim doğru ise Y tusuna yanlış ise farklı bir tuşa basarak adınızı ve soyadınızı tekrar girebilirsiniz");
            }
        }
        System.out.println("Kullanıcı isminizi giriniz=");
        String username="";
        username= okuStr.next();
        System.out.println("şifrenizi giriniz=");
        String sifre="";
        sifre= okuStr.next();
        System.out.println("şifrenizi tekrar giriniz=");
        String sifreTekrar="";
        sifreTekrar= okuStr.next();
        while (!(sifre.equals(sifreTekrar))){
            System.out.println("şifeniz uyuşmamaktadır, tekrar şifrenizi giriniz.");
            sifre= okuStr.next();
            System.out.println("şifreyi tekrar giriniz=");
            sifreTekrar= okuStr.next();
        }
        if (sifre.equals(sifreTekrar))
            System.out.println("tebrikler "+username+" kullanıcı adıyla kayit oldunuz.");
    }
}
