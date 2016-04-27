package net.sunmingchun.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/4/7.
 * Email:sunmch@163.com
 */
public class BigFileTest {
    public static void main(String[] args) {
        File file = new File("E:"+ File.separator+"123.MKV");
        File target = new File("E:"+ File.separator+"111.mp4");
        try {
            long s = System.currentTimeMillis();
            FileUtils.copyFile(file,target);
            long e = System.currentTimeMillis();
            System.out.println("花费时间: "+ (e-s)+"毫秒");
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
