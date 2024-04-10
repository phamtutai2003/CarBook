package Model;

public class Car {
    private int id;
    private String carName;
    private String carType;
    private String description;
    private double rentalPrice;
    private int customerId; // ID của khách hàng sở hữu xe

    public Car(int id, String carName, String carType, String description, double rentalPrice, int customerId) {
        this.id = id;
        this.carName = carName;
        this.carType = carType;
        this.description = description;
        this.rentalPrice = rentalPrice;
        this.customerId = customerId;
    }

    // Các phương thức getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
