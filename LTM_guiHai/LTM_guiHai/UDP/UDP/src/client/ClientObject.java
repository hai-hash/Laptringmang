/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import UDP.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PESI
 */
public class ClientObject {
    int port;
    DatagramSocket client;
    DatagramPacket request,respone;
    public ClientObject(){
        try {
            port = 1109;
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(ClientObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void sendStudent(Student student) throws IOException{
        try {
            byte[] req = convert1(student);
            request = new DatagramPacket(req, req.length,InetAddress.getByName("192.168.0.103"),port);
            try {
                client.send(request);
            } catch (IOException ex) {
                Logger.getLogger(ClientObject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public Student receive() throws IOException, ClassNotFoundException{
        byte[] res = new byte[1024];
        respone = new DatagramPacket(res,res.length);
        client.receive(respone);
        Student t = convert2(respone.getData());
        return t;
        
        
       
    }
    public Student convert2(byte[] bytes) throws IOException, ClassNotFoundException{
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(in);
        return (Student) is.readObject();
    }
    public byte[] convert1(Student student) throws IOException{
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(student);
        os.close();
        return out.toByteArray();
     
     
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientObject client = new ClientObject();
        Student student_req = new Student("B17DCCN048");
        client.sendStudent(student_req);
        
        
        Student student_res = client.receive();
        
        
        
        String result = student_res.getName();
        result = result.replaceAll("\\s+"," ");
        result = result.trim();
        System.out.println(result);
        String[] arr = result.split(" ");
        String result_name = arr[arr.length-1];
        for (int i = 0; i < arr.length -1; i++) {
            result_name = result_name + String.valueOf(arr[i].charAt(0));
        }
        result_name = result_name + "@ptit.edu.vn";
        
        
        
        student_res.setEmail(result_name);
        client.sendStudent(student_res);
        
        
    }
  
    
}
