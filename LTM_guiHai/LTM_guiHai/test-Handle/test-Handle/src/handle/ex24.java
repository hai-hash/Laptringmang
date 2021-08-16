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
public class ex24 {
    public static void main(String[] args) {
        String str1 = "10;2,3,5,6,5";
        String[] arr1 = str1.split(";");
        int n = Integer.parseInt(arr1[0]);
        String[] arr_number = arr1[1].split(",");
        int[] a = new int[arr_number.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(arr_number[i]);
        }
        String result = "";
        for (int i = 1; i <= n ; i++) {
            boolean check = true;
            for (int j = 0; j < a.length; j++) {
                if(i == a[j]){
                    check = false;
                    break;
                }
            }
            if(check){
                result = result + i + ",";
            }
        }
        result = result.substring(0,result.length()-1);
        System.out.println(result);
    }
}
