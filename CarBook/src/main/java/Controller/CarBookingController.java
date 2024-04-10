package Controller;

import java.util.List;

import Dao.BookingDao;
import Dao.CarDao;
import Dao.CustomerDao;
import Model.Booking;
import Model.Car;
import Model.Customer;

public class CarBookingController {
    private CustomerDao customerDao;
    private CarDao carDao;
    private BookingDao bookingDao;

    public CarBookingController(CustomerDao customerDao, CarDao carDao, BookingDao bookingDao) {
        this.customerDao = customerDao;
        this.carDao = carDao;
        this.bookingDao = bookingDao;
    }

    // Thêm một khách hàng mới
    public boolean addCustomer(String name, String address, String email, String phone) {
        Customer customer = new Customer(0, name, address, email, phone);
        return customerDao.addCustomer(customer);
    }

    // Lấy danh sách tất cả các khách hàng
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    // Xóa một khách hàng dựa trên ID
    public boolean deleteCustomer(int customerId) {
        return customerDao.deleteCustomer(customerId);
    }

    // Thêm một chiếc xe mới
    public boolean addCar(String carName, String carType, String description, double rentalPrice, int customerId) {
        Car car = new Car(0, carName, carType, description, rentalPrice, customerId);
        return carDao.addCar(car);
    }

    // Lấy danh sách tất cả các xe
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    // Xóa một chiếc xe dựa trên ID
    public boolean deleteCar(int carId) {
        return carDao.deleteCar(carId);
    }

    // Thêm một đặt xe mới
    public boolean addBooking(int customerId, int carId, java.util.Date startTime, java.util.Date endTime, String rentalType, double totalPrice, String status) {
        Booking booking = new Booking(0, customerId, carId, startTime, endTime, rentalType, totalPrice, status);
        return bookingDao.addBooking(booking);
    }

    // Lấy danh sách tất cả các đặt xe
    public List<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }

    // Xóa một đặt xe dựa trên ID
    public boolean deleteBooking(int bookingId) {
        return bookingDao.deleteBooking(bookingId);
    }
}
