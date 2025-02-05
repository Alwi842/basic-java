package day1.MathMethod;

public class MathMethod {
    public static void main(String[] args) {
        float phi= (float) Math.PI;
        System.out.println("Math.PI : "+phi);

        double floorValue = Math.floor(3.8); //bulat kebawah
        System.out.println("Math.floor : "+floorValue);

        double ceilValue=Math.ceil(3.4); //bulat keatas
        System.out.println("math celi : "+ceilValue);

        double roundedValue=Math.round(3.4); // bulat terdekat
        System.out.println("Math round : "+roundedValue);

        double squareValue=Math.sqrt(4); //square root
        System.out.println("square root : "+ squareValue);

        double powerOfTwo=Math.pow(4,2);//nentuin pangkat
        System.out.println("Math.pow : "+powerOfTwo);
        int min = Math.min(10,20);
        System.out.println("Math.min : " +min);

        int max =Math.max(20,10);
        System.out.println("Math.max : "+max);

        double random=Math.random();
        System.out.println("Math.random : "+random);
    }
}
