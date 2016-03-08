package net.sunmingchun.www.test.po;

import java.io.Serializable;

/**
 * net.sunmingchun.www.test.po
 * Created by smc
 * date on 2016/3/8.
 * Email:sunmch@163.com
 */
public class ObjInfo implements Serializable {

    private String name;

    private String no;

    public ObjInfo(String name, String no) {
        this.name = name;
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

