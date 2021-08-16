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
public class ex18 {
    public static void main(String[] args) {
        String str1 = "mon thcs2 la mon 2tc";
        String str2 = "mon";
        str1 = str1.replaceAll(str2, "");
        str1 = str1.trim();
        System.out.println(str1);
    }
}
