/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Student implements  Serializable{
     private static final long serialVersionUID = 20151107;
     private int id;
     private String code  ;
     private  float  jpa ;
     private String jpaLetter;

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

    public float getJpa() {
        return jpa;
    }

    public void setJpa(float jpa) {
        this.jpa = jpa;
    }

    public String getJpaLetter() {
        return jpaLetter;
    }

    public void setJpaLetter(String jpaLetter) {
        this.jpaLetter = jpaLetter;
    }

    public Student(int id, String code, float jpa, String jpaLetter) {
        this.id = id;
        this.code = code;
        this.jpa = jpa;
        this.jpaLetter = jpaLetter;
    }

    public Student(String code) {
        this.code = code ;
    }
     
}
