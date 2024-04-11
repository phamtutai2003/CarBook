package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Booking;

public class BookingDao {
    private Connection connection;

    public BookingDao(Connection connection) {
        this.connection = connection;
    }

    // Thêm một booking mới vào cơ sở dữ liệu
    public boolean addBooking(Booking booking) {
        try {
            String query = "INSERT INTO Booking (CustomerID, CarID, StartTime, EndTime, RentalType, TotalPrice, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, booking.getCustomerId());
            preparedStatement.setInt(2, booking.getCarId());
            preparedStatement.setTimestamp(3, new Timestamp(booking.getStartTime().getTime()));
            preparedStatement.setTimestamp(4, new Timestamp(booking.getEndTime().getTime()));
            preparedStatement.setString(5, booking.getRentalType());
            preparedStatement.setDouble(6, booking.getTotalPrice());
            preparedStatement.setString(7, booking.getStatus());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả các đặt xe từ cơ sở dữ liệu
    public List<Booking> getAllBookings() {
        List<Booking> bookingList = new ArrayList<>();
        try {
            String query = "SELECT * FROM Booking";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int customerId = resultSet.getInt("CustomerID");
                int carId = resultSet.getInt("CarID");
                Timestamp startTime = resultSet.getTimestamp("StartTime");
                Timestamp endTime = resultSet.getTimestamp("EndTime");
                String rentalType = resultSet.getString("RentalType");
                double totalPrice = resultSet.getDouble("TotalPrice");
                String status = resultSet.getString("Status");

                Booking booking = new Booking(id, customerId, carId, new java.util.Date(startTime.getTime()), new java.util.Date(endTime.getTime()), rentalType, totalPrice, status);
                bookingList.add(booking);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookingList;
    }

    // Xóa một booking từ cơ sở dữ liệu
    public boolean deleteBooking(int bookingId) {
        try {
            String query = "DELETE FROM Booking WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookingId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

