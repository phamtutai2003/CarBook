package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Car;

public class CarDao {
    private Connection connection;

    public CarDao(Connection connection) {
        this.connection = connection;
    }

    // Thêm một chiếc xe vào cơ sở dữ liệu
    public boolean addCar(Car car) {
        try {
            String query = "INSERT INTO Car (CarName, CarType, Description, RentalPrice, CustomerID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getCarName());
            preparedStatement.setString(2, car.getCarType());
            preparedStatement.setString(3, car.getDescription());
            preparedStatement.setDouble(4, car.getRentalPrice());
            preparedStatement.setInt(5, car.getCustomerId());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả các xe từ cơ sở dữ liệu
    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        try {
            String query = "SELECT * FROM Car";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String carName = resultSet.getString("CarName");
                String carType = resultSet.getString("CarType");
                String description = resultSet.getString("Description");
                double rentalPrice = resultSet.getDouble("RentalPrice");
                int customerId = resultSet.getInt("CustomerID");

                Car car = new Car(id, carName, carType, description, rentalPrice, customerId);
                carList.add(car);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return carList;
    }

    // Xóa một xe từ cơ sở dữ liệu
    public boolean deleteCar(int carId) {
        try {
            String query = "DELETE FROM Car WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, carId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
