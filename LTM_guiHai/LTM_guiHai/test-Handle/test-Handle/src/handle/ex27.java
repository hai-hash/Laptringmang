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
public class ex27 {
    public static void main(String[] args) {
        String str = "dgUOo ch2k22ldsOo";
        String[] arr = str.split("");
        int[] check = new int[arr.length];
        for (int i = 0; i < check.length; i++) {
            check[i] = 0;
        }
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if(check[i] == 0){
                int count = 1;
                check[i] = 1;
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i].compareTo(arr[j]) == 0){
                        count++;
                        check[j] = 1;
                    }
                }
                if(count > 1){
                    result = result + arr[i]+":"+count+",";
                }
            }
        }
        System.out.println(result);
    }
}
