package day3.Scanner.App.Home;

import day3.Scanner.App.Products.ProductMain;
import day3.Scanner.App.Products.Products;
import day3.Scanner.App.Review.Review;
import day3.Scanner.App.Review.ReviewMain;

import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===Menu===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Product");
        System.out.println("4. Cart");
        System.out.println("5. Review");
        Menu myMenu = Menu.valueOf(input.nextLine().toUpperCase());
        switch (myMenu){
            case LOGIN:
                System.out.println("Login sukses");
                break;
            case REGISTER:
                System.out.println("Register sukses");
                break;
            case PRODUCT:
                ProductMain.main(null);
                break;
            case CART:
                System.out.println("cart ku");
                break;
            case REVIEW:
                ReviewMain.main(null);
                break;
            default:
                System.out.println("input tidak valid");
        }
    }
}
