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
public class ex16 {
    public static void main(String[] args) {
        String str = "ptit.edu.vn thcs2";
        str = str.replaceAll("\\s+","");
        System.out.println(str);
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }
}
