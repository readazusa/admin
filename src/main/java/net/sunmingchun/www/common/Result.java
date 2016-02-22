
package net.sunmingchun.www.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息结果表
 */
public final class Result {
    public  static  String SUCCESS="SUCCESS";

    public static String ERROR="ERROR";

    private String code=SUCCESS;

    public Object obj = null;

    private String msg="成功";

    public Result(){

    }
    public Result(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Result(String code,Object obj){
        this.code=code;
        this.obj=obj;
    }

    public Result(String code,String msg,Object obj){
        this(code,msg);
        this.obj=obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
