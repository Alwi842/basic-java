package day1.Array;

import java.util.Arrays;

public class arrayMethod {
    public static void main(String[] args) {
        System.out.println("===Array Biasa===");
        int[] numbers={1,2,3,4,5};
        System.out.println("Array length : " +numbers.length);
        numbers[4] =7; //buat ganti value sesuai index

        System.out.println("===array method===");
        System.out.println("===SORT===");
        //mengurutkan secara asc
        Integer[] sortArray ={4,5,3,2,6,1};
        Arrays.sort(sortArray);
        for (int i :sortArray){
            System.out.println("Sorted array : " +i);
        }
        System.out.println("===Fill===");
        //metode fill untuk mengisi semua index array dengan nilai yang sama
        int[] fillArray =new int[5]; //bikin array dengan length 5
        Arrays.fill(fillArray,7); // isi array dengan value 7
        for (int i: fillArray){
            System.out.println("Fill : " + i);
        }

        System.out.println("===COPY OF ARRAY===");
        //metode buat nyalin array lain
        int[] copyArray=Arrays.copyOf(numbers,numbers.length);
        for (int i: copyArray){
            System.out.println("Copy of array  : " + i);
        }
        System.out.println("===COPY OF Range");
        int[] copyOfRangeArray=Arrays.copyOfRange(numbers,1,3);
        for (int i: copyOfRangeArray){
            System.out.println("Copy of array  : " + i);
        }
        //nyalin data dari array numbers ke array newNumbers dan nambahin panjangnya 1
        int[] newNumbers=Arrays.copyOf(numbers,numbers.length+1);
        newNumbers[5]=20;
        for (int i: newNumbers){
            System.out.println("Copy of array  : " + i);
        }

        //equal array : menyamakan dalam 2 data array
        int[] equalNumbers1={1,2,3,4,5};
        int[] equalNumbers2={1,2,3,4,5};
        boolean isEqual=Arrays.equals(equalNumbers1,equalNumbers2);
        System.out.println("Is equal : " + isEqual);
        int search=4;
        for (int i : equalNumbers1){
            if (equalNumbers1[i-1]==search){
                System.out.println("value 4 exist at : "+(i-1));

            }
        }
        System.out.println("===Convert To string===");
        String arrayToString= Arrays.toString(newNumbers);
        System.out.println("array to string : " +arrayToString);
    }
}
