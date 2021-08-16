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
public class XuLyUDP1 {
    public static void main(String[] args) {
//        String str = "ABCDEFabczzZZ";
//         String result ="";
//        char[] s = str.toCharArray();
//        for (int i = 0; i < s.length; i++) {
//            if('z' >= s[i] && s[i] >= 'a'){
//                s[i] = (char) ((s[i] + 3) % 26);
//            }
//             if('A' >= s[i] && s[i] >= 'Z'){
//                s[i] = (char) ((s[i] + 3) % 26);
//            }
//            result = result + String.valueOf(s[i]);
//        }
//        System.out.println(result);

//        System.out.println((int)'Z');
//        System.out.println((int)'A');
//        System.out.println((int)'C');
//        System.out.println(93/26);
        String str = "ABCDEFabczzZZ";
        char[] s = str.toCharArray();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            if(s[i] >= 'A' && s[i] <= 'Z'){
                s[i] = (char) ('A'+ ((s[i] + 3- 'A')%26));
//                result = result + String.valueOf(s[i]);
            }
            else if(s[i] >= 'a' && s[i] <= 'z'){
                s[i] = (char) ('a' + ((s[i] + 3 - 'a')%26));
//                result = result + String.valueOf(s[i]);
            }
        }
        for (int i = 0; i < s.length; i++) {
             result = result + String.valueOf(s[i]);
        }
        System.out.println(result);


//        A  B  C  D  X  Y   Z 
//        65 66 67 68 69 70  71
//        
//        
//        A -> D 
//        Z -> C
//        
//        71 +3 = 74 
//        71 -> 67 

//        System.out.println(74%7);
//        System.out.println((int)'a'); //97
//        System.out.println((int)'A'); //65
    }
}
