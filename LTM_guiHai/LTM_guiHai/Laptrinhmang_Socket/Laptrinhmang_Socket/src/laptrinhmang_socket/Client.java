/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang_socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kieuq
 */
public class Client {
    public final static String SERVER_IP = "192.168.0.104";
    public final static int SERVER_PORT = 9999;
    
    public static void main(String[] args) throws IOException, InterruptedException {
      
        Socket socket = null;
        try{
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected: "+socket);
            
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("Message to Server: ");
                String str = sc.nextLine();
                os.writeUTF(str);
                System.out.println("--Server says: "+ is.readUTF());
            }
          
            
        }catch(IOException e){
            System.out.println("Can't connect to server");
        }finally{
            if(socket != null){
                socket.close();
            }
        }
    }
    
    
}
