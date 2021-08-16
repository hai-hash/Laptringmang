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
 * @author User
 */
public class Client3 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        DatagramPacket goiGui , goiNhan , goiGui2;
        int port = 1111;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        
        String msv = "B17DCCN342";
        byte[] guimsv = msv.getBytes();
        goiGui = new DatagramPacket(guimsv, guimsv.length, inetAddress, port);
        client.send(goiGui);
        
        byte[] nhan2Chuoi = new byte[1024];
        goiNhan = new DatagramPacket(nhan2Chuoi, nhan2Chuoi.length);
        client.receive(goiNhan);
        String duLieu = new String(goiNhan.getData()).trim();
        System.out.println(duLieu);
        
        String[] arr = duLieu.split(";");
        String kq = arr[0] + " " ;
        
        String[] str1 = arr[1].split("");
        String chuoiXL = "";
        for (int i = 0; i < str1.length; i++) {
            if(kiTuThuong(str1[i])){
                chuoiXL += str1[i];
            }
        }
        chuoiXL = chuoiXL.replaceAll(arr[2], "");
        byte[] guiKQ = chuoiXL.getBytes();
        goiGui2 = new DatagramPacket(guiKQ, guiKQ.length, inetAddress, port);
        client.send(goiGui2);
        client.close();
    }
    public static boolean kiTuThuong(String s){
        if(s.matches("[.*a-zA-Z0-9.*]")){
            return true;
        }
        return false;
    }
}
