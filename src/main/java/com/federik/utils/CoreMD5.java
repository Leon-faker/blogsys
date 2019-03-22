package com.federik.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class CoreMD5
{
    public static final String strMD5Encode32(String strSource)
    {
        String strResult = "";
        try
        {
            strResult = strMD5Encode32WithErr(strSource);
        }
        catch (UnsupportedEncodingException ex)
        {
            strResult = "";
        }

        return strResult;
    }

    public static final String strMD5Encode32WithErr(String strSource) throws UnsupportedEncodingException
    {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(strSource.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 16) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString().toLowerCase();
    }

    public static final String strMD5Encode16(String strSource)
    {
        String strResult = "";
        try
        {
            strResult = strMD5Encode16WithErr(strSource);
        }
        catch (UnsupportedEncodingException ex)
        {
            strResult = "";
        }

        return strResult;
    }

    public static final String strMD5Encode16WithErr(String strSource) throws UnsupportedEncodingException
    {
        byte[] hash;
        try
        {
            hash = MessageDigest.getInstance("MD5").digest(strSource.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 16) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.substring(8, 24).toString().toLowerCase();
    }

    public static final String strMD5File(String inputFile)
    {
        String strresult = "";
        try
        {
            strresult = fileMD5(inputFile);
        }
        catch (IOException ioex)
        {
            strresult = "";
        }
        return strresult;
    }

    public static String fileMD5(String inputFile) throws IOException
    {
        int bufferSize = 262144;

        FileInputStream fileInputStream = null;

        DigestInputStream digestInputStream = null;
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            fileInputStream = new FileInputStream(inputFile);
            digestInputStream = new DigestInputStream(fileInputStream, messageDigest);

            byte[] buffer = new byte[bufferSize];
            while (digestInputStream.read(buffer) > 0);
            messageDigest = digestInputStream.getMessageDigest();

            byte[] resultByteArray = messageDigest.digest();

            return CmpBaseData.byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return "";
        } finally {
            try {
                digestInputStream.close();
            }
            catch (Exception localException4) {
            }
            try {
                fileInputStream.close();
            }
            catch (Exception localException5)
            {
            }
        }
    }
}