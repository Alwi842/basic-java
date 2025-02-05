package day1.Casting;

public class Main {
    public static void main(String[] args) {
        int number=123;
        String intToString=Integer.toString(number);
        //konversi int ke string
        System.out.println("Number to string : "+ intToString);

        String numberString ="123";
        System.out.println("String to number : "+Integer.parseInt(numberString));

        //String to double
        String doubleString="3.14";
        System.out.println("String to double : "+Double.parseDouble(doubleString));

        String booleanString = "true";
        System.out.println("String to boolean : "+Boolean.parseBoolean(booleanString));

        //int to double
        int intValue=13;
        double doubleValue=intValue;
        System.out.println("int to double : "+ doubleValue);

        //double to int
        int intValueFromDouble = (int) doubleValue;
        System.out.println("double to int : "+intValueFromDouble);
    }
}
