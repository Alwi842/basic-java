package day3.Scanner.App.Products;

import java.io.*;
import java.util.*;

public class Products {
    public String name;
    public double price;
    public String category;

    public Products(String name, double price, String category){
        this.name=name;
        this.price=price;
        this.category=category;
    }
    //inner class
    public static class ProductController{
        private final List<Products> productsList;

        public ProductController(){productsList= new ArrayList<>();}
        //method
        public void addProduct(Products product){productsList.add(product);}

        public void displayAllProduct(){
            if (!productsList.isEmpty()){
                for (Products product : productsList){
                    System.out.println("Nama : "+product.name+", Price : "+product.price+", category : "
                            +product.category);
                }
            } else {
                System.out.println("produk tidak valid");
            }
        }
        public void sortItemAscending(){
            productsList.sort(Comparator.comparingDouble(productsList -> productsList.price));
            System.out.println("masuk");
            displayAllProduct();
        }
        public void sortItemDescending(){
            productsList.sort(Comparator.comparingDouble(productsList ->productsList.price));
            Collections.reverse(productsList);
            displayAllProduct();
        }
        public void searchItem(String name){
            for (Products product : productsList){
                if (product.name.toLowerCase().contains(name.toLowerCase())) {
                    System.out.println("Produk "+name+" ada! :");
                    System.out.println("Nama : "+product.name+", Price : "+product.price+", category : "
                            +product.category);
                }
            }
        }
        public void storeProduct(){
            String fileName="G:\\programming\\java\\basic_java\\src\\day3\\Scanner\\App\\Products\\products.txt";
            File file = new File(fileName);
            try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
                for (Products product : productsList){
                    writer.write(product.name+","+product.price+","+product.category+"\n");
                }
                System.out.println("File berhasil dibuat \n path : "+file.getAbsolutePath());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        public void getProduct(){
            String filePath="G:\\programming\\java\\basic_java\\src\\day3\\Scanner\\App\\Products\\products.txt";

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
                for(String line; (line=reader.readLine()) !=null;){
                    String[] data = line.split(",");
                    if (data.length==3){
                        String name=data[0];
                        double price = Double.parseDouble(data[1]);
                        String category = data[2];
                        Products product = new Products(name,price,category);
                        addProduct(product);
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
