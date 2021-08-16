/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import handle.Handle;
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
public class UDPServer {
    DatagramSocket server;
    int port,buffsize;
    DatagramPacket request,response;
    public UDPServer(){
        try {
            port = 1107;
            buffsize = 1024;
            server = new DatagramSocket(port);
            
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void listenning(){
        System.out.println("SERVER IS RUNNING...");
        while(true){
            try {
                byte[] req = new byte[buffsize];
                request = new DatagramPacket(req, buffsize);
                server.receive(request);
                
                String strRequest = new String(request.getData()).trim();
                System.out.println("REQUEST STRING: "+strRequest);
                
                String strRespone = Handle.reverse(strRequest);
                byte[] res = strRespone.getBytes();
                response = new DatagramPacket(res, res.length,request.getAddress(), request.getPort());
                server.send(response);
                System.out.println("respone string: "+ new String(response.getData()));
                
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    public void close(){
        if(server!=null){
            server.close();
        }
    }
    public static void main(String[] args) {
        UDPServer server = new UDPServer();
        server.listenning();
    }
}
