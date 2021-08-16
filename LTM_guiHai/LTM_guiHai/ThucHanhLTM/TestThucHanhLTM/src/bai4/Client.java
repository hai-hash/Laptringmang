/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            //khoi tao
            Socket client = new Socket("10.170.44.202", 1107);
            System.out.println(client);

            //gui du lieu
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            String s = ";B15DCCN001";
            out.writeUTF(s);

            //doc du lieu
            DataInputStream in = new DataInputStream(client.getInputStream());
            //=------------------------------------------------------------------
            String ans = in.readUTF();
            int vitri = ans.indexOf(";");
            String requestId = ans.substring(0, vitri);
            String ans1 = ans.substring(vitri + 1);
            String[] num = ans1.split(",");
            int[] a = new int[50];
            for(int i = 0; i < 50; i++){
                a[i] = Integer.parseInt(num[i]);
            }
           
            int max = a[0];
            int min = a[0];
            for(int i = 0; i <= 50; i++) {
                if(max < a[i]) max = a[i];
                if(min > a[i]) min = a[i];
            }
            
            String respone = requestId + ";" + max + "," + min;
            
            out.writeUTF(respone);
            
            client.close();
        } catch (Exception e) {
        }
    }
}
