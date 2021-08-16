/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soConThieu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        int port = 1111;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        DatagramSocket client = new DatagramSocket();
        DatagramPacket gui, nhan , gui2 ;
        
        String msv =";B17DCCNxxx;802";
        byte[] guiMsv = msv.getBytes();
        gui = new DatagramPacket(guiMsv, guiMsv.length, inetAddress, port);
        client.send(gui);
        
        byte[] nhanChuoi = new byte[1024];
        nhan = new DatagramPacket(nhanChuoi, nhanChuoi.length);
        client.receive(nhan);
        
        String chuoiNhan = new String(nhan.getData()).trim();
        String[] arr = chuoiNhan.split(";");
        String resID = arr[0].trim();
        String chuoiDaXL = xuLy(Integer.parseInt(arr[1]),arr[2]);
        
        String res = resID + ";" + chuoiDaXL;
        byte[] guiKQ = res.getBytes();
        gui2 = new DatagramPacket(guiKQ, guiKQ.length, inetAddress, port);
        client.send(gui2);
        client.close();
    }
    
    public static String xuLy(int n,String s){
        s = s.trim();
      
//        arr[1] = arr[1].trim();
        String[] chuoiSo = s.split(",");
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < chuoiSo.length; i++) {
            listInt.add(Integer.parseInt(chuoiSo[i]));
            
        }
        
        String KQ = "";
        for(int i = 1; i <= n ; i++){
            boolean check = true;
            for (Integer integer : listInt) {
                if(i == integer)
                    check = false;
            }
            if(check)
                KQ += i + ",";
        }
        return KQ.trim().substring(0, KQ.length()-1);
    }
}
