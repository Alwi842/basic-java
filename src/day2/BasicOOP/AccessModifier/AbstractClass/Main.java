package day2.BasicOOP.AccessModifier.AbstractClass;

public class Main {
    public static void main(String[] args) {
        Kucing kucingAlwi = new Kucing("item", 5);

        //akses method
        kucingAlwi.makan();
        kucingAlwi.tidur();

        //akses getter
        System.out.println("Nama kucing : " + kucingAlwi.getNama());
        System.out.println("umur kucing : " + kucingAlwi.getUmur());
    }
}
