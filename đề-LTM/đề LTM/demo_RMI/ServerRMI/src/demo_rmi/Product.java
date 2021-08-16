/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_rmi;

import java.io.Serializable;

/**
 *
 * @author Nguyen Hoa
 */
public class Product implements Serializable{

    private int id;
    private String code;
    private String name;
    private float inportPrice;
    private float ExportPrice;
    private String createdUser;
    private static final long serialVersionUID = 12;
    
    public Product() {
    }

    public Product(int id, String code, String name, float inportPrice, float ExportPrice, String createdUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.inportPrice = inportPrice;
        this.ExportPrice = ExportPrice;
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

    public float getInportPrice() {
        return inportPrice;
    }

    public void setInportPrice(float inportPrice) {
        this.inportPrice = inportPrice;
    }

    public float getExportPrice() {
        return ExportPrice;
    }

    public void setExportPrice(float ExportPrice) {
        this.ExportPrice = ExportPrice;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    
    
}
