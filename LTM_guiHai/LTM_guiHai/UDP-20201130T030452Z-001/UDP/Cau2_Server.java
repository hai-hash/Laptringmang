/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author traan
 */
public class Cau2_Server {
    public static DatagramPacket receivePacket = null;
    public static void main(String[] args) throws Exception{
        String input;
        
        
        DatagramSocket server = new DatagramSocket(1108);
        
        System.out.println("Server === \n");
        
        while(true) {
            input = receive(server);
            System.out.println(input);
            String question = "B15DCAT038;LaP tRINH mang 2018";
            send(question, server);
            String output = receive(server);
            System.out.println(output);
        }
    }
    
    public static void send(String str, DatagramSocket server) throws Exception{
        if(server != null) {
            byte[] sendData = new byte[1024];

            sendData = str.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());

            server.send(sendPacket);
        }
    }
    
    public static String receive(DatagramSocket server) throws Exception{
        if(server != null) {
            byte[] receiveData = new byte[1024];

            receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            server.receive(receivePacket);
            return new String(receivePacket.getData()).trim();
        }
        return null;
    }
}
