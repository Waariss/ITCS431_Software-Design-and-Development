package Vehicles;
import People.Customer;

public class TradeInVehicle{
    private String Model;
    private String make;
    private int Year;
    private double Price;
    private Customer customer; // a trade-in vehicle can be associated with one customer
    private Vehicle newVehicle; // a trade-in vehicle can be associated with one new vehicle
    // Constructor
    public TradeInVehicle(String model, String make, int year, double price) {
        this.Model = model;
        this.make = make;
        this.Year = year;
        this.Price = price;
    }
    // getter methods
    public String getModel() {
        return Model;
    }
    public String getBrand() {
        return make;
    }
    public int getYear() {
        return Year;
    }
    public double getPrice() {
        return Price;
    }
    public Vehicle getNewVehicle() {
        return newVehicle;
    }
    public Customer getCustomer() {
        return customer;
    }
    // setter methods
    public void setModel(String model) {
        this.Model = model;
    }
    public void setBrand(String make) {
        this.make = make;
    }
    public void setYear(int year) {
        this.Year = year;
    }
    public void setPrice(double price) {
        this.Price = price;
    }
    public void setNewVehicle(Vehicle newVehicle) {
        this.newVehicle = newVehicle;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // getTradeInAllowance method
    public double getTradeInAllowance() {
        return this.Price * 0.8;
    }
    //returnTradeInVehicle method
    public void returnTradeInVehicle() {
        this.customer = null;
        this.newVehicle = null;
    }
    //getTradeInValue method
    public double getTradeInValue() {
        return this.Price;
    }
}
