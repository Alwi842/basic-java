package day1.DataCollection.List;

import java.util.LinkedList;

/*LinkedList : implementasi dari interface list yang punyafungsi sama kaya arrayList*/
public class LinkedListExample {
    public static void main(String[] args) {
//        Linked list
        LinkedList<String> daftarNama=new LinkedList<>();
        System.out.println("linked list bro");

        daftarNama.add("danu");
        daftarNama.add("Alwi");
        daftarNama.add("Dani");
        daftarNama.addFirst("abdull");
        daftarNama.addLast("royyan");

        //cara nambahin elemen di indeks tertentu
        daftarNama.add(3,"dina");
        System.out.println("data : " + daftarNama.getFirst());
        System.out.println("data : " + daftarNama.getLast());

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

    }
}
