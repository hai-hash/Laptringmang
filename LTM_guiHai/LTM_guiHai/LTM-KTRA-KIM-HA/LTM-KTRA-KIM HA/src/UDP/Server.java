/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author PESI
 */
public class Server {
    DatagramPacket request,response;
    DatagramSocket server;
    public Server() throws SocketException{
        server = new DatagramSocket(1111);
        
        
    }
    public void listenning() throws IOException{
        System.out.println("SERVER IS RUNNING");
        while(true){
            byte[] req = new byte[1024];
            request = new DatagramPacket(req, req.length);
            server.receive(request);
            
            
            System.out.println(new String(request.getData()).trim());
            
            String str = "101;AB%!#%CCabccA;abcc";
            byte[] res = str.getBytes();
            response = new DatagramPacket(res, res.length,request.getAddress(),request.getPort());
            server.send(response);
            
            byte[] kq = new byte[1024];
            DatagramPacket result = new DatagramPacket(kq, kq.length);
            server.receive(result);
            
            System.out.println(new String(result.getData()).trim());
            
        }
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.listenning();
    }
}
