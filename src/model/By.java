package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author rds_d
 */
public class By {
    
    private int byId;
    private String serviceRendered;
    private String note;
    private Date date;
    private double price;
    private int discount;
    private Client client;
    private ArrayList<Product> list;
    
    public By() {
    }
    
    public By(String serviceRendered, String note, Date date, double price, int discount) {
        this.serviceRendered = serviceRendered;
        this.note = note;
        this.date = date;
        this.price = price;
        this.discount = discount;
    }

    public int getById() {
        return byId;
    }

    public void setById(int byId) {
        this.byId = byId;
    }

    public String getServiceRendered() {
        return serviceRendered;
    }

    public void setServiceRendered(String serviceRendered) {
        this.serviceRendered = serviceRendered;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Product> getProduct() {
        return list;
    }

    public void setProduct(ArrayList<Product> list) {
        this.list = list;
    }
    
    
}
