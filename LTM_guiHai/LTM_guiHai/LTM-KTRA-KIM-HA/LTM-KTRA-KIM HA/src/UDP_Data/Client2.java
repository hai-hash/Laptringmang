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
 * @author User
 */
public class Client2 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        int port = 1111;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        DatagramPacket goiGui, goiNhan, goiGui2;
        
        String msv = ";B17DCCN324;931";
        byte[] guimsv = msv.getBytes();
        goiGui = new DatagramPacket(guimsv, guimsv.length, inetAddress, port);
        client.send(goiGui);
        
        byte[] nhanChuoi = new byte[1024];
        goiNhan = new DatagramPacket(nhanChuoi, nhanChuoi.length);
        client.receive(goiNhan);
        
        String chuoiNhan = new String(goiNhan.getData()).trim();
        System.out.println(chuoiNhan);
        String[] arr = chuoiNhan.trim().split(";");
        String kq = arr[0] + ";" ;
        char[] chuoiMa = arr[1].toCharArray(); // chuyển sang mảng char để for
        int n = Integer.parseInt(arr[2]);
        for (int i = 0; i < chuoiMa.length; i++) {
            if(chuoiMa[i] >= 'a' && chuoiMa[i] <= 'z'){
                chuoiMa[i] = (char) ('a' + (chuoiMa[i] + (26 - n) - 'a') % 26);
            }
            if(chuoiMa[i] >= 'A' && chuoiMa[i] <= 'Z'){
                chuoiMa[i] = (char) ('A' + (chuoiMa[i] + ( 26 - n ) - 'A') % 26);
            }
        }
        kq += String.valueOf(chuoiMa);
        byte[] guikq = kq.getBytes();
        goiGui2 = new DatagramPacket(guikq, guikq.length, inetAddress, port);
        client.send(goiGui2);
        client.close();
        
    }
}
