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
public class ex7 {
    public static void main(String[] args) {
        String str = "ngUYEN     van nam";
        String[] arr = str.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase();
        }
        String result = "";
        for (int i = 0; i < arr.length-1; i++) {
            result = result + arr[i].substring(0,1);
        }
        result = result + arr[arr.length-1]+"@ptit.edu.vn";
        System.out.println(result);
    }
}
