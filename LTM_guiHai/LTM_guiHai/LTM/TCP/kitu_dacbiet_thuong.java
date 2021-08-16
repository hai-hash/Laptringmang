/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;




/**
 *
 * @author User
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 1108);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String msv = ";B17DCCNxxx;722";
        char[] guimsv = msv.toCharArray();
        bw.write(guimsv);
        bw.flush();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        char[] nhanChuoi = new char[1024];
        br.read(nhanChuoi);
        String chuoiNhan = new String(nhanChuoi).trim();
        
        String[] arr = chuoiNhan.split(";");
        String resID = arr[0].trim();
        String[] chuoiXL = arr[1].trim().split("");
        
        String kyTu1 = "";
        String kyTu2 = "";
        for (int i = 0; i < chuoiXL.length; i++) {
            if(chuoiXL[i].matches(".*[a-zA-Z0-9].*")){
                kyTu1 += chuoiXL[i];
            }
            else {
                kyTu2 += chuoiXL[i];
            }
        }
        String result = resID + ";" + kyTu1 + " " + kyTu2;
        char[] guiKQ = result.toCharArray();
        bw.write(guiKQ);
        bw.flush();
        br.close();
        bw.close();
        client.close();
    }
//    public static boolean ktraChuoiSo(String s){
//        if(s.matches(".*[a-zA-Z0-9].*")){
//            return true;
//        }
//        return false;
//    }
}
