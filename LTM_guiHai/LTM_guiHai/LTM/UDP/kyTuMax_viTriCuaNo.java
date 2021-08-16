/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kyTuMax_viTriCuaNo;

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
        InetAddress inetAddress = InetAddress.getByName("localhost");
        DatagramSocket client = new DatagramSocket();
        DatagramPacket goiGui, goiNhan , goiGui2;
        
        String msv = ";B17DCCNxxx;721";
        byte[] guiMsv = msv.getBytes();
        goiGui = new DatagramPacket(guiMsv, guiMsv.length, inetAddress, port);
        client.send(goiGui);
        
        byte[] nhanChuoi = new byte[1024];
        goiNhan = new DatagramPacket(nhanChuoi, nhanChuoi.length, inetAddress, port);
        client.receive(goiNhan); //nhận dữ liệu vòa trong -> goiNhan
        
        String chuoiNhan = new String(goiNhan.getData()).trim();
        System.out.println(chuoiNhan);
        String[] arr = chuoiNhan.split(";");
        String resID = arr[0].trim();
        String chuoiDaXL = xuLy(arr[1]);
        
        byte[] guiKQ = chuoiDaXL.getBytes();
        goiGui2 = new DatagramPacket(guiKQ, guiKQ.length, inetAddress, port);
        client.send(goiGui2);
        client.close();
    }
    public static String xuLy(String s){
        s = s.trim();
        String[] arr = s.split("");
        int[] check = new int[arr.length];
        String kiTuMax = "";
        int max = 0;
        
        for (int i = 0; i < arr.length; i++) {
           
                    check[i] = 1;
                    int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j]) == 0){
                    count++;
                    check[j] = 1;
                
                }
                if(count > max){
                    max = count;
                    kiTuMax = arr[i];
                }
            }
            
        }
        
        String kq = kiTuMax + ":";
        for (int i = 0; i < arr.length; i++) {
            if(kiTuMax.compareTo(arr[i]) == 0){
                kq += (i + 1) + ",";
            }
            
        }
        return kq;
    }
}