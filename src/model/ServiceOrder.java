package model;

import java.util.Date;

/**
 * @author rds_d
 */
public class ServiceOrder {
    
    private int serviceOrderNumber;
    private String serviceRendered;
    private String note;
    private Date date;
    private double price;
    private int discount;

    public ServiceOrder() {
    }
    
    public ServiceOrder(String serviceRendered, String note, Date date, double price, int discount) {
        this.serviceRendered = serviceRendered;
        this.note = note;
        this.date = date;
        this.price = price;
        this.discount = discount;
    }

    public int getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(int serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber;
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
    
    
}
