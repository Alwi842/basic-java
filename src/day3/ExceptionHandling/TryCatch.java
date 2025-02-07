package day3.ExceptionHandling;

public class TryCatch {
    public static void main(String[] args) {
        int[] numbers={1,2,3,4,5};

        try{
            //ceknilaidi indeks 3
            int checkNumber=numbers[5];
            System.out.println("Nilai yang diakses: " + checkNumber);
        } catch (ArrayIndexOutOfBoundsException e) {
            //error handling tidak valid
            System.out.println("Indeks array tidak valid");
            System.out.println("Error message : "+e.getMessage());
        }
    }
}
