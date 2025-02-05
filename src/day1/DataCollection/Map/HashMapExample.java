package day1.DataCollection.Map;

import java.util.HashMap;
/* hashMap : implementasi dari interface map, buat nyimpen data objek dalam bentuk key dan value*/
/* hashmap kaya representasi array of object kalo di JS*/
public class HashMapExample {
    public static void main(String[] args) {
        //HashMap
        HashMap<String, String> daftarNama=new HashMap<>();
        daftarNama.put("nama", "alwi");
        daftarNama.put("umur", "24");
        daftarNama.put("job", "fullstack");

        //cara akses data dalam hashMap
        System.out.println("Nama : "+daftarNama.get("nama"));
        System.out.println("umur : "+daftarNama.get("umur"));
        System.out.println("job : "+daftarNama.get("job"));

        //ngecek ukuran data
        System.out.println("Jumlah data : " + daftarNama.size());

        //ngecek hashmap kosong
        System.out.println("Apakah hashMap kosong : " + daftarNama.isEmpty());

        //nampilin semua key dalam hashMap
        for (String key : daftarNama.keySet()){
            System.out.println("Key : " + key);
        }

        //nampilin semua isi data dalam hashMap
        for (String value : daftarNama.values()){
            System.out.println("Value : " + value);
        }

        //nampilin semua data key dan value di hashmap
        for (String key : daftarNama.keySet()){
            System.out.println(key + " : "+ daftarNama.get(key));
        }

        //cara ngubah data di hashmap
        daftarNama.put("nama", "royyan");

        //cara ngapus data berdasarkan key
        daftarNama.remove("umur");

    }
}
