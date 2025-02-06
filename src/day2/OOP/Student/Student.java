package day2.OOP.Student;

public class Student {
    public String name;
    public int score;
    private Boolean isPass;

    public Student (String studentName, int studentScore){
        name = studentName;
        score = studentScore;
        isPass=false;
    }

    public void cekStatus(){
        if(score>=80) {
            isPass=true;
            System.out.println("Name : "+name+", score : "+score+" is pass :"+isPass);
            System.out.println("Status : Lulus");

        } else {
            isPass=false;
            System.out.println("Name : "+name+", score : "+score+" is pass :"+isPass);
            System.out.println("Status : Tidak Lulus");
        }
    }
}
