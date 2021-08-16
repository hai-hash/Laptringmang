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
public class ex2 {
    public static void main(String[] args) {
        String str = "ngUYEN     van nam";
        str = str.toLowerCase();
        String[] arr = str.split("\\s+");
        String result = arr[arr.length-1].toUpperCase()+",";
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i].substring(0,1).toUpperCase()+arr[i].substring(1);
            result = result + arr[i] + " ";
        }
        result = result.trim();
        System.out.println(result);
        
    }
}
