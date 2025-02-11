package day5;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductCURD productCURD = new ProductCURD();
        CostumerCURD costumerCURD = new CostumerCURD();

        while(true){
            System.out.println("=====MENU=====");
            System.out.println("1. menu produk");
            System.out.println("2. menu costumer");
            System.out.println("0. exit");
            System.out.println("===============");
            System.out.printf("Pilih menu : ");
            int menu = input.nextInt();
            input.nextLine();
            
            switch (menu){
                case 1:
                    System.out.println("=====MENU PRODUK=====");
                    System.out.println("1. Tambah produk");
                    System.out.println("2. Update produk");
                    System.out.println("3. Hapus produk");
                    System.out.println("4. Lihat produk");
                    System.out.println("5. Lihat produk rating tertinggi");
                    System.out.println("0. exit");
                    System.out.println("===============");
                    System.out.printf("Pilih menu : ");
                    int menuProduk = input.nextInt();
                    input.nextLine();
                    switch (menuProduk){
                        case 1:
                            System.out.println("=====TAMBAH PRODUK=====");
                            productCURD.addData();
                            System.out.println("===============");
                            break;
                        case 2:
                            System.out.println("=====UPDATE PRODUK=====");
                            productCURD.getData();
                            productCURD.editData();
                            System.out.println("===============");
                            break;
                        case 3:
                            System.out.println("=====DELETE PRODUK=====");
                            productCURD.getData();
                            productCURD.deleteData();
                            break;
                        case 4:
                            System.out.println("=====LIST PRODUK=====");
                            productCURD.getData();
                            System.out.println("===============");
                            break;
                        case 5:
                            System.out.println("===Highest rated product===");
                            productCURD.checkHighestRatedProduct();
                            System.out.println("===============");
                            break;
                        case 0:
                            System.out.println("kembali ke menu awal....");
                            break;
                        default:
                            System.out.println("invalid input");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("=====MENU COSTUMER=====");
                    System.out.println("1. Tambah costumer");
                    System.out.println("2. Update costumer");
                    System.out.println("3. hapus costumer");
                    System.out.println("4. Lihat costumer");
                    System.out.println("0. exit");
                    System.out.println("===============");
                    System.out.printf("Pilih menu : ");
                    int menuCostumer = input.nextInt();
                    input.nextLine();
                    switch (menuCostumer){
                        case 1:
                            System.out.println("=====TAMBAH COSTUMER=====");
                            costumerCURD.addData();
                            System.out.println("===============");
                            break;
                        case 2:
                            System.out.println("=====UPDATE COSTUMER=====");
                            costumerCURD.getData();
                            costumerCURD.editData();
                            System.out.println("===============");
                            break;
                        case 3:
                            System.out.println("=====DELETE COSTUMER=====");
                            costumerCURD.getData();
                            costumerCURD.deleteData();
                            break;
                        case 4:
                            System.out.println("=====LIST COSTUMER=====");
                            costumerCURD.getData();
                            System.out.println("===============");
                            break;
                        case 0:
                            System.out.println("kembali ke menu awal....");
                            break;
                        default:
                            System.out.println("invalid input");
                            break;
                    }
                break;
                case 0:
                    System.out.println("dadah, xoxo");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("input invalid");
                    break;
            }
        }
    }
}
