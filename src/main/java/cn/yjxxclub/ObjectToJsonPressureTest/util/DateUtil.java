package cn.yjxxclub.ObjectToJsonPressureTest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-6-28
 * Time: 上午10:35
 * Describe:时间工具类
 */
public class DateUtil {
    /**
     * 当前时间
     * @return
     */
    public static String getTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S ");
        return format.format(new Date());
    }

    public static String getformat(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S ");
        return format.format(date);
    }

    public static long totalTime(Date old){
        Date now = new Date();
        return now.getTime()-old.getTime();
    }
}
