package day3.Scanner.App.Review;

import java.util.Scanner;

public class ReviewMain {
    public static void main(String[] args) {
        Review.ReviewController reviewController = new Review.ReviewController();
        Scanner input = new Scanner(System.in);
        System.out.println("===Reviews===");
        reviewController.displayAllReview();
        System.out.println("Mau menambahkan review? y/n");
        String choice=input.nextLine();
        if (choice.toLowerCase().equals("y")){
            System.out.println("Berapa review?");
            int totalReview=input.nextInt();
            input.nextLine();
            for (int i = 0; i < totalReview; i++) {
                System.out.println("Reviewer "+(i+1));
                System.out.printf("Nama : ");
                String name=input.nextLine();
                System.out.printf("Rating : ");
                int rating=input.nextInt();
                input.nextLine();
                Review review = new Review(name,rating);
                reviewController.addReview(review);
            }
            reviewController.displayAllReview();
            System.out.println("dadah");
        }
    }
}
