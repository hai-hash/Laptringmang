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
public class ex4 {
    public static void main(String[] args) {
        String str = "nguYen Canh CAO";
        char[] s = str.toCharArray();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            if(Character.isLowerCase(s[i])){
                s[i] = Character.toUpperCase(s[i]);
            }else{
                s[i] = Character.toLowerCase(s[i]);
            }
            result = result + s[i];
        }
        System.out.println(result);
      
    }
}
