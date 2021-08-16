/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PESI
 */
public class UDPClient {
    DatagramSocket client;
    int port;
    DatagramPacket request,respone;
    public UDPClient(){
        try {
            port = 1107;
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(String str){
        try {
            byte[] req = str.getBytes();
            request = new DatagramPacket(req, req.length,InetAddress.getByName("192.168.137.192"), port);
            client.send(request);
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void receive(){
        try {
            byte[] res = new byte[1024];
            respone = new DatagramPacket(res, res.length);
            client.receive(respone);
            System.out.println("respone string: "+new String(respone.getData()).trim());
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        client.send("TEST THOI MA");
        client.receive();
    }
}
