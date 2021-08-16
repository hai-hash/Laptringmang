/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_Object;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
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

/**
 *
 * @author User
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, ClassNotFoundException {
        Student huyen = new Student("B17DCCNxxx");
        int port = 1111;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        DatagramSocket client = new DatagramSocket();
        DatagramPacket goiGui , goiNhan, goiGui2;
        
        
        //DUNG DE GUI THANG STUDENT DI - CONVERT STUDENT SANG MANG BYTE
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(huyen); //viet vào baos
        oos.flush();
       
        
        byte[] guiMsv = baos.toByteArray();
        goiGui = new DatagramPacket(guiMsv, guiMsv.length, inetAddress, port);
        
        client.send(goiGui);
        
       byte[] nhanStudent = new byte[1024];
       goiNhan = new DatagramPacket(nhanStudent, nhanStudent.length);
       client.receive(goiNhan);
       // DUNG DE CONVERT MANG BYTES NHAN DUOC THANH THANG STUDENT
        ByteArrayInputStream bais = new ByteArrayInputStream(goiNhan.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        
        Student studentMoi = (Student) ois.readObject();
        
        
        String name = studentMoi.getName();
        
        String[] arr = name.split(" ");
        String nameMoi = "";
        for (int i = 0; i < arr.length; i++) {
            String temps = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1).toLowerCase();
            nameMoi += temps + " ";
        }
        
        studentMoi.setName(nameMoi);
        
        String[] arr2 = nameMoi.split(" ");
        //Nguyen Van Nam
        String email = arr2[arr2.length-1].toLowerCase();
        for (int i = 1; i < arr2.length; i++) {
            email = email + arr2[i].substring(0,1).toLowerCase();
        }
        email = email + "@ptit.edu.vn";
        studentMoi.setEmail(email);
        
         baos = new ByteArrayOutputStream();
         oos = new ObjectOutputStream(baos);
        oos.writeObject(studentMoi); //viet vào baos
        oos.flush();
       
        
        baos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(baos);
        oos.writeObject(studentMoi); //viet vào baos
        oos.flush();
       
        
        byte[] guiKQ = baos.toByteArray();
        goiGui2 = new DatagramPacket(guiKQ, guiKQ.length, inetAddress, port);
        
        client.send(goiGui2);
        
        baos.close();
        oos.close();
        bais.close();
        ois.close();
      
        client.close();
    }
}
