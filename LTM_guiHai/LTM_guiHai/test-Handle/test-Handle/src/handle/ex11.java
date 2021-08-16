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
public class ex11 {
    public static void main(String[] args) {
        String str = "mon thcs2 khoai hon thcs1";
        String[] arr = str.split("\\s+");
        int max = 0;
        String result1 = "";
        int min = 9999;
        String result2 = "";
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length()>max){
                max = arr[i].length();
                result1 = arr[i];
            }
            if(arr[i].length() < min){
                min = arr[i].length();
                result2  = arr[i];
            }
        }
        System.out.println(result1 +" " +result2);
        
    }
 
}
