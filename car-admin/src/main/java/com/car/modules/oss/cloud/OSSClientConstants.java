package  com.car.modules.oss.cloud;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @ClassName: OSSClientConstants
 * @Description: OSS阿里云常用变量
 * @author wy
 * @date 2017年5月5日 上午11:56:25
 *
 */
public class OSSClientConstants {
    //阿里云API的外网域名  
    public static final String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
    //阿里云API的密钥Access Key ID  
    public static final String ACCESS_KEY_ID = "LTAIr38RtWoJdUwN";
    //阿里云API的密钥Access Key Secret  
    public static final String ACCESS_KEY_SECRET = "UgmPNxHxChVL74OLdgE8C2pplBygkD";
    //阿里云API的bucket名称  
    public static final String BACKET_NAME = "jxcar";
    //阿里云API的文件夹名称  
    public static final String FOLDER="find/";
    public static final String FOLDER_VIDEO="video/";
    public static final String FORMAT = new SimpleDateFormat("yyyyMMdd").format(new Date());
    public static final String FORMATS = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
}