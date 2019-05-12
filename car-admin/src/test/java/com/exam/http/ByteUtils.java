package com.car.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteUtils
{
    public static int searchByte(byte[] bytes, byte[] targetBytes)
    {
        if (bytes.length == 0 || targetBytes.length == 0)
        {
            return -2;
        }
        else
        {
            for (int i = 0; i < bytes.length; i++)
            {
                if (bytes[i] == targetBytes[0])
                {
                    for (int j = 1; j < targetBytes.length; j++)
                    {
                        if (bytes[i + j] != targetBytes[j])
                        {
                            break;
                        }
                        if (j == targetBytes.length - 1)
                        {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

    }

    public static byte[] toByteArray(InputStream input) throws IOException
    {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy(input, output);
        return output.toByteArray();
    }

    public static int copy(InputStream input, OutputStream output) throws IOException
    {
        long count = copyLarge(input, output);
        if (count > 2147483647L)
        {
            return -1;
        }
        return (int) count;
    }

    public static long copyLarge(InputStream input, OutputStream output) throws IOException
    {
        byte[] buffer = new byte[4096];
        long count = 0L;
        int n = 0;
        while (-1 != (n = input.read(buffer)))
        {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
}
