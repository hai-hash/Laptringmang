/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class SServer {
     public static void main(String[] args) throws IOException {
        ServerSocket serverSocket  = new ServerSocket(1108) ;
        while (true) {            
            Socket socket = serverSocket.accept();
            System.out.println("server is starting ...");
            DataInputStream dataInputStream =  new DataInputStream(socket.getInputStream());
            
            System.out.println("chuỗi nhận được từ client là "+dataInputStream.readUTF());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("800;abcHieeulamâ1224328*^&!Ơ}");
            System.out.println("chuoi nhan kêt quả nhân được từ clienen là "+dataInputStream.readUTF());
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            
        }
    }
}
