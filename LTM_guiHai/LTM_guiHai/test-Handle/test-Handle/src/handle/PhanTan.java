/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle;

/**
 *
 * @author User
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhanTan {
    public static void main(String[] args) {
        long sss = 1000 * 60 * 60 * 24 * 25567L;//sss là 
        long[] array = {225, 72, 40, 195, 105, 
            242, 38, 249, 225, 72, 40, 208, 41, 
            242, 12, 33, 225, 72, 40, 208, 41, 242, 
            52, 101};//24 phần tử
        //nếu để là chữ 
        String[] array2 = {"ab","ab","a","a","b","c","cd","a"};//24 phần tử
        
        for(int pos = 0; pos < 3; pos++){
            long intpart = 0;
            long fractpart = 0;
            for(int i = pos*8; i < pos*8 + 4; i++){
                intpart = intpart*256 + array[i];
                fractpart = fractpart * 256 + array[i+4];
            }
//            for(int i = pos*8; i < pos*8 + 4; i++){
//                intpart = intpart*256 + Long.parseLong(array2[i],16);
//                fractpart = fractpart * 256 + Long.parseLong(array2[i+4],16);
//            }
            long milliseconds = intpart * 1000 + ((fractpart * 1000) / 0x100000000L);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
            Date date = new Date(milliseconds - sss);
            System.out.println(sdf.format(date));
        }
//        long sss = 1000*60*60*24*25567L;//sss : milisecond ,đổi thời gian tính bằng milisecond của cái bảng sang thời gian thực
//        long[] arr = {};
//        for(int pos = 0; pos < 3; pos++){
//            //
//        }
    }
}
