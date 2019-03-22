package com.federik.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

public class CmpBaseData {
    public static String byteArrayToHex(byte[] byteArray)
    {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        char[] resultCharArray = new char[byteArray.length * 2];

        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[(index++)] = hexDigits[(b >>> 4 & 0xF)];
            resultCharArray[(index++)] = hexDigits[(b & 0xF)];
        }

        return new String(resultCharArray);
    }

    public static String byteToHexStr(byte bytes)
    {
        int i = (bytes & 0xF0) >>> 4;
        int j = bytes & 0xF;
        char c1;
        if (i > 9)
            c1 = (char)(i - 10 + 65);
        else
            c1 = (char)(i + 48);
        char c2;
        if (j > 9)
            c2 = (char)(j - 10 + 65);
        else
            c2 = (char)(j + 48);
        String s = String.valueOf(c1) + String.valueOf(c2);
        return s;
    }

    public static String getRandomStringWithLenth(int length)
    {
        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(3);
            long result = 0L;

            switch (number)
            {
                case 0:
                    result = Math.round(Math.random() * 25.0D + 65.0D);
                    sb.append(String.valueOf((char)(int)result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25.0D + 97.0D);
                    sb.append(String.valueOf((char)(int)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }

        return sb.toString();
    }

    public static FileInputStream FIFromI(InputStream in)
    {
        FileInputStream fin = null;

        if (in instanceof FileInputStream) {
            fin = (FileInputStream)in;
        }

        return fin;
    }
}
