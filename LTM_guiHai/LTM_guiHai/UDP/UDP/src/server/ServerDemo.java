/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PESI
 */
public class ServerDemo {
    int port;
    DatagramSocket server;
    DatagramPacket request,respone;
    public ServerDemo(){
        try {
            port = 1108;
            server = new DatagramSocket(port);
        } catch (SocketException ex) {
            Logger.getLogger(ServerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listennning(){
        System.out.println("SERVER STARTING...");
        while(true){
            try {
                byte[] req = new byte[1024];
                request = new DatagramPacket(req, req.length);
                server.receive(request);
                
                System.out.println(new String(request.getData()).trim());
                
                String data = "101;15675,656499,123486,1545613,216448,151641,31564651,231864,13215646,12351654,3213184,3131548,4315465,315646";
                byte[] res = data.getBytes();
                respone = new DatagramPacket(res, res.length, request.getAddress(), request.getPort());
                server.send(respone);
                
                byte[] result = new byte[1024];
                DatagramPacket kq = new DatagramPacket(result,result.length);
                server.receive(kq);
                System.out.println(new String(kq.getData()).trim());
                
                
            } catch (IOException ex) {
                Logger.getLogger(ServerDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public static void main(String[] args) {
        ServerDemo server = new ServerDemo();
        server.listennning();
    }
    
}
