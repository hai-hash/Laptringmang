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
public class ex19 {
    public static void main(String[] args) {
        String str1 = "mon THCS2 la mon DE";
        String[] arr1 = str1.split("\\s+");
        String str2 = str1.toUpperCase();
        String[] arr2 = str2.split("\\s+");
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i].compareTo(arr2[i]) == 0){
                System.out.print(arr1[i]+" ");
            }
        }
        
    }
}
