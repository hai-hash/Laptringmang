/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;

/**
 *
 * @author PESI
 */
public class Product implements Serializable{
    private int id;
    private String code;
    private String name;
    private float ImportPrice;
    private float createdUser;
    //private static final long serialVersionUID = 20151107;
    
    public Product(String code){
        this.code = code;
    }
    public Product(int id, String code, String name, float ImportPrice, float createdUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.ImportPrice = ImportPrice;
        this.createdUser = createdUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(float ImportPrice) {
        this.ImportPrice = ImportPrice;
    }

    public float getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(float createdUser) {
        this.createdUser = createdUser;
    }
    
    
}

