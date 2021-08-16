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
public class Client3 {
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
        String[] arr = chuoiNhan.split(";");
        String resID = arr[0];
        char[] s = arr[1].toCharArray();
        int n = Integer.parseInt(arr[2]);
        
        for (int i = 0; i < s.length; i++) {
            if(s[i] >= 'a' && s[i] <= 'z'){
                s[i] = (char) ('a' + ( s[i] + ( 26 - n ) - 'a')%26);
            }
            
            if(s[i] >= 'A' && s[i] <= 'Z'){
                s[i] = (char) ('A' + ( s[i] + ( 26 - n ) - 'A' )%26);
            }
            
        }
        String maHoa = String.valueOf(s);
        String kq = resID + ";" + maHoa;
        byte[] guikq = kq.trim().getBytes();
        goiGui2 = new DatagramPacket(guikq, guikq.length, inetAddress, port);
        client.send(goiGui2);
        client.close();
    }
}
