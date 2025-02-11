package day5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;
import java.util.Scanner;

public class ProductCURD {
    String url="jdbc:postgresql://localhost:5432/store";
    String username="postgres";
    String password="root";
    Scanner input = new Scanner(System.in);

    public void getData() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                // Print each row in a human-readable format
                System.out.println("ID           : " + resultSet.getInt("id"));
                System.out.println("Name         : " + resultSet.getString("name"));
                System.out.println("Price        : " + resultSet.getDouble("price"));
                System.out.println("Category ID  : " + resultSet.getInt("category_id"));
                System.out.println("----------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addData(){
        System.out.printf("masukan nama barang : ");
        String name = input.nextLine();
        System.out.printf("Masukan harga produk : ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.printf("Masukan nama kategori : ");
        String category = input.nextLine();
        int categoryId = getCategoryId(category);
        if (categoryId==-1) categoryId = createCategory(category);
        if (categoryId==-1) {
            System.out.println("chategory failed to created...");
            return;
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "insert into products(name,price, category_id) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,price);
            preparedStatement.setInt(3, categoryId);

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
        boolean idIsExist=checkID(id);
        if (!idIsExist) {
            System.out.println("Id tidak dapat ditemukan :(");
            return;
        }
        System.out.print("masukan nama barang : ");
        String name = input.nextLine();
        System.out.printf("Masukan harga produk : ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.printf("Masukan kategori produk : ");
        String category = input.nextLine();
        int categoryId = getCategoryId(category);
        if (categoryId==-1) categoryId = createCategory(category);
        if (categoryId==-1) {
            System.out.println("chategory failed to created...");
            return;
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "update products set name = ?, price = ?, category_id = ? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,price);
            preparedStatement.setInt(3,categoryId);
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
    public void deleteData() {
        System.out.print("Input product ID: ");
        int productId = input.nextInt();
        input.nextLine(); // Consume newline

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String deleteOrderItemsQuery = "DELETE FROM order_items WHERE product_id = ?";
            try (PreparedStatement deleteOrderItemsStmt = connection.prepareStatement(deleteOrderItemsQuery)) {
                deleteOrderItemsStmt.setInt(1, productId);
                int itemsDeleted = deleteOrderItemsStmt.executeUpdate();
                if (itemsDeleted > 0) {
                    System.out.println("Deleted " + itemsDeleted + " order_items for product ID: " + productId);
                }
            }

            String deleteProductQuery = "DELETE FROM products WHERE id = ?";
            try (PreparedStatement deleteProductStmt = connection.prepareStatement(deleteProductQuery)) {
                deleteProductStmt.setInt(1, productId);
                int rowsDeleted = deleteProductStmt.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Product ID " + productId + " deleted successfully!");
                } else {
                    System.out.println("Product ID " + productId + " not found :(");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkID(int id){
        boolean isFound=false;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) isFound=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isFound;
    }
    public int getCategoryId(String category) {
        int categoryId = -1;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM categories WHERE category=?");
            preparedStatement.setString(1, category);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                categoryId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryId;
    }

    public int createCategory(String category) {
        int generatedId = -1;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO categories(category) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category);
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedId = resultSet.getInt(1);
            }

            System.out.println("Category has been added with ID: " + generatedId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return generatedId;
    }
    public void checkHighestRatedProduct(){
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT \n" +
                    "    p.id AS product_id, \n" +
                    "    p.name AS product_name, \n" +
                    "    ROUND(AVG(pr.rating), 2) AS avg_rating\n" +
                    "FROM product_review pr\n" +
                    "JOIN products p ON pr.product_id = p.id\n" +
                    "GROUP BY p.id, p.name\n" +
                    "ORDER BY avg_rating DESC\n" +
                    "LIMIT 1;\n";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // Print each row in a human-readable format
                System.out.println("ID           : " + resultSet.getInt("product_id"));
                System.out.println("Name         : " + resultSet.getString("product_name"));
                System.out.println("Rating         : " + resultSet.getString("avg_rating"));
                System.out.println("----------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
