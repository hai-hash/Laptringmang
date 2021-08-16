/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

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
            String data = ans.substring(vitri + 1);

            data = data.toLowerCase();
            String temp[] = data.split("\\s+");
            String str = "";
            for (int i = 0; i < temp.length; i++) {
                str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
                if (i < temp.length - 1) // ? ^-^
                {
                    str += " ";
                }
            }
            
            String respone = requestId + ";" + str;
            
            out.writeUTF(respone);
            
            client.close();
        } catch (Exception e) {
        }
    }
}
