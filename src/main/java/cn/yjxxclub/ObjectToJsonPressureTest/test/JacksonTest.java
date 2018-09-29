package cn.yjxxclub.ObjectToJsonPressureTest.test;

import cn.yjxxclub.ObjectToJsonPressureTest.Common;
import cn.yjxxclub.ObjectToJsonPressureTest.entity.Book;
import cn.yjxxclub.ObjectToJsonPressureTest.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-6-28
 * Time: 上午10:51
 * Describe: jackson
 */
public class JacksonTest {
    public static void main(String[] args){
        Book book = new Book();
        book.setId(1);
        book.setName("aa");
        book.setPrice(22.1);
        book.setPublish(false);
        book.setCreateDate(new Date());
        String str = "{\"createDate\":1498616533082,\"id\":1,\"name\":\"aa\",\"price\":22.1,\"publish\":false}";

        long times = Common.TEST_TIMES;
        ObjectMapper objectMapper =new ObjectMapper();
        for (int i =0;i<12;i++){
            Date date = new Date();
            //serialize(objectMapper,book,times);
            deserialize(objectMapper,str,times);
            logTime(DateUtil.totalTime(date));
        }
    //    deserialize(objectMapper,str,times);
    }

    public static void logTime(Object obj){
        System.out.println(obj);
    }
    /**
     * 序列化
     */
    public static void serialize(ObjectMapper objectMapper,Object obj,long times){
        //每次迭代为其分配地址
        try{

            for (int i=0;i<times;i++) {
                String out = objectMapper.writeValueAsString(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    public static void deserialize(ObjectMapper objectMapper,String str,long times){
        try{
            for (int i=0;i<times;i++){
                Book book = objectMapper.readValue(str,Book.class);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
