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
public class Handle {
    public static String reverse(String str){
        String result ="";
        for (int i = str.length()-1; i >= 0; i--) {
            result = result + str.charAt(i);
        }
        return result;
    }
}
