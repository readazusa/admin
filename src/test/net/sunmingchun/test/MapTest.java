package net.sunmingchun.test;

import java.util.HashMap;
import java.util.Map;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        System.out.println(map.isEmpty()+" , size: "+ map.size());
    }
}
