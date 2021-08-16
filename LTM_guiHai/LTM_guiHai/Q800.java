/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class Q800 {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 1107);
            System.out.println(client);
            DataOutputStream out = 
                    new DataOutputStream(client.getOutputStream());
            out.writeUTF("B15DCCN999;800");
            
            
            DataInputStream in = 
                    new DataInputStream(client.getInputStream());
            int a = in.readInt();
            int b = in.readInt();
            System.out.format("a: %d, b: %d", a, b);

           
            out.writeInt(a + b);
            out.writeInt(a * b);
            in.close();
            out.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
