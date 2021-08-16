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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PESI
 */
public class demoClient {
    int port;
    DatagramSocket client;
    DatagramPacket resquest,respone;
    public demoClient(){
        try {
            port = 1108;
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(demoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(String str){
        try {
            byte[] res = str.getBytes();
            resquest = new DatagramPacket(res, res.length,InetAddress.getByName("localhost"),port);
            client.send(resquest);
        } catch (IOException ex) {
            Logger.getLogger(demoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String receive(){
        try {
            byte[] res = new byte[1024];
            respone = new DatagramPacket(res, res.length);
            client.receive(respone);
            String handle =  new String (respone.getData()).trim();
            System.out.println(handle);
            return handle;
        } catch (IOException ex) {
            Logger.getLogger(demoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    public static void main(String[] args) {
        demoClient client = new demoClient();
        client.send(";B17DCCN048");
        String request_data = client.receive();
        String[] arr = request_data.split(";");
        
        String arr1 = arr[0];
        String arr2 = arr[1];
        
        
//        String[] word = arr2.split(" ");
//        String result = arr1 +";";
//        for (int i = 0; i < word.length; i++) {
//            word[i] = String.valueOf(Character.toUpperCase(word[i].charAt(0)) + word[i].substring(1));
//            result = result +word[i] + " ";
//        }
//        result = result.trim();
//        client.send(result);



        List<Integer> list = new ArrayList<Integer>();
        String[] list_data = arr2.split(",");
        for (int i = 0; i < list_data.length; i++) {
            list.add(Integer.parseInt(list_data[i]));
        }
        Collections.sort(list);
        String result = arr1+";"+list.get(0)+","+list.get(list.size()-1);
        client.send(result);
        
    }
}
