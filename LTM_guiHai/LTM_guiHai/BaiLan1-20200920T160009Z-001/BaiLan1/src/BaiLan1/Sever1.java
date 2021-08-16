/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiLan1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author Duc
 */
public class Sever1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try ( // TODO code application logic here
            ServerSocket serverSocket = new ServerSocket(3333)) {
            Socket socket = serverSocket.accept();
//            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("nhap a, b");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            out.writeInt(a);
            out.writeInt(b);
            out.flush();
//            String str = in.readUTF();
//            int x = in.readInt();
//            System.out.println("ket qua" + str);
//            System.out.println("UCLN" + x);
//            System.out.println("BCNN"  + x);
//            in.close();
            out.close();
        }catch (Exception e){
            System.out.println("sai");
        }
       
                 
    }

    
}
