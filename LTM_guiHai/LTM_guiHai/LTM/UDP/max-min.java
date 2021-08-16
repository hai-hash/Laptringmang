/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max_min;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author User
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        int port = 1111;
        DatagramSocket client = new DatagramSocket();
        String msv = ";B17DCCNxxx;931";
        DatagramPacket gui, nhan , kq;
        byte[] guiMSV = msv.getBytes();
        gui = new DatagramPacket(guiMSV, guiMSV.length, InetAddress.getByName("localhost"), port);
        client.send(gui);
        
        byte[] nhanChuoi = new byte[1024];
        nhan = new DatagramPacket(nhanChuoi, nhanChuoi.length);
        client.receive(nhan);
        
        String chuoiNhan = new String(nhan.getData()).trim();
        String[] arr = chuoiNhan.split(";");
        String requsetID = arr[0].trim();
        String chuoiSo = arr[1].trim();
        String[] mangSo = chuoiSo.split(",");
        
        List<Integer> listInt = new ArrayList<Integer>();
        for (int i = 0; i < mangSo.length; i++) {
            listInt.add(Integer.parseInt(mangSo[i]));
        }
        
        Collections.sort(listInt);
        
        String KQ = requsetID + ";" + listInt.get(listInt.size()-1) + ";" + listInt.get(0);
        
        byte[] guiKQ = KQ.getBytes();
        kq = new DatagramPacket(guiKQ, guiKQ.length, InetAddress.getByName("localhost"), port);
        client.send(kq);
        client.close();
        
    }
}
