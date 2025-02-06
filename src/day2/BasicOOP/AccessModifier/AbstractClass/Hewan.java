package day2.BasicOOP.AccessModifier.AbstractClass;
/*ABSTRACT CLASS : class yang gk bisa dibuat instance creation secara langsung
* atau gk bisa dibuat objek secara langsung, cuma bisa dipake buat class, subclass dan turunannya*/
public abstract class Hewan {
    public String nama;
    private int umur;

    public Hewan(String nama, int umur){
        this.nama=nama;
        this.umur=umur;
    }

    /*Abstract method : method yang harusdiimplementasikan oleh class turunannya
    * kalo gk di implementasi, maka class turunannya juga gk bakal jadi abstract
    * dan gk bisa dibuat objek secara langsung*/
    public abstract void makan();
    //Method biasa
    public void tidur(){
        System.out.println(nama + " Lagi turu!");
    }

    //getter/setter, getter untuk nambil data, setter buat ngubah data

    public String getNama(){
        return nama;
    }
    public int getUmur(){
        return umur;
    }

}
