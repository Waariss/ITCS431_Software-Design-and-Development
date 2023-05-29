package People;
import java.util.ArrayList;
import java.util.List;
import Invoice.SaleInvoice;
import Vehicles.Vehicle;

public class Saleperson {
    private String FirstName;
    private String LastName;
    private String EmployeId;
    private String PhoneNumber;
    private String Email;
    private List<SaleInvoice> saleInvoices; //A saleperson can have many SaleInvoices
    private List<Vehicle> vehicles; // A saleperson can handle multiple vehicles
    private List<Customer> customers; // A saleperson can have many customers
    
    // Constructor
    public Saleperson(String firstName, String lastName, String employeId, String phoneNumber, String email) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.EmployeId = employeId;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.saleInvoices = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
    }
    //getter methods
    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getEmployeId() {
        return EmployeId;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getEmail() {
        return Email;
    }
    public List<SaleInvoice> getSaleInvoices() {
        return this.saleInvoices;
    }
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }
    public List<Customer> getCustomers() {
        return this.customers;
    }
    //setter methods
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }
    public void setEmployeId(String employeed) {
        this.EmployeId = employeed;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    //add SaleInvoice to Saleperson
    public void addSaleInvoice(SaleInvoice saleInvoice) {
        saleInvoices.add(saleInvoice);
    }
    //add Vehicle to Saleperson
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    //add Customer to Saleperson
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    //remove SaleInvoice from Saleperson
    public void removeSaleInvoice(SaleInvoice saleInvoice) {
        saleInvoices.remove(saleInvoice);
    }
    //remove Vehicle from Saleperson
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
    //remove Customer from Saleperson
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    //get SaleInvoice from Saleperson
    public SaleInvoice getSaleInvoice(int index) {
        return saleInvoices.get(index);
    }
    //get Vehicle from Saleperson
    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }
    //get Customer from Saleperson
    public Customer getCustomer(int index) {
        return customers.get(index);
    }
}