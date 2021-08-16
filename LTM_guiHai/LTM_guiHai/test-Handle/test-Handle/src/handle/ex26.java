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
public class ex26 {
    public static void main(String[] args) {
        String str = "404;Qnc8d5x78aldSGWWmaAAjyg3";
        String[] arr = str.split(";");
        String result = arr[0]+";";
        int ma = 0;
        String kq = "";
       
        
        String[] s = arr[1].split("");
        int[] check = new int[s.length];
        for (int i = 0; i < check.length; i++) {
            check[i] = 0;
        }
        for (int i = 0; i < s.length; i++) {
            if(check[i] == 0){
                check[i] = 1;
                int count = 0;
                for (int j = i+1; j < s.length; j++) {
                    if(s[i].compareTo(s[j]) == 0){
                        count++;
                        check[j] = 1;
                    }
                }
                if(count > ma){
                    ma = count;
                    kq = s[i];
                }
            }
        }
        result = result + kq+":";
        for (int i = 0; i < s.length; i++) {
            if(kq.compareTo(s[i]) == 0){
                result = result + (i+1) + ",";
            }
        }
        System.out.println(result);
    }
}
