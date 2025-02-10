package day4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DemoCRUD {
    //connect to database(db)
    String url="jdbc:postgresql://localhost:5432/bootcamp";
    String username="postgres";
    String password="root";
    Scanner input = new Scanner(System.in);

    public void getData(){
        try{
            //DriverManager.getConnection : buat ngehubungin dengan database
            Connection connection = DriverManager.getConnection(url,username,password);
            //panggil objek statement buat ngeksekusi query
            Statement statement = connection.createStatement();
            //panggil resultSet buat nampung hasil eksekusi query
            ResultSet resultSet = statement.executeQuery("select * from products");
            //ambil nama kolom dan tiledata dari tiap kolom
            ResultSetMetaData metaData = resultSet.getMetaData();
            //get column count
            int columnCount = metaData.getColumnCount();
            //ObjectMapper : mapping data ke format JSON
            ObjectMapper mapper = new ObjectMapper(); //obj kosong
            // ArrayNode buat nampung data ke array of object(JSON)
            ArrayNode arrayNode = mapper.createArrayNode(); //arr kosong

            while (resultSet.next()){
                //buat data cek untuk setiap baris data
                ObjectNode objectNode = mapper.createObjectNode();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    objectNode.put(columnName, resultSet.getString(i));
                }
                //masukan data objek yang udah di looping ke array
                arrayNode.add(objectNode);
            }
            //buat format data ke format json yang lebih rapih
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
            System.out.println(jsonString);
        }catch (SQLException | JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
    public void addData(){
        System.out.print("masukan nama barang : ");
        String name = input.nextLine();
        System.out.printf("Masukan harga produk : ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.printf("Masukan kategori produk : ");
        String category = input.nextLine();
        try{
            //DriverManager.getConnection : buat ngehubungin dengan database
            Connection connection = DriverManager.getConnection(url,username,password);
            //prepared statment untuk mengeksekusi query yang punya jumlah data banyak.zzz (?,?,?)
            PreparedStatement preparedStatement = connection.prepareStatement("insert into products(product_name,product_price, category) values (?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,price);
            preparedStatement.setString(3,category);

            preparedStatement.executeUpdate();
            System.out.println("data berhasil ditambah");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void editData(){
        System.out.println("Masukan id produk : ");
        int id=input.nextInt();
        input.nextLine();
        System.out.print("masukan nama barang : ");
        String name = input.nextLine();
        System.out.printf("Masukan harga produk : ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.printf("Masukan kategori produk : ");
        String category = input.nextLine();
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("update products set product_name = ?, product_price = ?, category = ? where id=?");
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,price);
            preparedStatement.setString(3,category);
            preparedStatement.setInt(4,id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated>0){
                System.out.println("data berhasil diubah");
            } else {
                System.out.println("data dengan id "+id+" tidak ditemukan");
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void deleteData(){
        System.out.println("Masukan id produk : ");
        int id=input.nextInt();
        input.nextLine();

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from products where id=?");
            preparedStatement.setInt(1,id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated>0){
                System.out.println("data berhasil dihapus!");
            } else {
                System.out.println("data dengan id "+id+" tidak ditemukan");
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void addOrder(){
        boolean isFound=false;
        System.out.printf("Masukan id produk : ");
        int id=input.nextInt();
        input.nextLine();
        System.out.println("");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isFound=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (isFound){
            System.out.printf("Masukan jumlah : ");
            int quantity = input.nextInt();
            input.nextLine();
            try{
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into orders(product_id ,quantity, order_date) values (?,?,?)");
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, quantity);
                preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected > 0 ){
                    System.out.println("data added");
                } else {
                    System.out.println("tidak ada data yang ditambahkan :(");
                }
                System.out.println("data berhasil ditambah");
            }  catch (SQLException e){
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("data tidak ditemukan :(");
        }
    }
    public static void main(String[] args) {
        DemoCRUD demo=new DemoCRUD();
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("===Menu===");
            System.out.println("1. view all product");
            System.out.println("2. Add new product");
            System.out.println("3. Edit products");
            System.out.println("4. Delete product");
            System.out.println("5. Order product");
            System.out.println("0. Exit");
            System.out.print("Pilih menu :");
            int menu = input.nextInt();
            input.nextLine();
            switch (menu){
                case 1:
                    demo.getData();
                    break;
                case 2:
                    demo.addData();
                    break;
                case 3:
                    demo.editData();
                    break;
                case 4:
                    demo.deleteData();
                    break;
                case 5:
                    demo.addOrder();
                    break;
                case 0:
                    System.out.println("dadah, muah");
                    input.close();
                    return;//buat nge close while
                default:
                    System.out.println("input invalid");
            }
        }
    }


}