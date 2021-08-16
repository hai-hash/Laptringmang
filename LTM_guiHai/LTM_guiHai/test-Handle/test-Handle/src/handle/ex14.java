/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle;

/**
 *
 * @author PESI
 */
public class ex14 {
    public static void main(String[] args) {
        
        String str ="hoc vien cong nghe bcvt";
        String[] arr = str.split("\\s+");
        for(String i:arr){
            System.out.println(i);
        }
    }
}
