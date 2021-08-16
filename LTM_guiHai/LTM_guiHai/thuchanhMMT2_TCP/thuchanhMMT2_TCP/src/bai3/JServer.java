/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1108);
            System.out.println("Server is starting ...");
            while (true) {                
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                Student student = (Student)objectInputStream.readObject();
                 System.out.println("Server is startingsss ...");
                System.out.println("mã sinh viên của bạn là :"+student.getCode());
                objectOutputStream.writeObject(new Student(1,student.getCode(), (float) 3.2, ""));
                Student kq = (Student)objectInputStream.readObject();
                System.out.println("thoogn tin  loại học lực của sinh viên là "+ kq.getJpaLetter());
                objectInputStream.close();
                objectOutputStream.close();
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
