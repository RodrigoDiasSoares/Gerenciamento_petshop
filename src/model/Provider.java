package model;

import java.util.ArrayList;


/**
 * @author Rodrigo Dias Soares
 */
public class Provider {
    private String name;
    private String email;
    private String telephone;
    private ArrayList<Product> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }
    
    
}
