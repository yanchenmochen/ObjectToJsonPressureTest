package cn.yjxxclub.ObjectToJsonPressureTest.test;

import cn.yjxxclub.ObjectToJsonPressureTest.Common;
import cn.yjxxclub.ObjectToJsonPressureTest.entity.Book;
import cn.yjxxclub.ObjectToJsonPressureTest.util.DateUtil;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-6-28
 * Time: 上午11:06
 * Describe:Gson
 */
public class GsonTest {
    public static void main(String[] args){

        Book book = new Book();
        book.setId(1);
        book.setName("aa");
        book.setPrice(22.1);
        book.setPublish(false);
        book.setCreateDate(new Date());
        String str = "{\"createDate\":1498616533082,\"id\":1,\"name\":\"aa\",\"price\":22.1,\"publish\":false}";

        long times = Common.TEST_TIMES;

        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new com.google.gson.JsonDeserializer() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException{
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();
        for (int i =0;i<12;i++){
            Date date = new Date();
            //serialize(gson,book,times);
            deserialize(gson,str,times);
            logTime(DateUtil.totalTime(date));
        }
       // deserialize(gson,str,times);
    }

    public static void logTime(Object obj){
        System.out.println(obj);
    }
    /**
     * 序列化
     */
    public static void serialize(Gson gson,Object obj,long times){
        //每次迭代为其分配地址
        try{

            for (int i=0;i<times;i++) {
                String out = gson.toJson(obj);
            }
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    public static void deserialize(Gson gson,String str,long times){
            for (int i=0;i<times;i++){
                Book book = gson.fromJson(str,Book.class);
        }
    }
}
