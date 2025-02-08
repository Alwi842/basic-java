package day3.Scanner.App.Products;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Products.ProductController productController = new Products.ProductController();
        Scanner input = new Scanner(System.in);

        System.out.println("===PRODUCT LIST===");
        productController.displayAllProduct();
        System.out.println("==================");
        System.out.println("Apakah anda ingin menambahkan produk? Y/N");
        String choice = input.nextLine().toUpperCase();
        if (choice.equals("Y")){
            System.out.println("masukan jumlah produk");
            int jumlah = input.nextInt();
            input.nextLine();
            System.out.println("Masukan produk :");
            for (int i = 0; i < jumlah; i++) {
                System.out.println("Produk "+(i+1)+" :");
                System.out.print("nama produk :");
                String nama=input.nextLine();
                System.out.print("harga produk :");
                double price = input.nextDouble();
                input.nextLine();
                System.out.print("nama kategori :");
                String category = input.nextLine();
                Products products = new Products(nama,price,category);

                productController.addProduct(products);
            }
        } else {
            //buat metod read file produk
            productController.getProduct();
        }

        System.out.println("===PRODUCT LIST===");
        productController.displayAllProduct();
        System.out.println("==================");
        //PR BRO
        //SORT METHOD
        System.out.println("===SORT PRODUCT BY PRICE===");
        System.out.println("1. Sort ascending");
        System.out.println("2. Sort descending");
        choice=input.nextLine();
        System.out.println(choice);
        if (choice.equals("1")){
            productController.sortItemAscending();
        } else if (choice.equals("2")){
            productController.sortItemDescending();
        }


        System.out.println("==================");

        System.out.println("Apakah anda ingin mencari produk?y/n");
        //metod &logic untuk mencari produk berdasarkan nama
        choice=input.nextLine();
        if (choice.toLowerCase().equals("y")){
            System.out.println("Masukan nama produk");
            choice=input.nextLine();
            productController.searchItem(choice);
        }
        //save produk ke file
        productController.storeProduct();
    }
}
