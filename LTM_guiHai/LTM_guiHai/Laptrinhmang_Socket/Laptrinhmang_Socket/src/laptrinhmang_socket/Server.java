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
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kieuq
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public final static int SERVER_PORT = 9999;
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        String sentence_from_client;
//        String sentence_to_client;
//        
//        ServerSocket welcomeSocket = new ServerSocket(9999);
//        
//        while (true) {            
//            Socket connectionSocket = welcomeSocket.accept();
//            
//            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
//            
//            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
//            
//            sentence_from_client = inFromClient.readLine();
//            sentence_to_client = sentence_from_client + " Sever accepted! \n"; 
//            
//            outToClient.writeBytes(sentence_from_client);
//            
//            return;
//        }
        ServerSocket serverSocket = null;
        try{
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: "+serverSocket);
            System.out.println("Waiting for client...");
            
            while (true) {                
                Socket socket = serverSocket.accept();
                System.out.println("Client accpected: "+socket);
                
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                DataInputStream is = new DataInputStream(socket.getInputStream());

                while(true){
                    String input = is.readUTF();
                    StringBuilder sb = new StringBuilder(input);
                    sb.reverse();
                    System.out.println("Reverse String: "+sb);
                    
                    // response ReverseString to client
                    os.writeUTF(sb.toString());
                }
//                socket.close();
            }
        }catch(IOException e){
            System.out.println(e);
        }finally{
            if(serverSocket != null){
                serverSocket.close();
            }
        }
    }
    
}
