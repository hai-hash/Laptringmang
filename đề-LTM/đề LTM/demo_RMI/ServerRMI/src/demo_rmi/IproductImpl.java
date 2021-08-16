/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Nguyen Hoa
 */
public class IproductImpl extends UnicastRemoteObject implements Iproduct{

//    public Iproduct{
//        super();
//    }
    
    
    public IproductImpl() throws RemoteException {
        super();
    }

    @Override
    public Product getProduct(String studentCode) throws RemoteException {
        Product p = new Product();
        p.setCode("code");
        p.setId(1);
        return p;
    }

    @Override
    public boolean insertProduct(Product product) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int leng = product.getName().length();
        boolean abc = product.getInportPrice() < product.getExportPrice();
        if(leng > 8 && leng < 20 && abc)
            return true;
        return false;

    }
    
}
