package model;

/**
 * @author Rodrigo Dias Soares
 */
public class Product {
    
    private int id;
    private String description;
    private double price;
    private int quantity;
    private Provider provider;

    public Product() {
    }

    
    public Product(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        
    }
    
    
    public int getNumber() {
        return id;
    }

    public void setNumber(int number) {
        this.id = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
}
