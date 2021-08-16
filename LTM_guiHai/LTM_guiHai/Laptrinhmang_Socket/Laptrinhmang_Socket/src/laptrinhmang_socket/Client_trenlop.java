/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author kieuq
 */
public class Client_trenlop {
    public final static String SERVER_IP = "192.168.0.104";
    public final static int SERVER_PORT = 9999;
    
    public static void main(String[] args) throws IOException, InterruptedException {
//        String sentence_to_server;
//        String sentence_from_server;
//        
//        System.out.print("Input from client: ");
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//        sentence_to_server = inFromUser.readLine();
//        
//        Socket clientSocket = new Socket("127.0.0.1", 9999);
//        
//        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//        
////        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
//        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        
//        outToServer.writeBytes(sentence_to_server+'\n');
//        
//        sentence_from_server = inFromServer.readLine();
//        
//        System.out.println("From Server: "+sentence_from_server);
//        
//        clientSocket.close();
        
        Socket socket = null;
        try{
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected: "+socket);
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF("Xinchao adadadad");
            
            String get = in.readUTF();
            System.out.println(get);

        }catch(IOException e){
            System.out.println("Can't connect to server");
        }finally{
            if(socket != null){
                socket.close();
            }
        }
    }
}
