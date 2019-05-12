package com.car.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.List;
import java.util.Map;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.StringUtil;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * 用于模拟HTTP请求中GET/POST方式
 * 
 * @author huanglonghao
 *
 */
public class HttpUtils
{


    public static String sendHttpGet(String url, String param) {
        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * 发送GET请求
     * 
     * @param url 目的地址
     * @param parameters 请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendGet(String url, Map<String, String> parameters)
    {
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try
        {
            if(parameters!=null) {
                // 编码请求参数
                if (parameters.size() == 1) {
                    for (String name : parameters.keySet()) {
                        sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
                    }
                    params = sb.toString();
                } else {
                    for (String name : parameters.keySet()) {
                        sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8")).append("&");
                    }
                    String temp_params = sb.toString();
                    params = temp_params.substring(0, temp_params.length() - 1);
                }
            }
            String full_url = url + "?" + params;
            System.out.println(full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet())
            {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            int RESPONSECODE = httpConn.getResponseCode();
            if (RESPONSECODE == HttpURLConnection.HTTP_OK)
            {
                InputStream inStrm = httpConn.getInputStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
            }
            else
            {
                // 当不是正确返回的时候需要使用这句httpConn.getErrorStream();
                InputStream inStrm = httpConn.getErrorStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static byte[] sendPostWithFileInputStream(String url, Map<String, String> parameters, Map<String, InputStream> files)
    {
        BufferedReader in = null;// 读取响应输入流
        DataOutputStream out = null;
        InputStream resultsb = null;
        byte[] bytes = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try
        {
            // 编码请求参数
            if (parameters.size() == 1)
            {
                for (String name : parameters.keySet())
                {
                    String value = parameters.get(name);
                    value = java.net.URLEncoder.encode(value, "UTF-8");
                    sb.append(name).append("=").append(value);
                }
                params = sb.toString();
            }
            else
            {
                for (String name : parameters.keySet())
                {
                    String value = parameters.get(name);
                    if (StringUtil.hasValue(value))
                    {
                        // value = java.net.URLEncoder.encode(value, "UTF-8");
                        sb.append(name).append("=").append(value).append("&");
                    }
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }

            url = String.format("%s?%s", url, params);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url);
            // 打开URL连接
            HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            httpConn.setRequestMethod("POST");
            // 获取HttpURLConnection对象对应的输出流
            out = new DataOutputStream(httpConn.getOutputStream());
            // 发送请求参数
            // out.write(params.getBytes());
            long length = 0;
            if (files != null)
            {
                for (String key : files.keySet())
                {
                    InputStream is = files.get(key);
                    byte[] buffer = new byte[2048];
                    int len = 0;

                    while ((len = is.read(buffer)) != -1)
                    {
                        length += len;
                        out.write(buffer, 0, len);
                    }
                    is.close();
                }
            }
            System.out.println(url);
            System.out.println(length);
            // flush输出流的缓冲
            out.flush();
            int RESPONSECODE = httpConn.getResponseCode();
            if (RESPONSECODE == HttpURLConnection.HTTP_OK)
            {
                resultsb = httpConn.getInputStream();
                bytes = ByteUtils.toByteArray(resultsb);
            }
            else
            {
                resultsb = httpConn.getErrorStream();
                bytes = ByteUtils.toByteArray(resultsb);
            }
            httpConn.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }

            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return bytes;
    }

    public static String sendPostWithFile(String url, Map<String, String> parameters, Map<String, InputStream> files)
    {
        BufferedReader in = null;// 读取响应输入流
        DataOutputStream out = null;
        StringBuffer resultsb = new StringBuffer();
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try
        {
            // 编码请求参数
            if (parameters.size() == 1)
            {
                for (String name : parameters.keySet())
                {
                    String value = parameters.get(name);
                    value = java.net.URLEncoder.encode(value, "UTF-8");
                    sb.append(name).append("=").append(value);
                }
                params = sb.toString();
            }
            else
            {
                for (String name : parameters.keySet())
                {
                    String value = parameters.get(name);
                    if (StringUtil.hasValue(value))
                    {
                        // value = java.net.URLEncoder.encode(value, "UTF-8");
                        sb.append(name).append("=").append(value).append("&");
                    }
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }

            url = String.format("%s?%s", url, params);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url);
            // 打开URL连接
            HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            httpConn.setRequestMethod("POST");
            // 获取HttpURLConnection对象对应的输出流
            out = new DataOutputStream(httpConn.getOutputStream());
            // 发送请求参数
            // out.write(params.getBytes());
            long length = 0;
            if (files != null)
            {
                for (String key : files.keySet())
                {
                    InputStream is = files.get(key);
                    byte[] buffer = new byte[2048];
                    int len = 0;

                    while ((len = is.read(buffer)) != -1)
                    {
                        length += len;
                        out.write(buffer, 0, len);
                    }
                    is.close();
                }
            }
            System.out.println(url);
            System.out.println(length);
            // flush输出流的缓冲
            out.flush();
            int RESPONSECODE = httpConn.getResponseCode();
            if (RESPONSECODE == HttpURLConnection.HTTP_OK)
            {
                InputStream inStrm = httpConn.getInputStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    resultsb.append(line);
                }
            }
            else
            {
                // 当不是正确返回的时候需要使用这句httpConn.getErrorStream();
                InputStream inStrm = httpConn.getErrorStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    resultsb.append(line);
                }
            }
            httpConn.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }

            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return resultsb.toString();
    }

    public static String postFile(String url, Map<String, byte[]> files) throws Exception,ConnectException
    {
        StringBuilder sb2 = null;
        String BOUNDARY = java.util.UUID.randomUUID().toString();
        String PREFIX = "--", LINEND = "\r\n";
        String MULTIPART_FROM_DATA = "multipart/form-data";
        String CHARSET = "UTF-8";
        // 创建URL对象
        java.net.URL connURL = new java.net.URL(url);
        // 打开URL连接
        HttpURLConnection conn = (HttpURLConnection) connURL.openConnection();

        conn.setReadTimeout(6 * 1000); // 缓存的最长时间
        conn.setDoInput(true);// 允许输入
        conn.setDoOutput(true);// 允许输出
        conn.setUseCaches(false); // 不允许使用缓存
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "keep-alive");
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA + ";boundary=" + BOUNDARY);
        
        	// 报错了 java.net.ConnectException: Connection refused
        DataOutputStream outStream  = new DataOutputStream(conn.getOutputStream());
        InputStream in = null;
        // 发送文件数据
        if (files != null) {
            for (Map.Entry<String, byte[]> file : files.entrySet()) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(PREFIX);
                sb1.append(BOUNDARY);
                sb1.append(LINEND);
                sb1.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getKey() + "\"" + LINEND);
                sb1.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINEND);
                sb1.append(LINEND);
                outStream.write(sb1.toString().getBytes());
                outStream.write(file.getValue());
                outStream.write(LINEND.getBytes());
            }
            // 请求结束标志
            byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
            outStream.write(end_data);
            outStream.flush();
            // 得到响应码
            int res = conn.getResponseCode();
            if (res == 200){
                in = conn.getInputStream();
                int ch;
                sb2 = new StringBuilder();
                while ((ch = in.read()) != -1){
                    sb2.append((char) ch);
                }
                System.out.println(sb2.toString());
            }
            outStream.close();
            conn.disconnect();
            // 解析服务器返回来的数据
            return sb2.toString();
        } else{
            return "Update icon Fail";
        }
    }

    /**
     * 发送POST请求
     * 
     * @param url 目的地址
     * @param parameters 请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendPost(String url, Map<String, String> parameters)
    {
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try
        {
            // 编码请求参数
            if (parameters.size() == 1)
            {
                for (String name : parameters.keySet())
                {
                    sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
                }
                params = sb.toString();
            }
            else
            {
                for (String name : parameters.keySet())
                {
                    sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url);
            // 打开URL连接
            HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();
            int RESPONSECODE = httpConn.getResponseCode();
            if (RESPONSECODE == HttpURLConnection.HTTP_OK)
            {
                InputStream inStrm = httpConn.getInputStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
            }
            else
            {
                // 当不是正确返回的时候需要使用这句httpConn.getErrorStream();
                InputStream inStrm = httpConn.getErrorStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 发送POST请求
     * 
     * @param url 目的地址
     * @param parameters 请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendPost(String url, Map<String, String> parameters, Map<String, String> headers)
    {
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try
        {
            params = JsonUtils.writeValueAsString(parameters);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url);
            // 打开URL连接
            HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            for (String name : headers.keySet())
            {
                httpConn.setRequestProperty(name, headers.get(name));
            }
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();

            int RESPONSECODE = httpConn.getResponseCode();
            if (RESPONSECODE == HttpURLConnection.HTTP_OK)
            {
                InputStream inStrm = httpConn.getInputStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
            }
            else
            {
                // 当不是正确返回的时候需要使用这句httpConn.getErrorStream();
                InputStream inStrm = httpConn.getErrorStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String sendPost(String url, Map<String, String> headers, String params)
    {
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        try
        {

            // params=param;
            java.net.URL connURL = new java.net.URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            for (String name : headers.keySet())
            {
                httpConn.setRequestProperty(name, headers.get(name));
            }
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            httpConn.setUseCaches(false);
            out = new PrintWriter(httpConn.getOutputStream());
            out.write(params);
            out.flush();
            int RESPONSECODE = httpConn.getResponseCode();
            if (RESPONSECODE == HttpURLConnection.HTTP_OK)
            {
                InputStream inStrm = httpConn.getInputStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
                System.out.println(sb.toString());
            }
            else
            {
                // 当不是正确返回的时候需要使用这句httpConn.getErrorStream();
                InputStream inStrm = httpConn.getErrorStream();
                in = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null)
                {
                    sb.append(line);
                }
                System.out.println(sb.toString());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static OutputStream GetImgStream(String url)
    {
        try
        {

            java.net.URL connURL = new java.net.URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
            int RESPONSECODE = httpConn.getResponseCode();
            if (RESPONSECODE == HttpURLConnection.HTTP_OK)
            {
                InputStream is = httpConn.getInputStream();
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                byte b[] = new byte[1024];
                int num = 0;
                while ((num = is.read(b)) != -1)
                {
                    os.write(b, 0, num);
                }
                return os;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
        }
        return null;

    }

}