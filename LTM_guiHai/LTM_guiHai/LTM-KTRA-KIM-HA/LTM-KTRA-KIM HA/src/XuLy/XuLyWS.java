/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;


import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PESI
 */
public class XuLyWS {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        String str = "10584,20166,28199,30250,32179,22544,10320,30590,19279,3222,9575";
        String[] arr = str.split(",");
        //in ra số lớn nhất có thể tạo từ các số trên ,
        // so sánh chữ số đầu tiên để sx theo nó
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        
        String kq2 = "";
        for (int i = 0; i < list.size(); i++) {
            kq2 += list.get(i);
            
        }
        
        System.out.println(kq2);
        String kq = "";
        for (int i = list.size()-1; i >= 0 ; i--) {
            kq += list.get(i);
        }
        System.out.println(kq);
     
        
        
        
        
        
        
       
        
    }
}
