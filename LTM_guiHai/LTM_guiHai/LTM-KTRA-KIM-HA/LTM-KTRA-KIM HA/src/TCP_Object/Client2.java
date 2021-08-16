/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author User
 */
public class Client2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", 1111);
        Product huy = new Product("B17DCCN324");
        
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(huy); //viết huy
        oos.flush();
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        Product huyMoi = (Product) ois.readObject();
        
        String name = huyMoi.getName();
        System.out.println(name);
        String[] arr = name.trim().split("\\s+");
        
        String nameKq = arr[arr.length-1] + " " ;
        for (int i = 1; i < arr.length-1; i++) {
            nameKq += arr[i] + " ";
            
        }
        nameKq += arr[0];
        huyMoi.setName(nameKq.trim());
        System.out.println(nameKq);
        
        int soLuong = huyMoi.getQuantity();
        String strsoLuong = String.valueOf(soLuong);
        StringBuilder builder = new StringBuilder(strsoLuong).reverse();
        int soLuongMoi = Integer.parseInt(builder.toString());
        huyMoi.setQuantity(soLuongMoi);
        //oos.writeObject(huyMoi);
//        String strSL = String.valueOf(soLuong);
//        String[] arrSL = strSL.trim().split("");
//        String soDau = arrSL[arrSL.length-1];
//        String soCuoi = arrSL[0];
//        String soLuongMoi = soDau;
//        for (int i = 1; i < arrSL.length-1; i++) {
//            soLuongMoi += arrSL[i];
//        }
//        soLuongMoi += soCuoi;
//        System.out.println(soLuongMoi);
//        soLuongMoi = soLuongMoi.trim();
//        int soLuongDung = Integer.parseInt(soLuongMoi);
//        System.out.println(soLuongDung);
//        huyMoi.setQuantity(soLuongDung);
        
        oos = new ObjectOutputStream(client.getOutputStream());//công anh
        oos.writeObject(huyMoi);
        oos.flush();
        oos.close();
        client.close();
    }
}
