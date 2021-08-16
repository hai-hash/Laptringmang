/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuoiInHoa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author User
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        int port = 1111;
        DatagramSocket client = new DatagramSocket();
        String msv = ";B17DCCNxxx;911";
        byte[] guiMSV = msv.getBytes();
        DatagramPacket gui,nhan,ketqua;
        gui = new DatagramPacket(guiMSV, guiMSV.length, InetAddress.getByName("localhost"), port);
        client.send(gui);
        
        byte[] nhanChuoi = new byte[1024];
        nhan = new DatagramPacket(nhanChuoi, nhanChuoi.length);
        client.receive(nhan);
        
        String chuoiXL = new String(nhan.getData()).trim();
        System.out.println(chuoiXL);
        
        
        String chuoiKQ = chuoiInHoa(chuoiXL);
        System.out.println(chuoiKQ);
        byte[] KQ = chuoiKQ.getBytes();
        ketqua = new DatagramPacket(KQ, KQ.length, InetAddress.getByName("localhost"), port);
        client.send(ketqua);
        
        client.close();
        
//        client.close();
    }
    
    public static String chuoiInHoa(String s){
        String[] arr = s.split(";");
        String req = arr[0].trim();
        String[] chuoiXL = arr[1].trim().split("\\s+");
        String KQ = req + ";";
        for (int i = 0; i < chuoiXL.length; i++) {
            String temp = chuoiXL[i].substring(0, 1).toUpperCase() + chuoiXL[i].substring(1).toLowerCase();
            KQ += temp + " "; 
        }
        return KQ.trim();
        
    }
}
