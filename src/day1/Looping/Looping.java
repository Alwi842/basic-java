package day1.Looping;

public class Looping {
    public static void main(String[] args) {
        int[] numbers={1,2,3,4,5};
        //for biasa
        System.out.println("===For Loop biasa===");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        //enhanced loop
        System.out.println("===Enhanced loop===");
        for(int i : numbers){
            System.out.println(i);
        }
        //while loop
        int i=0;
        while (i<numbers.length){
            System.out.println(numbers[i]);
            i++;
        }

    }
}
