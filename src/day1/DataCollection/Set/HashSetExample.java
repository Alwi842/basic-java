package day1.DataCollection.Set;

import java.util.HashSet;

/*hashSet : implementasi dari interface set buat nyimpen data-data yang unik (tidak boleh duplikat)
* dalam bentuk himpunandata set */
public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> himpunanNama=new HashSet<>();

        himpunanNama.add("alwi");
        himpunanNama.add("abdullah");
        himpunanNama.add("alwi"); //ini gk bakal ditambahin lagi karena sudah ada
        System.out.println("Set nama :"+himpunanNama);
    }
}
