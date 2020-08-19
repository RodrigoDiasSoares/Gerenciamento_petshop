package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Rodrigo Dias Soares
 */
public class Client extends Person {

    private String email;
    private ArrayList<Buy> serviceOrder;
    private ArrayList<Pet> listPet;

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

    public ArrayList<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(ArrayList<Pet> listPet) {
        this.listPet = listPet;
    }
}