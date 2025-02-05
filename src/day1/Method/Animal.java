package day1.Method;

//method override
//belajar inheritance
//class parent
public class Animal {
    public static String sound(){return "Kiu kiu";}
}

//class anak yang mewarisi sifat/method2 parent
class kucing extends Animal {
    public static String sound(){return "Meow meow";}
}