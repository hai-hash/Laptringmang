/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author PESI
 */
public class Client {
    public static void main(String[] args) throws  MalformedURLException, RemoteException, NotBoundException {
        IProduct client =  (IProduct) Naming.lookup("rmi://localhost/product");
        Product product = client.getProduct("B17DCCN048");
        System.out.println(product.getId());
        product.setName("Nuoc Hoa Phap");
        System.out.println(client.insertProduct(product));
        
    }
}
