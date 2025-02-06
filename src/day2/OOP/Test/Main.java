package day2.OOP.Test;

/*1. Buat objek/class Student dengan atribut nama, NIM dan nilai
* lalu simpan data Student tersebut ke dalam array list
* kemudian buat method berikut :
* 1. Menghitung rata rata nilai student
* 2. cari nilai tertinggi
* 3. tampilkan data student dengan nilai diatas rata rata*/
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.addStudent("alwi",12345,10);
        student.addStudent("imron",67890,6);
        student.addStudent("danu",13567,8);
        System.out.println("1. Nilai rata-rata mahasiswa : "+student.averageScore());
        System.out.println("2. Nilai tertinggi : "+student.highestScore());
        System.out.println("3. above average : ");
        //iterasi Student
        System.out.println("return array list dan iterasi :");
        for (Student.Students s : student.getScoreAboveAvg()) {
            System.out.println(s);  // This will call the overridden toString() method
        }
        //sout manual
        System.out.println("Manual menggunakn sout : ");
        student.displayInfoStudentAboveAverage();
    }

}
