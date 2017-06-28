package cn.yjxxclub.ObjectToJsonPressureTest.test;

import cn.yjxxclub.ObjectToJsonPressureTest.Common;
import cn.yjxxclub.ObjectToJsonPressureTest.entity.Book;
import cn.yjxxclub.ObjectToJsonPressureTest.util.DateUtil;
import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-6-28
 * Time: 上午9:52
 * Describe: fastJSON
 */
public class FastJsonTest {

    public static void main(String[] args){
        Book book = new Book();
        book.setId(1);
        book.setName("aa");
        book.setPrice(22.1);
        book.setPublish(false);
        book.setCreateDate(new Date());
        String str = "{\"createDate\":1498616533082,\"id\":1,\"name\":\"aa\",\"price\":22.1,\"publish\":false}";

        long times = Common.TEST_TIMES;
        //logTime();
        for (int i =0;i<12;i++){
            Date date = new Date();
            deserialize(str,times);
            //serialize(book,times);
            logTime(DateUtil.totalTime(date));
        }
    }
    public static void logTime(){
        System.out.println(DateUtil.getTime());
    }
    public static void logTime(Object obj){
        System.out.println(obj);
    }
    /**
     * 序列化
     */
    public static void serialize(Object obj,long times){
        //每次迭代为其分配地址
        for (int i=0;i<times;i++){
            String out = JSON.toJSONString(obj).toString();
        }
    }

    /**
     * 反序列化
     */
    public static void deserialize(String str,long times){
        for (int i=0;i<times;i++){
            Book book = JSON.parseObject(str,Book.class);
        }
    }
}
