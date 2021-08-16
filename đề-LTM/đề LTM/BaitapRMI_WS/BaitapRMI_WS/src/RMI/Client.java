/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author traan
 */
public class Client {
    public static void main(String[] args) throws Exception{

        IProduct myServer = 
                (IProduct) (Naming.lookup("rmi://192.168.1.100/product"));
        Product product = myServer.getProduct("B15DCAT038");
        System.out.println(product.getId());
        
        product.setName("B15DCAT038");
        product.setExportPrice(12);
        boolean ktra = myServer.insertProduct(product);
    }
}
