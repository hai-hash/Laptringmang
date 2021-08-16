/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",1107);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(";B15DCCN001;100");
            String chuoinhantuServer = dataInputStream.readUTF();
            dataOutputStream.writeUTF(result(chuoinhantuServer));
             dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    public static String result(String chuoi){
        String result = "";
        String mangString[] = chuoi.split(";");
        String mangso[] = mangString[1].split(",");
        result+=mangString[0]+";"+String.valueOf(uscln(Integer.parseInt(mangso[0]),Integer.parseInt(mangso[1])))+","+
                String.valueOf(bscnn(Integer.parseInt(mangso[0]),Integer.parseInt(mangso[1])))+","+
                String.valueOf(Integer.parseInt(mangso[0])+Integer.parseInt(mangso[1]))+","+
                 String.valueOf(Integer.parseInt(mangso[0])*Integer.parseInt(mangso[1]));
     return  result ;
    }
    public static int uscln(int a , int b){
        if(b==0) return  a ;
        return uscln(b,a%b);
    }
    public static int bscnn(int a , int b){
        return (a*b)/uscln(a, b);
    }
}
