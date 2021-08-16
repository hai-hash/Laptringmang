/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import UDP.Student;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PESI
 */
public class ServerObject {
    int port;
    DatagramSocket server;
    DatagramPacket request,respone;
    public ServerObject(){
        port = 1109;
        try {
            server = new DatagramSocket(port);
        } catch (SocketException ex) {
            Logger.getLogger(ServerObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void listenning() throws IOException, ClassNotFoundException{
        System.out.println("SERVER START");
        while(true){
            byte[] req = new byte[1024];
            request = new DatagramPacket(req, req.length);
            server.receive(request);
            
            Student t = convert1(request.getData());
            t.setName("nguyen van nam");
            t.setId("5");
            
            byte[] res = convert2(t);
            respone = new DatagramPacket(res, res.length, request.getAddress(), request.getPort());
            server.send(respone);
            
            byte[] result = new byte[1024];
            DatagramPacket result_back = new DatagramPacket(result, result.length);
            server.receive(result_back);
            Student result_student = convert1(result_back.getData());
            System.out.println(result_student.getId());
            System.out.println(result_student.getName());
            System.out.println(result_student.getCode());
            System.out.println(result_student.getEmail());
            
            
        }
    }
    public Student convert1(byte[] data) throws IOException, ClassNotFoundException{
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return (Student) is.readObject();
    }
    public byte[] convert2(Student student) throws IOException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(student);
        os.close();
        return out.toByteArray();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerObject server = new ServerObject();
        server.listenning();
    }
}
