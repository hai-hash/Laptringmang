/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PESI
 */
public class ex25 {
    public static void main(String[] args) {
        String str = "101;50,70,80,951,101";
        String[] arr = str.split(";");
        String[] number = arr[1].split(",");

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < number.length; i++) {
            list.add(Integer.parseInt(number[i]));
        }
        Collections.sort(list);
        String result = arr[0]+";"+list.get(list.size()-1) + ","+list.get(0);
        result = result.trim();
        System.out.println(result);
        
    }
}
