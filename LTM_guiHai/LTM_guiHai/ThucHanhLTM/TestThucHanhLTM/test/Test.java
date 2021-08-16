/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Test {

    public static void test1(String ans) {
        int vitri = ans.indexOf(";");
        String requestId = ans.substring(0, vitri);
        System.out.println(requestId);
        String ans1 = ans.substring(vitri + 1);
        System.out.println(ans1);
        int vitri2 = ans1.indexOf(",");
        int a = Integer.parseInt(ans1.substring(0, vitri2));
        int b = Integer.parseInt(ans1.substring(vitri2 + 1));
        System.out.println(a);
        System.out.println(b);
    }

    public static void test2(String ans) {
        int vitri = ans.indexOf(";");
        String requestId = ans.substring(0, vitri);
        String data = ans.substring(vitri + 1);
        String ans1 = "", ans2 = "";
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if ((('0' <= c) && (c <= '9')) || (('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z'))) {
                ans1 += c;
            } else {
                ans2 += c;
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }

    public static void test3(float gpa) {
        String gpaLetter = "";
        if ((gpa <= 4) && (gpa > 3.7)) {
            gpaLetter += "A";
        } else if ((gpa <= 3.7) && (gpa > 3.0)) {
            gpaLetter += "B";
        } else if ((gpa <= 3.0) && (gpa > 2)) {
            gpaLetter += "C";
        } else if ((gpa <= 2) && (gpa > 1)) {
            gpaLetter += "D";
        } else if ((gpa <= 1) && (gpa >= 0)) {
            gpaLetter += "F";
        }
        System.out.println(gpaLetter);
    }

    public static void test4(String data) {
        data = data.toLowerCase();
        String temp[] = data.split("\\s+");
        String str = "";
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                str += " ";
            }
        }
        System.out.println(str);

        String email = "@ptit.edu.vn";
        String[] temp1 = str.split("\\s+");
        String firstEmail = temp1[temp1.length-1].toLowerCase();
        for (int i = 0; i < temp1.length - 1; i++) {
            firstEmail = firstEmail +  String.valueOf(temp[i].charAt(0)).toLowerCase();
        }
        email = firstEmail + email;
        System.out.println(email);
    }

    public static void main(String[] args) {
//        String ans = "requestId;1,2";
//        test2(ans);

//        float gpa = 3.6f;
//        test3(gpa);
        String data = "nGuyen      VaN       NgUyEn";
        test4(data);
    }
}
