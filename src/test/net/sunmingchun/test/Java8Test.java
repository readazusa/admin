package net.sunmingchun.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/3/2.
 * Email:sunmch@163.com
 */
public class Java8Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("smc","ty");
        list.forEach(a->{
            System.out.println(a);
        });
//        Collections.sort(list,(String a,String b)->{
//                return a.compareTo(b);
//        });




    }
}
