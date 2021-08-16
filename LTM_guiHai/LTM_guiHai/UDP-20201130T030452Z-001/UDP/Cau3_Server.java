/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author traan
 */
public class Cau3_Server {
    public static DatagramPacket receivePacket = null;
    public static void main(String[] args) throws Exception{
        
        DatagramSocket server = new DatagramSocket(1109);
        
        System.out.println("Server === \n");
        
        while(true) {
            Student student = receive(server);
            System.out.println(student.getCode());
            
            Student student2 = new Student("281", student.getCode(), "TrAN anh dAT", null);
            send(student2, server);
            
            Student student3 = receive(server);
            System.out.println(student3.getName() + " " + student3.getEmail());
        }
    }
    
    public static void send(Student st, DatagramSocket server) throws Exception{
        if(server != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(st);
            oos.flush();

            InetAddress inetAddress = InetAddress.getByName("localhost");

            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());

            server.send(sendPacket);
        }
    }
    
    public static Student receive(DatagramSocket server) throws Exception{
        Student student = null;
        if(server != null) {
            byte[] receiveData = new byte[1024];

            receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            server.receive(receivePacket);
            
            ByteArrayInputStream bais = new
                ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            student  = (Student) ois.readObject();
            return student;
        }
        return null;
    }
}
