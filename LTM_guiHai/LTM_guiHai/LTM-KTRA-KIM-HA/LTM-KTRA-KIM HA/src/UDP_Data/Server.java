/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_Data;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author PESI
 */
public class Server {
    DatagramSocket server;
    DatagramPacket request,response;
    public Server() throws SocketException{
        server = new DatagramSocket(1111);
    }
    public void listenning() throws IOException{
        System.out.println("SERVER IS RUNNING");
        while(true){
            byte[] s1 = new byte[1024];
            request = new DatagramPacket(s1, s1.length);
            server.receive(request);
            
            
            System.out.println(new String(request.getData()).trim());
            
            String str = "101;abcdetdasABDA;3";
            byte[] s2 = str.getBytes();
            response = new DatagramPacket(s2, s2.length, request.getAddress(), request.getPort());
            server.send(response);

            byte[] kq = new byte[1024];
            DatagramPacket result = new DatagramPacket(kq, kq.length);
            server.receive(result);
            
            
            System.out.println(new String(result.getData()).trim());
            
            
        }
        
    }
    public static void main(String[] args) throws SocketException, IOException {
        Server server = new Server();
        server.listenning();
    }
}
