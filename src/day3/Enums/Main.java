package day3.Enums;

public class Main {
    public static void main(String[] args) {
        //panggil enum
        EnumDay today = EnumDay.FRIDAY;

        switch (today){
            case SUNDAY:
                System.out.println("today is sunday");
                break;
            case MONDAY:
                System.out.println("today is MONDAY");
                break;
            case TUESDAY:
                System.out.println("today is TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("today is WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("today is THURSDAY");
                break;
            case FRIDAY:
                System.out.println("today is FRIDAY");
                break;
            case SATURDAY:
                System.out.println("today is SATURDAY");
                break;
            default:
                System.out.println("error day!");
        }
        EnumLikeClass getToday = EnumLikeClass.MONDAY;
        System.out.println("Today is "+getToday+" and its a "+getToday.getType());
    }
}
