/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6;

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
            Socket client = new Socket("192.168.1.100", 1109);
            System.out.println(client);
            
            //gui du lieu
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            bai3.Student s = new bai3.Student("B15DCCN001");
            out.writeObject(s);
            
            //doc du lieu
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            Student respone = (Student)in.readObject();
            
            String name = respone.getName();
            
            name = name.toLowerCase();
            String temp[] = name.split("\\s+");
            String str = "";
            for (int i = 0; i < temp.length; i++) {
                str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
                if (i < temp.length - 1)
                {
                    str += " ";
                }
            }
            
            System.out.println("name: " + str);
            
            String email = "@ptit.edu.vn";
            String[] temp1 = str.split("\\s+");
            String firstEmail = temp1[temp1.length - 1].toLowerCase();
            for(int i = 0; i < temp1.length - 1; i++) {
                firstEmail += String.valueOf(temp[i].charAt(0)).toLowerCase();
            }
            email += firstEmail;
            
        } catch (Exception e) {
        }
    }
}
