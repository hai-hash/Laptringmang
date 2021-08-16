/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

/**
 *
 * @author PESI
 */
public class XuLyTCP {
    public static void main(String[] args) {
        String str = "T520 thinkpad lenovo";
        String[] arr = str.split("\\s+");
        
        String wordFrist = arr[0];
        String wordLast = arr[arr.length-1];
        arr[0] = wordLast;
        arr[arr.length-1] = wordFrist;
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i] + " ";
        }
        result = result.trim();
        System.out.println(result);
    }
}
