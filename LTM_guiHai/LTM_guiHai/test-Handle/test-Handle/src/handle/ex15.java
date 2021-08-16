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
public class ex15 {
    public static void main(String[] args) {
        String str1 = "mon thcs2 hoc de";
        String str2 = "ngon ngu C.";
        int index= 1 ;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for (int i = 0; i < index-1; i++) {
            System.out.print(s1[i]);
        }
        for (int i = 0; i < s2.length; i++) {
            System.out.print(s2[i]);
        }
        for (int i = index-1; i < s1.length; i++) {
            System.out.print(s1[i]);
        }
    }
}
