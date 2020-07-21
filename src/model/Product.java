package model;

/**
 * @author Rodrigo Dias Soares
 */
public class Product {
    
    private int productCode;
    private String description;
    private String price;
    private int quantity;

    public int getNumber() {
        return productCode;
    }

    public void setNumber(int number) {
        this.productCode = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
