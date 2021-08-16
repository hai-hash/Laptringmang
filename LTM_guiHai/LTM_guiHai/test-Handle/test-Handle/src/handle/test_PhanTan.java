/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class test_PhanTan {

    public static void main(String[] args) {
        long sss = 1000 * 60 * 60 * 24 * 25567L;
        long[] array = {225, 72, 40, 195, 105,
            242, 38, 249, 225, 72, 40, 208, 41,
            242, 12, 33, 225, 72, 40, 208, 41, 242,
            52, 101};
        for (int pos = 0; pos < 3; pos++) {
            long intpart = 0;
            long fractpart = 0;
            for (int i = pos * 8; i < pos * 8 + 4; i++) {
                intpart = intpart * 256 + array[i];
                fractpart = fractpart * 256 + array[i + 4];
            }
            long milisecond = intpart * 1000 + ((fractpart * 1000) / 0x100000000L);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
            Date date = new Date(milisecond - sss);
            System.out.println(sdf.format(date));
        }
        
    }
}
