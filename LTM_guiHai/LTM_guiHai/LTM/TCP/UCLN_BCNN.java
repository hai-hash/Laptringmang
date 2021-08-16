/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author User
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1109);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("B17DCCNxxx;911");
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int a = dis.readInt();
        int b = dis.readInt();
        int tong = a + b;
        int tich = a * b;
        int uclnKQ = ucln(a, b);
        int bcnn = tich / uclnKQ;
        dos.writeInt(tong);
        dos.writeInt(tich);
        dos.writeInt(uclnKQ);
        dos.writeInt(bcnn);
        
        socket.close();
        dos.close();
        dis.close();
    }
    public static int ucln(int a, int b){
       if(b == 0){
           return a;
       }
       return ucln(b, a%b);
    }
}
