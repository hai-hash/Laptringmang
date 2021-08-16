/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JClient {

    public static void main(String[] args)  {
        try {
            Socket socket = new Socket("localhost", 1108);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(new Student("B17dccn229"));
            Student studentFromServer = (Student) objectInputStream.readObject();
         
            studentFromServer.setJpaLetter(changeJpaToJpaLetter(studentFromServer.getJpa()));
            objectOutputStream.writeObject(studentFromServer);
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        } catch (Exception ex) {
            Logger.getLogger(JClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String changeJpaToJpaLetter(float jpa) {
        String jpaLetter = "";
        if (jpa >= 0 && jpa < 1.0) {
            jpaLetter += "F";
        } else if (jpa >= 1.0 && jpa < 2.0) {
            jpaLetter += "D";
        } else if (jpa >= 2.0 && jpa < 3.0) {
            jpaLetter += "C";
        } else if (jpa >= 3.0 && jpa < 3.7) {
            jpaLetter += "B";
        } else {
            jpaLetter += "A";
        }
        return jpaLetter;
    }
}
