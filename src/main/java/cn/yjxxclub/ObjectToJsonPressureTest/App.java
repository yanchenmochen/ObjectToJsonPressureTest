package cn.yjxxclub.ObjectToJsonPressureTest;

import cn.yjxxclub.ObjectToJsonPressureTest.test.FastJsonTest;
import cn.yjxxclub.ObjectToJsonPressureTest.test.GsonTest;
import cn.yjxxclub.ObjectToJsonPressureTest.test.JacksonTest;
import cn.yjxxclub.ObjectToJsonPressureTest.test.JsonlibTest;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        FastJsonTest.main(args);
        System.out.println("================");
        JacksonTest.main(args);
        System.out.println("================");
        GsonTest.main(args);
//        System.out.println("================");
//        JsonlibTest.main(args);
        System.out.println("End");
    }
}
