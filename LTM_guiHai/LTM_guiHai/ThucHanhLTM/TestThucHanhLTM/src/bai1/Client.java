/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Client {

    public static void main(String[] args) {
        try {
            //khoi tao
            Socket client = new Socket("192.168.1.100", 1107);
            System.out.println(client);

            //gui du lieu
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            String s = ";B15DCCN001;100";
            out.writeUTF(s);

            //doc du lieu
            DataInputStream in = new DataInputStream(client.getInputStream());
            //=------------------------------------------------------------------
            String ans = in.readUTF();
            int vitri = ans.indexOf(";");
            String requestId = ans.substring(0, vitri);
            String ans1 = ans.substring(vitri + 1);
            int vitri2 = ans1.indexOf(",");
            int a = Integer.parseInt(ans1.substring(0, vitri2));
            int b = Integer.parseInt(ans1.substring(vitri2 + 1));
            //=------------------------------------------------------------
            int temp1 = a;
            int temp2 = b;
            while (temp1 != temp2) {
                if (temp1 > temp2) {
                    temp1 -= temp2;
                } else {
                    temp2 -= temp1;
                }
            }
            int ucln = temp1;
            int sum = a + b;
            int mul = a * b;
            int bcnn = mul / ucln;
            String respone = requestId + ";" + ucln + "," + bcnn + "," + sum + "," + mul;
            
            out.writeUTF(respone);
            
            //đong
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
