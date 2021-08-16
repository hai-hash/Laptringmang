/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class SClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1108);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(";B15DCCN001;100");
            String chuoinhantuServer = dataInputStream.readUTF();
            dataOutputStream.writeUTF(chuoikq(chuoinhantuServer));
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Object[] chuoiketqua(String input) { //  cách 1 chưa tối ưu nếu có chữ ơ â ă ...
        String chuoikitusovachu = "";
        String chuoikitudacbiet = "";
        char mangString[] = input.toCharArray();
        for (int i = 0; i < mangString.length; i++) {
            if (String.valueOf(mangString[i]).matches("[a-z A-Z 0-9]")) {
                chuoikitusovachu += String.valueOf(mangString[i]);
            } else {
                chuoikitudacbiet += String.valueOf(mangString[i]);
            };
        }
        Object[] result = {chuoikitusovachu, chuoikitudacbiet};
        return result;
    }

    public static Object[] chuoiketqua2(String input) { //  cách 1 chưa tối ưu nếu có chữ ơ â ă ...
        String chuoikitusovachu = "";
        String chuoikitudacbiet = "";
   
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (specialCharactersString.contains(Character.toString(ch))) {
                  chuoikitudacbiet += Character.toString(ch);
            } else {
               chuoikitusovachu += Character.toString(ch);
            }
        }
        Object[] result = {chuoikitusovachu, chuoikitudacbiet};
        return result;
    }

    public static String chuoikq(String input) {
        String result = "";
        String data[] = input.split(";");
        Object[] objects = chuoiketqua2(data[1]);
        result += data[0] + ";" + objects[0] + "," + objects[1];
        return result;
    }

}
