package Invoice;
public class DealerInstalledOption {
    private String OptionCode;
    private String Description;
    private String Price;
    private SaleInvoice saleInvoice; // a dealer installed option can have one sale invoice
    // Constructor
    public DealerInstalledOption(String optionCode, String description, String price) {
        this.OptionCode = optionCode;
        this.Description = description;
        this.Price = price;
    }
    // getter methods
    public String getOptionCode() {
        return OptionCode;
    }
    public String getDescription() {
        return Description;
    }
    public String getPrice() {
        return Price;
    }
    public SaleInvoice getSaleInvoice() {
        return saleInvoice;
    }
    // setter methods
    public void setOptionCode(String optionCode) {
        this.OptionCode = optionCode;
    }
    public void setDescription(String description) {
        this.Description = description;
    }
    public void setPrice(String price) {
        this.Price = price;
    }
    public void setSaleInvoice(SaleInvoice saleInvoice) {
        this.saleInvoice = saleInvoice;
    }
    //returnDealerInstalledOption method
    public String returnDealerInstalledOption() {
        return "Option Code: " + this.OptionCode + ", Description: " + this.Description + ", Price: " + this.Price;
    }
    //returnDealerInstalledOptionPrice method
    public double returnDealerInstalledOptionPrice() {
        return Double.parseDouble(this.Price);
    }
}