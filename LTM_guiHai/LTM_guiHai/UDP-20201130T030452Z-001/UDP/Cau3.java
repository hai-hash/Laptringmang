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
public class Cau3 {
    public static void main(String[] args) throws Exception{
        System.out.println("Client === \n");
        
        DatagramSocket client = new DatagramSocket();
        Student student = new Student("B15DCAT038");
        send(student, client);//Gui lan 1
        
        Student student2 = receive(client);//Nhan lan 1
        System.out.println(student2.getId()+student2.getCode()+student2.getName());
      
        
        String result = student2.getName().toLowerCase();
        
        String result2 = "";
        String em = "";// Lay chu cai dau cua ten dem va ho ten
        
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == ' ' && result.charAt(i+1) == ' ' && i+1 != result.length())
                continue;
            if(i == 0 || (result.charAt(i-1) == ' ' && result.charAt(i) != ' ')) {
                em += result.charAt(i);
                char s = Character.toUpperCase(result.charAt(i));
                result2 += s;
            }
            else
                result2 += result.charAt(i);
        }
        
        System.out.println(result2);
        
        //Lay ten nguoi
        String em2 = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            if(em2 != "" && result.charAt(i+1) == ' ' && result.charAt(i) != ' ')
                break;
            em2 += result.charAt(i);
        }
        
        StringBuilder em3 = new StringBuilder();
        em3.append(em2);
        //Dao nguoc chuoi
        em3 = em3.reverse();
        
        String em4 = em.substring(0, em.length() - 1);
        
        String em5 = em3 + em4;
        System.out.println(em5);
        String email = "";
        for (int i = 0; i < em5.length(); i++) {
            if(em5.charAt(i) == ' ')
                continue;
            email += em5.charAt(i);
        }
        email += "@ptit.edu.vn ";
        System.out.println(email);
        
        Student student3 = new Student(student2.getId(), student2.getCode(), result2, email);
        
        send(student3, client);//Gui lan 2
        
//        send(student, client);
    }
    
    public static void send(Student st, DatagramSocket client) throws Exception{
        if(client != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(st);
            oos.flush();

            InetAddress inetAddress = InetAddress.getByName("localhost");

            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, inetAddress, 1109);

            client.send(sendPacket);
        }
    }
    
    public static Student receive(DatagramSocket client) throws Exception{
        Student student = null;
        if(client != null) {
            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            client.receive(receivePacket);
            
            ByteArrayInputStream bais = new
                ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            student  = (Student) ois.readObject();
            return student;
        }
        return null;
    }
}
