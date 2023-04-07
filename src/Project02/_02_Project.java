package Project02;

import java.util.ArrayList;
import java.util.Scanner;

public class _02_Project {
    static int index = 0;

    public static void main(String[] args) {
        Scanner okuStr = new Scanner(System.in);
        Scanner okuInt = new Scanner(System.in);

        ArrayList<String> kullaniciAdi = new ArrayList<>();
        kullaniciAdi.add("user1");
        kullaniciAdi.add("user2");
        kullaniciAdi.add("user3");
        ArrayList<String> sifre = new ArrayList<>();
        sifre.add("password1"); // 0. index
        sifre.add("password2");
        sifre.add("password3");
        ArrayList<String> hesapNo = new ArrayList<>();
        hesapNo.add("1234"); // 0. index
        hesapNo.add("5678");
        hesapNo.add("9999");
        ArrayList<Integer> hesapBakiye = new ArrayList<>();
        hesapBakiye.add(200); // 0. index
        hesapBakiye.add(1000);
        hesapBakiye.add(5000);

        String username = "";
        String password = "";

        while (true) {
            System.out.println("Kullanıcı adınız giriniz=");
            username = okuStr.nextLine();
            System.out.print("şifrenizi giriniz=");
            password = okuStr.nextLine();

            if (confirmUsernameAndPassword(kullaniciAdi, sifre, username, password)) {
                System.out.println("başarılı bir şekilde giriş yaptınız");
                break;
            } else {
                System.out.println("Sistemde kayitli boyle bir kullanici bulunamadi,tekrar deneyin");
            }
        }
        int secim = 0;
        while (true) {
            System.out.println("Menü\n1-Para Yatır\n2-Para Çekme\n3-Transfer\n4-Hesap Aç\n5-Çıkış Yap\nSeçiminizi yapınız=");
            secim = okuInt.nextInt();
            switch (secim) {
                case 1:
                    System.out.println("Bu bankamatik gecici olarak para yatirma islemine kapalidir...Uzgunuz");
                    break;
                case 2:
                    for (int i = 0; i < kullaniciAdi.size(); i++) { // bu döngüde girilen userin listlerden hangsi ile uyuştuğunu buluyor
                        if (username.equalsIgnoreCase(kullaniciAdi.get(i))) {
                            index = i; // indexi burada tespit edildi.
                            break;
                        } else {
                            System.out.println("sistemede bir hata oluştu");
                        }
                    }
                    System.out.println("hesap numaranız=" + hesapNo.get(index) + "bakiyeniz=" + hesapBakiye.get(index));
                    System.out.println("miktar giriniz=");
                    int miktar=okuInt.nextInt();
                    withdraw(hesapBakiye,miktar);
                    break;
                case 3:
                    System.out.println("Bu islemi su an gerceklestiremiyoruz");
                    break;
                case 4:
                    System.exit(1);
                default:
                    System.out.println("başarılı bir seçim yapamadınız");
            }
        }
    }
    public static boolean confirmUsernameAndPassword(ArrayList<String> username, ArrayList<String> password, String user, String sifre) {
        for (int i = 0; i < username.size(); i++) {
            if (user.equalsIgnoreCase(username.get(i)) && sifre.equalsIgnoreCase(password.get(i))) {
                return true;
            }
        }
        return false;
    }
    public static void withdraw(ArrayList<Integer> bakiye, int miktar) {
        if (miktar <= bakiye.get(index)) {
            System.out.println("kalan para=" + (bakiye.get(index) - miktar));
        } else {
            System.out.println("bakiyeniz yetersiz");
        }
    }
}