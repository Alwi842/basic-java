package day2.OOP.Test;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Students> students;

    public Student (){
        students = new ArrayList<>();
    }

    public class Students{
        private String name;
        private int NIM;
        private int nilai;
        public Students(String nama, int NIMMahasiswa,int nilaiMahasiswa) {
            name = nama;
            NIM = NIMMahasiswa;
            nilai = nilaiMahasiswa;
        }
        @Override
        //ngebuat toString buat Student biar bisa di iterasi
        public String toString() {
            return "Nama: " + name + ", NIM: " + NIM + ", Nilai: " + nilai;
        }
    }
    public void addStudent(String name, int NIMMahasiswa, int nilaiMahasiswa){
        Students newStudent = new Students(name, NIMMahasiswa, nilaiMahasiswa);
        students.add(newStudent);
    }
    public int averageScore(){
        int total=0;
        for(Students student: students){
            total+=student.nilai;
        }
        int avg=total/students.size();
        return avg;
    }
    public int highestScore(){
        int score=0;
        for(Students student: students){
            score=Math.max(score,student.nilai);
        }
        return score;
    }
    public void displayInfoStudentAboveAverage(){
        int average=averageScore();

        for(Students student: students){
            if(student.nilai>=average){
                System.out.println("Nama : "+student.name+", Nilai : "+student.nilai+" NIM : "+student.NIM);
            }
        }
    }
    public List<Students> getScoreAboveAvg() {
        List<Students> aboveAverageStudents = new ArrayList<>();
        int average = averageScore();

        for (Students student : students) {
            if (student.nilai >= average) {
                aboveAverageStudents.add(student);
            }
        }

        return aboveAverageStudents;
    }

}
