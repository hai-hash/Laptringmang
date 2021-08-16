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
public class ex22 {
    public static void main(String[] args) {
        String str = "ngUYEN     van nam";
        String[] arr = str.split("\\s+");
        String result = "";
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase();
            result = result + arr[i] + " ";
        }
        result = result.trim();
        result = result + "," + arr[0].toUpperCase();
        System.out.println(result);
        
    }
}
