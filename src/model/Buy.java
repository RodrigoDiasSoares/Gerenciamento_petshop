package model;

import java.util.ArrayList;
import java.sql.Date;

/**
 * @author rds_d
 */
public class Buy {
    
    private int id;
    private String serviceRendered;
    private String note;
    private Date date;
    private double price;
    private int discount;
    private Client client;
    private ArrayList<Product> list;
    
    public Buy() {
    }
    
    public Buy(String serviceRendered, String note, Date date, double price, int discount) {
        this.serviceRendered = serviceRendered;
        this.note = note;
        this.date = date;
        this.price = price;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setClient(int clientId) {
        this.client.setId(clientId);
    }

    public ArrayList<Product> getProduct() {
        return list;
    }

    public void setProduct(ArrayList<Product> list) {
        this.list = list;
    }
    
    
}
