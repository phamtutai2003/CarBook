package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;


public class CustomerDao {
    private Connection connection;

    public CustomerDao(Connection connection) {
        this.connection = connection;
    }

    // Thêm một khách hàng mới vào cơ sở dữ liệu
    public boolean addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO Customer (Name, Address, Email, Phone) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhone());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả các khách hàng từ cơ sở dữ liệu
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            String query = "SELECT * FROM Customer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");

                Customer customer = new Customer(id, name, address, email, phone);
                customerList.add(customer);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerList;
    }

    // Xóa một khách hàng từ cơ sở dữ liệu
    public boolean deleteCustomer(int customerId) {
        try {
            String query = "DELETE FROM Customer WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

