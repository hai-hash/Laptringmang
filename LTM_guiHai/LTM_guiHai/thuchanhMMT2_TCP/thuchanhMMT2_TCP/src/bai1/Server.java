/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket  = new ServerSocket(1107) ;
        while (true) {            
            Socket socket = serverSocket.accept();
            System.out.println("server is starting ...");
            DataInputStream dataInputStream =  new DataInputStream(socket.getInputStream());
            
            System.out.println("chuỗi nhận được từ client là "+dataInputStream.readUTF());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("800;2,4");
            System.out.println("chuoi nhan kêt quả nhân được từ clienen là "+dataInputStream.readUTF());
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            
        }
    }
}
