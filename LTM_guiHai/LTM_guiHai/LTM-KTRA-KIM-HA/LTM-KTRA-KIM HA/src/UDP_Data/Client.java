/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_Data;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author PESI
 */
public class Client {
    DatagramSocket client;
    DatagramPacket request,response;
    public Client() throws SocketException{
        client = new DatagramSocket();
        
    }  
    public void Send(String str) throws UnknownHostException, IOException{
        byte[] s = str.getBytes();
        request = new DatagramPacket(s, s.length,InetAddress.getByName("localhost"), 1111);
        client.send(request);
        
    }
    public String Receive() throws IOException{
        byte[] s = new byte[1024];
        response = new DatagramPacket(s, s.length);
        client.receive(response);
        return new String(response.getData()).trim();
    }
    public void close(){
        if(client != null){
            client.close();
        }
    }
    public static void main(String[] args) throws SocketException, IOException {
        Client client = new Client();
        client.Send(";B17DCCN048;101");
        
        String str = client.Receive();
        System.out.println(str);
        String[] arr = str.split(";");
        
        String result = arr[0] +";";
        char[] s = (arr[1].trim()).toCharArray();
        int n = Integer.parseInt(arr[2]);
        
        for (int i = 0; i < s.length; i++) {
            if(s[i] >= 'a' && s[i] <= 'z'){
                s[i] = (char) ('a' + (s[i] + (26 - n) - 'a')%26);
            }
            else if(s[i] >= 'A' && s[i] <= 'Z'){
                s[i] = (char) ('A' + (s[i] + (26 - n) - 'A')%26);
            }
            result = result + String.valueOf(s[i]);
        }
        
        System.out.println(result);
        client.Send(result);
        
        client.close();
        
        
    }
        
}
