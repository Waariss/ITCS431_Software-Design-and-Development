package Vehicles;

import java.util.ArrayList;
import java.util.List;
import Invoice.SaleInvoice;
import People.Customer;
import People.Saleperson;

public class Vehicle{
    private String SerialNumber;
    private String Name;
    private String Model;
    private int Year;
    private String Manufacturer;
    private double BaseCost;
    private Customer customer; // a vehicle can have one customer
    private Saleperson saleperson; // a vehicle can have one saleperson
    private List<TradeInVehicle> tradeInVehicles; //Vehicle can have many TradeInVehicles
    private List<SaleInvoice> saleInvoices; // a vehicle can have many sale invoices
    /// Constructor
    public Vehicle(String serialNumber, String name, String model, int year, String manufacturer, double baseCost){
        this.SerialNumber = serialNumber;
        this.Name = name;
        this.Model = model;
        this.Year = year;
        this.Manufacturer = manufacturer;
        this.BaseCost = baseCost;
        this.tradeInVehicles = new ArrayList<>();
        this.saleInvoices = new ArrayList<>();
    }
    //getter methods
    public String getSerialNumber(){
        return SerialNumber;
    }
    public String getName(){
        return Name;
    }
    public String getModel(){
        return Model;
    }
    public int getYear(){
        return Year;
    }
    public String getManufacturer(){
        return Manufacturer;
    }
    public double getBaseCost(){
        return BaseCost;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Saleperson getSaleperson(){
        return saleperson;
    }
    public List<TradeInVehicle> getTradeInVehicles(){
        return tradeInVehicles;
    }
    public List<SaleInvoice> getSaleInvoices() {
        return this.saleInvoices;
    }
    //setter methods
    public void setSerialNumber(String serialNumber){
        this.SerialNumber = serialNumber;
    }
    public void setName(String name){
        this.Name = name;
    }
    public void setModel(String model){
        this.Model = model;
    }
    public void setYear(int year){
        this.Year = year;
    }
    public void setManufacturer(String manufacturer){
        this.Manufacturer = manufacturer;
    }
    public void setBaseCost(double baseCost){
        this.BaseCost = baseCost;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setSaleperson(Saleperson saleperson){
        this.saleperson = saleperson;
    }
    // add a trade in vehicle to the list of trade in vehicles
    public void addTradeInVehicle(TradeInVehicle tradeInVehicle){
        if(tradeInVehicles == null) {
            tradeInVehicles = new ArrayList<TradeInVehicle>();
        }
        this.tradeInVehicles.add(tradeInVehicle);
    }
    // add a sale invoice to the list of sale invoices
    public void addSaleInvoice(SaleInvoice saleInvoice){
        if(saleInvoices == null) {
            saleInvoices = new ArrayList<SaleInvoice>();
        }
        this.saleInvoices.add(saleInvoice);
    }
    // remove a trade in vehicle from the list of trade in vehicles
    public void removeTradeInVehicle(TradeInVehicle tradeInVehicle){
        this.tradeInVehicles.remove(tradeInVehicle);
    }
    // remove a sale invoice from the list of sale invoices
    public void removeSaleInvoice(SaleInvoice saleInvoice){
        this.saleInvoices.remove(saleInvoice);
    }
    // get the total trade in allowance for a vehicle
    public double getTotalTradeInAllowance(){
        double total = 0;
        for(TradeInVehicle tradeInVehicle : tradeInVehicles){
            total += tradeInVehicle.getTradeInAllowance();
        }
        return total;
    }
    // ger the total sale price for a vehicle
    public double getTotalSalePrice(){
        double total = 0;
        for(SaleInvoice saleInvoice : saleInvoices){
            total += saleInvoice.getFinalPrice();
        }
        return total;
    }
}