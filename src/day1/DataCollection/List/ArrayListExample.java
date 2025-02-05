package day1.DataCollection.List;
import java.util.ArrayList;
/*ARRAY LIST : implementasi dari interfase List yang fungsinya buat nyimpen data berbentuk array
* ArrayList biasanya dipake buat nyimpen data kompleks seperti objek
* kelebihan array list dibanding array biasa adalah kemudahan untuk memanipulasi datanya*/
public class ArrayListExample {
    public static void main(String[] args) {
        //array biasa
        int[] arrayBiasa=new int[5];
        arrayBiasa[0]=10;
        arrayBiasa[1]=20;

        //array list
        ArrayList<String> daftarNama = new ArrayList<>();

        //cara nyimpen data/elemen ke dalam arrayList
        daftarNama.add("danu");
        daftarNama.add("Alwi");
        daftarNama.add("Dani");

        //cara nambahin elemen di indeks tertentu
        daftarNama.add(3,"dina");

        //cara akses data di elemen indeks tertentu
        System.out.println("Data : " + daftarNama.get(0));
        //ngubah elemen
        daftarNama.set(0,"Dimas");
        System.out.println("Data : " + daftarNama.get(0));

        //ngapus elemen
        daftarNama.remove(0);
        System.out.println("Data : "+daftarNama.get(0));

        //ngitung jumplah elemen
        System.out.println("jumlah data : " + daftarNama.size());
        //ngecek apakah arrayList kosong
        System.out.println("Apakah array list kosong?"+daftarNama.isEmpty());

        //ngecek apakah elemen tertentu ada didalam arrayList
        System.out.println("Nama 'Alwi' ada didalam daftar?: "+ daftarNama.contains("Alwi"));

        //ngambil indeks elemen tertentu
        System.out.println("Indeks 'alwi' : "+ daftarNama.indexOf("Alwi"));

        //nampilin semua elemen dalam arraylist
        System.out.println("daftar nama : " + daftarNama);

        //nampilin semua data pada looping
        for (String nama : daftarNama){
            System.out.println(nama);
        }
        //buat arraylist dengan tipe data yang berbeda
        ArrayList<Object> dataRandom = new ArrayList<>();
        dataRandom.add("alwi");
        dataRandom.add(24);
        dataRandom.add(false);
        dataRandom.add(3.5);
        for(Object data : dataRandom){
            System.out.println(data);
        }
    }
}
