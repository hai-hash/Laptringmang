
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class NewClass {
    public static void main(String[] args) {
        long sss = 1000 * 60 * 60 * 24 * 25567L;
        String[] array = {"ab","ab","a","a","b","c","cd","a"};
        for(int pos = 0; pos < 3; pos++){
            long intpart = 0;
            long fractpart = 0;
            for(int i = pos*8; i < pos*8 + 4; i++){
                intpart = intpart*256 + Long.parseLong(array[i],16);
                fractpart = fractpart*256 + Long.parseLong(array[i+4],16);
        }
        long milisecond = intpart*1000 + (( fractpart*1000 )/ 0x100000000L);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
        Date date = new Date(milisecond-sss);
        System.out.println(sdf.format(date));
}
    }
}
