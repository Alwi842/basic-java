package day1.Logic;

public class LogicStatement {
    public static void main(String[] args) {
        int nilai=10;
        //if
        if (nilai==10){
            System.out.println("nilaimu bagus");
        }
        //if - else
        int nilaiSiswa=70;
        if (nilaiSiswa>=60){
            System.out.println("lulus");
        } else {
            System.out.println("tidak lulus");
        }

        //if-else-if
        if(nilaiSiswa>=90) {
            System.out.println("Nilai A");
        } else if (nilaiSiswa>=80) {
            System.out.println("Nilai B");
        } else  {
            System.out.println("Nilai C");
        }
        //Switch case
        String grade ="B";
        switch (grade){
            case "A":
                System.out.println("Amat baik");
                break;
            case "B":
                System.out.println("Baik");
                break;
            default:
                System.out.println("Cukup");
                break;
        }
    }
}
