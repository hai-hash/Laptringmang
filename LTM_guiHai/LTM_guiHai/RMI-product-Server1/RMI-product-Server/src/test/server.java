/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author PESI
 */
public class server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        ProductImp product = new ProductImp();
        LocateRegistry.createRegistry(1099);
        Naming.bind("rmi://localhost/product", product);
    }
}
