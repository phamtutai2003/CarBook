package Model;

import java.util.Date;

public class Booking {
    private int id;
    private int customerId;
    private int carId;
    private Date startTime;
    private Date endTime;
    private String rentalType;
    private double totalPrice;
    private String status;

    public Booking(int id, int customerId, int carId, Date startTime, Date endTime, String rentalType, double totalPrice, String status) {
        this.id = id;
        this.customerId = customerId;
        this.carId = carId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalType = rentalType;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // Các phương thức getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
