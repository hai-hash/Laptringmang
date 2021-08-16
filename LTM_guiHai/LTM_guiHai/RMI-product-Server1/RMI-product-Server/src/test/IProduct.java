/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author PESI
 */
public interface IProduct extends Remote{
    Product getProduct(String studentCode) throws RemoteException;
    boolean insertProduct(Product product) throws RemoteException;
}
