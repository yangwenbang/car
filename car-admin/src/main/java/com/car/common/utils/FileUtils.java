package com.car.common.utils;


import com.car.common.utils.File.HtmlVo;

import java.io.*;

/**
 * 文件操作类
 */
public class FileUtils {

    public static String readfile(String filePath) {
        File file = new File(filePath);
        InputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        byte[] bytes = new byte[1024];
        try {
            for (int n; (n = input.read(bytes)) != -1; ) {
                buffer.append(new String(bytes, 0, n, "utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public  static HtmlVo getBody(String val) {
        HtmlVo vo=new HtmlVo();
        String start = "<span id=\"title\">";
        String end = " <div class=\"ic\">";
        int s = val.indexOf(start) + start.length();
        int e = val.indexOf(end);
        vo.setTitle( val.substring(s, e-32));


        String start2 = "<div class=\"ic\">";
        String end2 = "</body>";
        int s1 = val.indexOf(start2) + start2.length();
        int e1 = val.indexOf(end2);
        vo.setContent( val.substring(s1, e1-20));
        return vo;
    }


    public static void deleteFile(String disrPath,String fileName){
        File file=new File(disrPath+"/"+fileName);
        if(file.exists()&&file.isFile()) {
            file.delete();
        }
    }

    /**
     * @param filePath 设定模板文件
     * @param disrPath 生成html的存放路径
     * @param fileName 生成html名字
     * @return void    返回类型
     * @throws
     * @Title: MakeHtml
     * @Description: 创建html
     */
    public static void makeHtml(String filePath,String disrPath,String title, String content,  String fileName) {
        try {
            String templateContent = "";
            FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
            int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();
            templateContent = new String(bytes);
            templateContent = templateContent.replaceAll("###content###", content);
            templateContent = templateContent.replaceAll("###title###", title);

            String fileame = fileName + ".html";
            fileame = disrPath + "/" + fileame;// 生成的html文件保存路径。
            deleteFile(disrPath,fileame);
            FileOutputStream fileoutputstream = new FileOutputStream(fileame);// 建立文件输出流
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }


    public static void main(String[] args) {
        //FileUtils.makeHtml("C:\\holly7\\gitee\\car-back\\car-webui\\help\\template.html","C:\\holly7\\gitee\\car-back\\car-webui\\help","教师","<p>111</p>","111");
        String body= FileUtils.readfile("C:\\holly7\\gitee\\car-back\\car-webui\\help\\111.html");
        System.out.println(FileUtils.getBody(body));
    }

}
