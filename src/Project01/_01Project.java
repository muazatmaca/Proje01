package Project01;
import java.util.Scanner;
public class _01Project {
    public static void main(String[] args) {
        Scanner okuStr=new Scanner(System.in);
        System.out.print("Adınızı giriniz=");
        String ad=okuStr.next();
        System.out.println(ad.substring(0,1).toUpperCase()+ad.substring(1).toLowerCase()+" hoşgeldin, soyismini girer misin");
        System.out.print("Soy adınızı giriniz=");
        String soyad=okuStr.next();
        System.out.println(ad.substring(0,1).toUpperCase()+ad.substring(1).toLowerCase()+" "+soyad.substring(0,1).toUpperCase()+soyad.substring(1).toLowerCase());
        System.out.println("Eğer görülen isim ve soyisim doğru ise Y tusuna basarak devam ediniz.");
        String harf="";

        while (!harf.equalsIgnoreCase("y")){
            harf= okuStr.next();
            if (!harf.equalsIgnoreCase("y")){
                System.out.println("sisteme yanlış giriş yaptınız, tekrar deneyiniz");
            }
        }
        System.out.print("Lütfen kullanıcı adınızı belirleyin=");
        String kullaniciAdi= okuStr.next();
        System.out.print("Lütfen şifrenizi belirleyin=");
        String sifre="";
        sifre=okuStr.next();
        System.out.print("Lütfen şifrenizi tekrar giriniz=");
        String sifreTekrar="";
        sifreTekrar=okuStr.next();

        while (!(sifre.equalsIgnoreCase(sifreTekrar))){
            System.out.println("şifre uyuşmuyor, şifrenizi tekrar giriniz=");
            sifre=okuStr.next();
            System.out.println("şifreti tekrar giriniz=");
            sifreTekrar=okuStr.next();
        }
        if (sifre.equalsIgnoreCase(sifreTekrar))
            System.out.println("Tebrikler"+" "+kullaniciAdi+" "+"kullanıcı adiyla sisteme kayit oldunuz.");
    }
}
