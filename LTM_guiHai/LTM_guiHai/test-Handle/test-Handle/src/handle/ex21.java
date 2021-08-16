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
public class ex21 {
    public static void main(String[] args) {
        String str = "mon thcs2 hoc la mon 2tc hoc";
        String[] arr = str.split("\\s+");
        int[] a = new int[arr.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if(a[i] == 0){
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i].compareTo(arr[j]) == 0){
                        a[j] = 1;
                    }
                }
            }
        }
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if(a[i] == 0){
                result = result + arr[i] + " ";
            }
        }
        result = result.trim();
        System.out.println(result);
        
        
        
    }
}
