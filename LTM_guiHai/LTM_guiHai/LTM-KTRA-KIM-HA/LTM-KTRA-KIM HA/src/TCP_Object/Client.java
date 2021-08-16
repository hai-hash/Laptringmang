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
 * @author PESI
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", 1111);
        
        Product product = new Product("B17DCCN048");
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(product);
        out.flush();
        
        ObjectInputStream in = new ObjectInputStream(client.getInputStream());
        Product getProduct = (Product) in.readObject();
        String name = getProduct.getName();
        int quatity = getProduct.getQuantity();
        System.out.println(name);
        System.out.println(quatity);
        
        String[] arr = name.split("\\s+");
        String fristWord = arr[0];
        String lastWord = arr[arr.length-1];
        arr[0] = lastWord;
        arr[arr.length-1] = fristWord;
        
        String nameFixed = "";
        for (int i = 0; i < arr.length; i++) {
            nameFixed = nameFixed + arr[i] + " ";
        }
        nameFixed = nameFixed.trim();
        getProduct.setName(nameFixed);
        
        String quatityStr = String.valueOf(quatity);
        String[] num = quatityStr.split("");
        String fristNum = num[0];
        String lastNum = num[num.length-1];
        num[0] = lastNum;
        num[num.length-1] = fristNum;
        String number = "";
        for (int i = 0; i < num.length; i++) {
            number = number + num[i];
        }
        number = number.trim();
        int quatityFixed = Integer.parseInt(number);
        getProduct.setQuantity(quatityFixed);
        
        out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(getProduct);
        out.flush();
        
        out.close();
        in.close();
        client.close();
        
        
    }
}
