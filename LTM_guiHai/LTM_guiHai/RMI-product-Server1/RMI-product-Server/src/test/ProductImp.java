/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author PESI
 */
public class ProductImp extends UnicastRemoteObject implements IProduct {
    public ProductImp() throws RemoteException{
        super();
    }
    

    @Override
    public Product getProduct(String studentCode) {
        Product product = new Product(studentCode);
        product.setId(5);
        return product;
    }

    @Override
    public boolean insertProduct(Product product) {
        if(product.getName().compareTo("Nuoc Hoa Phap") == 0){
            return true;
        }else{
            return false;
        }
    }

  
    
}
