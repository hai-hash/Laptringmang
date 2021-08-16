/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Nguyen Hoa
 */
public interface Iproduct extends Remote{
    public Product getProduct(String studentCode) throws RemoteException;
    public boolean insertProduct(Product product) throws RemoteException;
}
