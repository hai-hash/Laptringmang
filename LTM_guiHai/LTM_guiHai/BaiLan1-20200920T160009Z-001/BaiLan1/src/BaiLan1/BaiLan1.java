/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiLan1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


/**
 *
 * @author Duc
 */
public class BaiLan1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
           Socket clientSocket = new Socket("localhost",3333); 
           DataInputStream in = new DataInputStream(clientSocket.getInputStream());
           DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
           out.writeUTF("B16DCAT036;911");
           int a = in.readInt();
           int b = in.readInt();
           int uoc = UCLN(a,b);
           int boi = (a*b)/uoc;
           out.writeInt(uoc);
           out.writeInt(boi);
           out.writeInt(a+b);
           out.writeInt(a*b);
           in.close();
           out.close();
           clientSocket.close();
        }
        catch(Exception e){
            
        }
                 
    }

    private static int UCLN(int a, int b) {
        if(a==b) return a;
        if (a>b) return UCLN(a-b,b);
        else return UCLN(a,b-a);
    }
    
}
