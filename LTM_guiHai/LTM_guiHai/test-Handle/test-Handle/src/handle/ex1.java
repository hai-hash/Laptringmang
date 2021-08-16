/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 *
 * @author PESI
 */
public class ex1 {
    public static void main(String[] args) {
        String str1 = "abc ab ab ab    abcd  xx xyzt    ";
        String[] arr1 = str1.split("\\s+");
        
        Set<String> set1 = new HashSet<String>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        List<String> list1 = new ArrayList<String>(set1);
        
        String str2 = "ab abc xx yy";
        String[] arr2 = str2.split("\\s+");
        Set<String> set2 = new HashSet<String>();
        for (int i = 0; i < arr2.length; i++) {
            set2.add(arr2[i]);
        }
        List<String> list2 = new ArrayList<String>(set2);
        
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < list1.size(); i++) {
            boolean check = true;
            for (int j = 0; j < list2.size(); j++) {
                if(list1.get(i).compareTo(list2.get(j)) == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                result.add(list1.get(i));
            }
            
        }
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        
        
        
        

        
    }
}
