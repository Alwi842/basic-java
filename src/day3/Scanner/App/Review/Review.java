package day3.Scanner.App.Review;

import day3.Scanner.App.Products.Products;

import java.util.ArrayList;
import java.util.List;

public class Review {
    String name;
    int rating;
    public Review(String name, int rating){
        this.name=name;
        this.rating=rating;
    }

    public static class ReviewController{
        private final List<Review> reviewList;
        public ReviewController(){
            reviewList= new ArrayList<>();
        }

        public void addReview(Review review){reviewList.add((review));}
        public void displayAllReview(){
            if (!reviewList.isEmpty()){
                for (Review review : reviewList){
                    System.out.println("Nama : "+review.name + ", rating :"+review.rating);
                }
            } else {
                System.out.println("tidak ada review");
            }
        }
    }
}
