package People;
import java.util.ArrayList;
import java.util.List;
import Invoice.SaleInvoice;
import Vehicles.TradeInVehicle;
import Vehicles.Vehicle;

public class Customer {
    private String FirstName;
    private String LastName;
    private String Address;
    private String PhoneNumber;
    private String Email;
    private String CustomerID;
    private List<SaleInvoice> saleInvoices; //A Customer can have many SaleInvoices
    private List<TradeInVehicle> tradeInVehicles; // a customer can have many trade-in vehicles
    private List<Vehicle> vehicles; // a customer can own many vehicles
    private List<Saleperson> salespeople; // a customer can have many salespeople
    // Constructor
    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerID) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.CustomerID = customerID;
        this.saleInvoices = new ArrayList<>();
        this.tradeInVehicles = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.salespeople = new ArrayList<>();
    }
    //getter methods
    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getAddress() {
        return Address;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getEmail() {
        return Email;
    }
    public String getCustomerID() {
        return CustomerID;
    }
    public List<SaleInvoice> getSaleInvoices() {
        return this.saleInvoices;
    }
    public List<TradeInVehicle> getTradeInVehicles() {
        return this.tradeInVehicles;
    }
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }
    public List<Saleperson> getSalespeople() {
        return this.salespeople;
    }
    //setter methods
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }
    public void setAddress(String address) {
        this.Address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public void setCustomerID(String customerID) {
        this.CustomerID = customerID;
    }
    //add SaleInvoice to Customer
    public void addSaleInvoice(SaleInvoice saleInvoice) {
        saleInvoices.add(saleInvoice);
    }
    //add TradeInVehicle to Customer
    public void addTradeInVehicle(TradeInVehicle tradeInVehicle) {
        tradeInVehicles.add(tradeInVehicle);
    }
    //add Vehicle to Customer
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    //add Saleperson to Customer
    public void addSaleperson(Saleperson saleperson) {
        salespeople.add(saleperson);
    }
    //remove SaleInvoice from Customer
    public void removeSaleInvoice(SaleInvoice saleInvoice) {
        saleInvoices.remove(saleInvoice);
    }
    //remove TradeInVehicle from Customer
    public void removeTradeInVehicle(TradeInVehicle tradeInVehicle) {
        tradeInVehicles.remove(tradeInVehicle);
    }
    //remove Vehicle from Customer
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
    //remove Saleperson from Customer
    public void removeSaleperson(Saleperson saleperson) {
        salespeople.remove(saleperson);
    }
    //get Customer's full name
    public String getFullName() {
        return this.FirstName + " " + this.LastName;
    }
}
