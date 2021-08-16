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
public class ex23 {
    public static boolean Handle(char s){
        if('0' <= s && s <= '9' || 'a' <= s && s<= 'z' || 'A' <= s && s <= 'Z'){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "105BIXASASWQE^!+_SXA./~";
        char[] s = str.toCharArray();
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < s.length; i++) {
            if(Handle(s[i])){
                result1 = result1 + String.valueOf(s[i]);
            }else{
                result2 = result2 + String.valueOf(s[i]);
            }
        }
        System.out.println(result1);
        System.out.println(result2);
        
    }
}
