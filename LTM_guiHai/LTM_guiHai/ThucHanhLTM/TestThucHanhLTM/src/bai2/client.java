/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class client {

    public static void main(String[] args) {
        try {
            //khoi tao
            Socket client = new Socket("192.168.1.100", 1108);
            System.out.println(client);

            //gui du lieu
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            String s = ";B15DCCN001;101";
            out.writeUTF(s);

            //doc du lieu
            DataInputStream in = new DataInputStream(client.getInputStream());
            //=------------------------------------------------------------------
            String ans = in.readUTF();
            int vitri = ans.indexOf(";");
            String requestId = ans.substring(0, vitri);
            String data = ans.substring(vitri + 1);
            String ans1 = "", ans2 = "";
            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);
                if ((('0' <= c) && (c <= '9')) || (('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z'))) {
                    ans1 += c;
                } else {
                    ans2 += c;
                }
            }
            
            String respone = requestId + ";" + ans1 + "," + ans2;
            
            out.writeUTF(respone);
            
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
