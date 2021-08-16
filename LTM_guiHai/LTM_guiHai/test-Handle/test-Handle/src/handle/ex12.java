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
public class ex12 {
    public static void main(String[] args) {
        String str = "nguyen   canh cao";
        String[]  arr = str.split("\\s+");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
        }
        System.out.println(result);
        
    }
}
