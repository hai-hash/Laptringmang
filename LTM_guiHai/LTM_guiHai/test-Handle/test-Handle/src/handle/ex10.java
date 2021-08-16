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
public class ex10 {
    public static void main(String[] args) {
        String str = "ptit.edu.vn thcs2";
        String[] arr = str.split("");
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
        
    }
}
