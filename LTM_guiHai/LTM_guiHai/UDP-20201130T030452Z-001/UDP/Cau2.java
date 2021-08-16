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

/**
 *
 * @author traan
 */
public class Cau2 {
    public static void main(String[] args) throws Exception{
        System.out.println("Client === \n");
        
        DatagramSocket client = new DatagramSocket();
        send(";B15DCAT038", client);
        
        String question = receive(client);
        
        String[] a1 = question.split(";", 2);
        
        String result = a1[1].toLowerCase();
        
        String result2 = "";
        
        for (int i = 0; i < result.length(); i++) {
            if(i == 0 || (result.charAt(i-1) == ' ' && result.charAt(i) != ' ')) {
                char s = Character.toUpperCase(result.charAt(i));
                result2 += s;
            }
            else
                result2 += result.charAt(i);
        }
        
        System.out.println(result2);
        send(result2, client);
    }
    
    public static void send(String str, DatagramSocket client) throws Exception{
        if(client != null) {
            byte[] sendData = new byte[1024];

            InetAddress inetAddress = InetAddress.getByName("localhost");

            sendData = str.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, inetAddress, 1108);

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
