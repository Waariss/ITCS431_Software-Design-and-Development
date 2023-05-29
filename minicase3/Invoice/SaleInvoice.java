package Invoice;
import java.util.ArrayList;

import People.Customer;
import People.Saleperson;
import Vehicles.Vehicle;

public class SaleInvoice {
    private Customer customer; // a sale invoice can have one customer
    private Vehicle vehicle; // a sale invoice can have one vehicle
    private double tradeInAllowance; 
    private Saleperson saleperson; // a sale invoice can have one saleperson
    private ArrayList<DealerInstalledOption> dealerInstalledOptions; // a sale invoice can have many dealer installed options
    private double finalPrice;
    private double taxes;
    private double licenseFee;
    private String signature;
    // Constructor
    public SaleInvoice( double tradeInAllowance, double finalPrice, double taxes , double licenseFee,String signature) {
        this.finalPrice = finalPrice;
        this.taxes = taxes;
        this.licenseFee = licenseFee;
        this.signature = signature;
        this.tradeInAllowance = tradeInAllowance;
        this.dealerInstalledOptions = new ArrayList<DealerInstalledOption>();
    }
    // getter methods
    public Customer getCustomer() {
        return customer;
    }
    public Vehicle vehicle() {
        return vehicle;
    }
    public Saleperson getSaleperson() {
        return saleperson;
    }
    public ArrayList<DealerInstalledOption> getDealerInstalledOptions() {
        return dealerInstalledOptions;
    }
    public double getTradeInAllowance() {
        return tradeInAllowance;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public double getTaxes() {
        return taxes;
    }
    public double getLicenseFee() {
        return licenseFee;
    }
    public String getSignature() {
        return signature;
    }
    // setter methods
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setSaleperson(Saleperson saleperson) {
        this.saleperson = saleperson;
    }
    public void setTradeInAllowance(double tradeInAllowance) {
        this.tradeInAllowance = tradeInAllowance;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
    public void setLicenseFee(double licenseFee) {
        this.licenseFee = licenseFee;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    // add a dealer installed option to the list
    public void addDealerInstalledOption(DealerInstalledOption dealerInstalledOption) {
        this.dealerInstalledOptions.add(dealerInstalledOption);
    }
}
