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
public class ex3 {
    public static void main(String[] args) {
        String str = "test3@ptit.edu.vn";
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if('0' <= s[i] && '9'>= s[i]){
                count1++;
            }
            if('a'<=s[i] && s[i] <='z' || 'A' <= s[i] && s[i] <='Z'){
                count2++;
            }
        }
        count3 = str.length() - count1 - count2;
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        
    }
}
