/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author traan
 */
public class Cau1 {
    public static void main(String[] args) throws Exception{
        System.out.println("Client === \n");
        
        DatagramSocket client = new DatagramSocket();
        send(";B15DCAT038", client);
        
        String question = receive(client);
        
        String[] a1 = question.split(";", 2);
        String result = a1[0] + ";" + MaxStr(a1[1]) + "," + MinStr(a1[1]);
        
        System.out.println(result);
        send(result, client);
    }
    
    public static int MaxStr(String str) 
    { 
        int num = 0, res = 0; 

        for (int i = 0; i< str.length(); i++) 
        { 
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') 
                num = num * 10 + (str.charAt(i)-'0'); 
            
            else
            { 
                res = max(res, num); 

                num = 0; 
            } 
        } 

        return max(res, num); 
    } 
    
    public static int MinStr(String str) 
    { 
        int num = 0, res = 0; 
        boolean ok = false;

        for (int i = 0; i< str.length(); i++) 
        { 
            
            
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') 
                num = num * 10 + (str.charAt(i)-'0'); 

            else if(str.charAt(i) == '-' && i != str.length()-1 
                    && str.charAt(i+1) >= '0' && str.charAt(i+1) <= '9' ) {
                ok = true;
            }
            
            else
            { 
                if(ok)
                    res = min(res, -num); 
                else
                    res = min(res, num);
                ok = false;

                num = 0; 
            } 
        } 
        return min(res, num); 
    } 
    
    public static void send(String str, DatagramSocket client) throws Exception{
        if(client != null) {
            byte[] sendData = new byte[1024];

            InetAddress inetAddress = InetAddress.getByName("localhost");

            sendData = str.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, inetAddress, 1107);

            client.send(sendPacket);
        }
    }
    
    public static String receive(DatagramSocket client) throws Exception{
        if(client != null) {
            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            client.receive(receivePacket);
            return new String(receivePacket.getData()).trim();
        }
        return null;
    }
}
