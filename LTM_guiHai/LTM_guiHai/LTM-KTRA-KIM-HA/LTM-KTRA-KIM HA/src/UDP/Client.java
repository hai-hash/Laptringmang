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
import java.net.UnknownHostException;

/**
 *
 * @author PESI
 */
public class Client {
    DatagramSocket client;
    DatagramPacket request,repsonse;
    public Client() throws SocketException{
        client = new DatagramSocket();
    }
    public void Send(String str) throws UnknownHostException, IOException{
        byte[] s = str.getBytes();
        request = new DatagramPacket(s, s.length, InetAddress.getByName("localhost"), 1111);
        client.send(request);
    }
    public String Receive() throws IOException{
        byte[] s = new byte[1024];
        repsonse = new DatagramPacket(s, s.length);
        client.receive(repsonse);
        return new String(repsonse.getData()).trim();
    }
    public void close(){
        if(client != null){
            client.close();
        }
    }
    public static boolean check(char s){
        if(('a' <= s && s <= 'z') || ('A' <= s && s <= 'Z') || ('0' <= s && s <= '9')){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) throws SocketException, IOException {
        Client client = new Client();
        client.Send(";B17DCCN048;936");
        
        String str = client.Receive().trim();
        System.out.println(str);
        String[] arr = str.split(";");
        
        String result = arr[0].trim()+ ";";
        char[] str1 = arr[1].toCharArray();//mấu chốt
        char[] str2 = arr[2].toCharArray();
        
        String c1 = "";
        for (int i = 0; i < str1.length; i++) {
            if(check(str1[i])){
                c1 = c1 + String.valueOf(str1[i]);
            }
        }
        System.out.println(c1);
        
        for (int i = 0; i < str2.length; i++) {
            c1 = c1.replaceAll(String.valueOf(str2[i]), "");
        }
        client.Send(c1);
        System.out.println(c1);
        
        client.close();
        
        
    }
}
