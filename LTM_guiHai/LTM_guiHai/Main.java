/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algrothm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longc
 */
public class Main {
    
    public static String Code721(String str){
        List<Character> keys = new ArrayList<>();
        String res = "";
        str = str.replaceAll("\\s+", "");
        for(int i = 0; i < str.length(); i++){
            boolean f = true;
            for(Character c : keys){
                if(c.equals(str.charAt(i))) f = false; 
            }
            if(f) keys.add(str.charAt(i));
        }
//        List<Integer> values = new ArrayList<>();
        for(Character c : keys){
            int count = 0;
            for(int i = 0; i < str.length(); i++){
                if(c.equals(str.charAt(i))) count++; 
            }
            if(count > 1) res += c + ":" + count + ",";
        }
        
        return res;
    }
    
    public static int UCLN(int a, int b){
        int temp;
        while(b != 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public static String maxChar(String str){
        String res = "";
        List<Character> keys = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            boolean f = true;
            for(Character c : keys){
                if(c.equals(str.charAt(i))) f = false;
            }
            if(f) keys.add(str.charAt(i));
        }
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i < keys.size();i++){
            int count = 0;
            for(int j = 0; j < str.length(); j++){
                if(keys.get(i).equals(str.charAt(j))) count++;
            }
            values.add(count);
        }
        int max = values.get(0);
        char c = keys.get(0);
        for(int i = 1; i < values.size();i++){
            if(max < values.get(i)){
                max = values.get(i);
                c = keys.get(i);
            }
        }
        res = c+":";
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i)==c) res += (i+1) + ",";
        }
        return res;
    }
    
    public static String findMiss(String str){
        List<Integer> list = new ArrayList<>();
        String res = "";
        String[] temp = str.split("\\;");
        int n = Integer.parseInt(temp[0]);
        String[] a = temp[1].split("\\,");
        for(String s : a) list.add(Integer.parseInt(s));
        for(int i = 1; i <= n; i++){
            boolean f = true;
            for(Integer x : list){
                if(x == i) f = false;
            }
            if(f) res += i + ",";
        }
        return res;
    }
    
    public static String email(String str){
        String res = "";
        String[] temp = str.split("\\s+");
        res += temp[temp.length-1];//??
        for(int i = 0; i < temp.length-1; i++){
            res+=temp[i].charAt(0);
        }
        res+="@ptit.edu.vn";
        return res;
    }
    
    public static String processStr(String str){
        String res = "";
        str = str.toLowerCase();
        String[] temp = str.split("\\s+");
        for(int i =0;i < temp.length; i++){
            res += Character.toUpperCase(temp[i].charAt(0));
            res += temp[i].substring(1) + " ";
        }
        return res.trim();
    }
    
    public static void main(String[] args) {
        System.out.println(Code721("dgUOo ch2k22ldsOo"));
        System.out.println("UCLN: " + UCLN(42, 58));
        System.out.println(maxChar("Qnc8d5x78ald5GWWmaAAjyg3"));
        System.out.println(findMiss("10;2,3,5,6,5"));
        System.out.println(email("nguyen van tuan nam"));
        System.out.println(processStr("trInh Cong     SON"));
    }
    
    
}
