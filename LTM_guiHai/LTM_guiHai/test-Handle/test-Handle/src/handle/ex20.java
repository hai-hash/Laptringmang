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
public class ex20 {
    public static void main(String[] args) {
        String str1 = "mon thcs    2 nam 2017";
        String[] arr = str1.split("\\s+");
        System.out.println(arr.length);
    }
}
