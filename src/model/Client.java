package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Rodrigo Dias Soares
 */
public class Client extends Person {

    private String email;
    private ArrayList<Buy> serviceOrder;
    private Pet pet;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Buy> getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ArrayList<Buy> serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}