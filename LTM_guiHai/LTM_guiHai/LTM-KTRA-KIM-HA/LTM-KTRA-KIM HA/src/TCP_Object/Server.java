/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_Object;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author PESI
 */
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(1111);
        
        System.out.println("SERVER");
        while(true){
            Socket instance = server.accept();
            ObjectInputStream in = new ObjectInputStream(instance.getInputStream());
            
            Product product = (Product) in.readObject();
            System.out.println(product.getCode());
            product.setName("T520 thinkpad lenovo");
            product.setQuantity(1899);
            
            ObjectOutputStream out = new ObjectOutputStream(instance.getOutputStream());
            out.writeObject(product);
            out.flush();
            
            in = new ObjectInputStream(instance.getInputStream());
            Product result = (Product) in.readObject();
            System.out.println(result.getName());
            System.out.println(result.getQuantity());
            
            
            
        }
        
    }
}
