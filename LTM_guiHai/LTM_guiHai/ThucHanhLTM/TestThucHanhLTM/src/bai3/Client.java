/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            //khoi tao
            Socket client = new Socket("192.168.1.100", 1107);
            System.out.println(client);
            
            //gui du lieu
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            Student s = new Student("B15DCCN001");
            out.writeObject(s);
            
            //doc du lieu
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            Student respone = (Student)in.readObject();
            
            float gpa = respone.getGpa();
            String gpaLetter = "";
            if((gpa <= 4) && (gpa > 3.7)) gpaLetter += "A";
            else if((gpa <= 3.7) && (gpa > 3)) gpaLetter += "B";
            else if((gpa <= 3) && (gpa > 2)) gpaLetter += "C";
            else if((gpa <= 2) && (gpa > 1)) gpaLetter += "D";
            else if((gpa <= 1) && (gpa >= 0)) gpaLetter += "F";
            respone.setGpaLetter(gpaLetter);
            
            out.writeObject(respone);
            
            client.close();
        } catch (Exception e) {
        }
    }
}
