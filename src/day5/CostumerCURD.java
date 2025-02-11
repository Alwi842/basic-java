package day5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CostumerCURD {
    String url="jdbc:postgresql://localhost:5432/store";
    String username="postgres";
    String password="root";
    Scanner input = new Scanner(System.in);
    ProductCURD productCURD = new ProductCURD();
    public void getData() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM costumer");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    System.out.println(columnName + " : " + columnValue);
                }
                System.out.println("---------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addData(){
        System.out.print("Input costumer name : ");
        String name = input.nextLine();
        int costumerId=getCustomerByName(name);
        if (costumerId==-1){
            createCostumer(name);
        }
        int orderId=-1;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO orders (date, costumer_id) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(2, costumerId);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                orderId = resultSet.getInt(1);
            }

            System.out.println("New order has been added! Order ID: " + orderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("how much item you want to add?");
        int totalItem = input.nextInt();
        input.nextLine();
        productCURD.getData();
        for (int i = 0; i < totalItem; i++) {
            System.out.println("order : "+i);
            System.out.print("Input product ID: ");
            int productId = input.nextInt();
            input.nextLine();
            if(!productCURD.checkID(productId)) {
                System.out.println("produk with ID : " +productId+ "not found");
                return;
            }
            System.out.print("Input quantity: ");
            int quantity = input.nextInt();
            input.nextLine();
            try{
                Connection connection = DriverManager.getConnection(url,username,password);
                String query = "insert into order_items(order_id, product_id, qty) values (?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,orderId);
                preparedStatement.setInt(2,productId);
                preparedStatement.setInt(3,quantity);

                preparedStatement.executeUpdate();
                System.out.println("order "+i+" has been added!");
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        System.out.println("order successfuly added");
    }
    public void editData(){
        System.out.println("Masukan id costumer : ");
        int id=input.nextInt();
        input.nextLine();
        boolean idIsExist=checkID(id);
        if (!idIsExist) {
            System.out.println("Id tidak dapat ditemukan :(");
            return;
        }
        System.out.printf("Masukan nama : ");
        String name = input.next();
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "update costumer set name = ? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);

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
        int costumerId=input.nextInt();
        input.nextLine();
        try {
            Connection connection = DriverManager.getConnection(url,username,password);

            ArrayList<Integer> orderIds = new ArrayList<>();
            String getOrdersQuery = "SELECT id FROM orders WHERE costumer_id = ?";
            try (PreparedStatement getOrdersStmt = connection.prepareStatement(getOrdersQuery)) {
                getOrdersStmt.setInt(1, costumerId);
                ResultSet resultSet = getOrdersStmt.executeQuery();
                while (resultSet.next()) {
                    orderIds.add(resultSet.getInt("id"));
                }
            }

            String deleteOrderItemsQuery = "DELETE FROM order_items WHERE order_id = ?";
            try (PreparedStatement deleteOrderItemsStmt = connection.prepareStatement(deleteOrderItemsQuery)) {
                for (int orderId : orderIds) {
                    deleteOrderItemsStmt.setInt(1, orderId);
                    deleteOrderItemsStmt.executeUpdate();
                    System.out.println("Deleted order_items for order ID: " + orderId);
                }
            }

            String deleteOrdersQuery = "DELETE FROM orders WHERE costumer_id = ?";
            try (PreparedStatement deleteOrdersStmt = connection.prepareStatement(deleteOrdersQuery)) {
                deleteOrdersStmt.setInt(1, costumerId);
                deleteOrdersStmt.executeUpdate();
                System.out.println("Deleted orders for costumer ID: " + costumerId);
            }

            String deleteCostumerQuery = "DELETE FROM costumer WHERE id = ?";
            try (PreparedStatement deleteCostumerStmt = connection.prepareStatement(deleteCostumerQuery)) {
                deleteCostumerStmt.setInt(1, costumerId);
                int rowsAffected = deleteCostumerStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Deleted costumer ID: " + costumerId);
                } else {
                    System.out.println("Costumer ID not found.");
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM costumer WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) isFound=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isFound;
    }
    public int getCustomerByName(String name) {
        int customerId = -1; // Default if not found

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM costumer WHERE name=?")) {

            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    customerId = resultSet.getInt("id");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerId;
    }
    public int createCostumer(String name) {
        int costumerId = -1;

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO costumer (name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                costumerId = resultSet.getInt(1);
            }

            System.out.println("Costumer added successfully! Costumer ID: " + costumerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return costumerId;
    }

}
