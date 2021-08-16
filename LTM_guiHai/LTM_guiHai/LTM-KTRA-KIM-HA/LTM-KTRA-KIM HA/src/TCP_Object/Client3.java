/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_Object;

import com.sun.corba.se.pept.encoding.InputObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author User
 */
public class Client3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", 1111);
        
        Product product1 = new Product("B17DCCN324");
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(product1);
        oos.flush();
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        Product productNhan = (Product) ois.readObject();
        
        String name = productNhan.getName();
        String[] arr = name.split("\\s+");
        String nameKQ = arr[arr.length-1] + " ";
        for (int i = 1; i < arr.length-1; i++) {
            nameKQ += arr[i] + " ";
            
        }
        nameKQ += arr[0];
        productNhan.setName(nameKQ.trim());
        
        int soLuong = productNhan.getQuantity();
        String s = String.valueOf(soLuong);
        StringBuilder builder = new StringBuilder(s).reverse();
        int soLuongMoi = Integer.parseInt(builder.toString());
        productNhan.setQuantity(soLuongMoi);
        
        oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(productNhan);
        oos.flush();
        ois.close();
        oos.close();
        client.close();
    }
}
