/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        IProduct iProduct = (IProduct) Naming.lookup("rmi://localhost/product");
        Product product = iProduct.getProduct("B17dccn324");
        product.setName("123456789");
        product.setExportPrice(2);
        product.setImportPrice(1);
        
        iProduct.insertProduct(product);
    }
}
