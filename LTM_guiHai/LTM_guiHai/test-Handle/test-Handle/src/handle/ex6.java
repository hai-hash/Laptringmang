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
public class ex6 {
    public static void main(String[] args) {
        String str=  "aaa  bbb ccc   AA   bb   aa   ccc aa";
        String[] arr = str.split("\\s+");
        int[] check = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase();
            check[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if(check[i] == 0){
                check[i] = 1;
                int count = 1;
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i].compareTo(arr[j]) == 0){
                        count++;
                        check[j] = 1;
                    }
                }
                System.out.println(arr[i] +" "+count);
            }
        }
        
    }
}
